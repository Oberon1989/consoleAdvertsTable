package home.oberon1989.entityMappers;

import home.oberon1989.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User mapField(ResultSet set) throws SQLException {
        return new User(set.getInt("id"),
                set.getString("login"), set.getString("password"), set.getString("email"), set.getString("phone"), set.getInt("rating"), set.getDouble("balance"));
    }
}
