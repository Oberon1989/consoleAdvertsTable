package home.oberon1989.entityMappers;

import home.oberon1989.entities.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements EntityMapper<Comment> {
    @Override
    public Comment mapField(ResultSet set) throws SQLException {
        return new Comment(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(4), set.getString(5));
    }
}
