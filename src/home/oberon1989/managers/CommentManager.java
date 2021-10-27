package home.oberon1989.managers;

import home.oberon1989.entities.Comment;
import home.oberon1989.entityMappers.CommentMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class CommentManager implements Manager<Comment> {
    private CommentMapper mapper;


    @Override
    public void add(Comment entity) {

    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(Comment entity) {

    }
}
