package home.oberon1989.managers;

import home.oberon1989.entities.User;
import home.oberon1989.entityMappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserManager implements Manager<User> {

    private UserMapper mapper;

    @Override
    public void add(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
