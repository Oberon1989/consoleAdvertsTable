package home.oberon1989.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Comment {
    private int id;
    private int advertId;
    private int ownerUserId;
    private String commentText;
    private String date;

}
