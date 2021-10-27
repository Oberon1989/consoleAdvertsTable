package home.oberon1989.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Message {
    private int id;
    private int userIdFrom;
    private int userIdTo;
    private String messageText;
    private Date date;
    private boolean isReading;


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                ", messageText='" + messageText + '\'' +
                ", date=" + date +
                ", isReading=" + isReading +
                '}';
    }
}
