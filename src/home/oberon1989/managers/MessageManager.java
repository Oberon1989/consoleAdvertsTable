package home.oberon1989.managers;

import home.oberon1989.entities.Message;
import home.oberon1989.entityMappers.MessageMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageManager implements Manager<Message> {

    private MessageMapper mapper;


    @Override
    public void add(Message entity) {

    }

    @Override
    public void update(Message entity) {

    }

    @Override
    public void delete(Message entity) {

    }
}
