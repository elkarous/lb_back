package lb.spring.services;

import lb.spring.dto.StatUser;
import lb.spring.entities.Camping;
import lb.spring.entities.Region;
import lb.spring.exceptions.ApiResponseException;
import lb.spring.repositories.CampingRepository;
import lb.spring.repositories.RegionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lb.spring.dto.UserDto;
import lb.spring.entities.UserEntity;
import lb.spring.repositories.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CampingRepository campingRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JavaMailSender emailSender;
    @Override
    public UserDto addUser(UserDto userDto) throws ApiResponseException, MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new ApiResponseException("this email is used");
        } else {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity user = modelMapper.map(userDto, UserEntity.class);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setCreationDate(new java.util.Date());
            userRepository.save(user);
            String htmlMsg = "<h2>Profile</h2>"
                    +"<p> your account in lb consulting :</p>"
                    + "<h5>login:</h5>" + userDto.getEmail()
                    + "<h5>Password:</h5>" + userDto.getPassword();

            message.setContent(htmlMsg, "text/html");

            helper.setTo(userDto.getEmail());

            helper.setSubject("new profile");


            this.emailSender.send(message);

        }
        return userDto;
    }


    @Override
    public void updatePassword(UserDto userDto, String newPassword) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);

    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        if(getUserByEmail(userDto.getEmail())!=null){
        ModelMapper modelMapper = new ModelMapper();
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        userRepository.save(user);}
        else throw new ApiResponseException("user not found");
        return userDto;
    }

    @Override
    public UserDto getUserById(String id) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto;
        Optional<UserEntity> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ApiResponseException("there is no user with this id");
        } else {

            userDto = modelMapper.map(user.get(), UserDto.class);
        }

        return userDto;
    }
    @Override
    public List<Region> getRegion() {

        return regionRepository.findAll() ;
    }
    @Override
    public List<Camping> getCampingByRegion(String region) {
        return this.campingRepository.getCampingByRegion(region);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (UserEntity userEntity : users) {


            ModelMapper modelMapper = new ModelMapper();
            UserDto user = modelMapper.map(userEntity, UserDto.class);

            usersDto.add(user);
        }
        return usersDto;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDto getUserByEmail(String email) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto;
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new ApiResponseException("there is no user with this email");
        } else {

            userDto = modelMapper.map(user, UserDto.class);
        }

        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null) throw new UsernameNotFoundException(email);

        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
    @Override
    public StatUser getStat(){
        StatUser stat=new StatUser();
        stat.setFemale(userRepository.countFemale());
        stat.setMale(userRepository.findAll().size()-stat.getFemale());
        stat.setAdmin(userRepository.countAdmin());
        stat.setAgent(userRepository.countAgent());
        stat.setSuperAdmin(userRepository.findAll().size()-stat.getAdmin()-stat.getAgent());
        return stat;
    }
    @Override
    public void resetPassword(String id, String password){
        Optional<UserEntity> user=userRepository.findById(id);
        if(user.isPresent()){
            user.get().setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(user.get());
        }else throw new ApiResponseException("no user with this id");

    }
    @Override
    public List<UserEntity> getAllByRole(){
        return userRepository.getUsersWithoutAgent();
    }

    @Override
    public List<UserEntity> getAllAgentByRegion(String region){
        return userRepository.getUsersByRegion(region);
    }
}
