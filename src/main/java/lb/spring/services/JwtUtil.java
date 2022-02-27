package lb.spring.services;

import lb.spring.entities.Role;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lb.spring.dto.UserDto;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    static final  String  SECRETKEY = "926D96C90030DD58429D2751AC1BDBBC";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDto userDto) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", userDto.getFirstName() + " " + userDto.getLastName());
        claims.put("role", userDto.getRole() );
        if(userDto.getRole()!= Role.SUPER_ADMIN) {
            claims.put("region", userDto.getRegion().getRegion());
        }
        return createToken(claims, userDto.getEmail());
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60*60*24 ))
                .signWith(SignatureAlgorithm.HS256, SECRETKEY).compact();
    }


    public String generateTokenByEmail (String email){
	      
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() +1000*120 ))
				.signWith(SignatureAlgorithm.HS512, SECRETKEY )
				.compact();
	   
   }
}