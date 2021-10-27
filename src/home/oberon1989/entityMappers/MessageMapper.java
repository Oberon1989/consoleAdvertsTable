package home.oberon1989.entityMappers;

import home.oberon1989.entities.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements EntityMapper<Message> {
    @Override
    public Message mapField(ResultSet set) throws SQLException {
        return new Message(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(4), set.getDate(5), set.getBoolean(6));
    }
}
