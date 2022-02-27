package lb.spring.configurations;


import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


import java.io.Serializable;

public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl implements Serializable {

@Override
public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(name.getText(), !name.isQuoted());
        }

@Override
public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier(name.getText(), !name.isQuoted());
        }


}

