package home.oberon1989.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String phone;
    private int rating;
    private double balance;


    @Override
    public String toString() {
        return String.format("Пользователь:\nLogin: %s\nPassword: %s\nEmail: %s\nPhone: %s\nBalance: %s\nRating: %s", login, password, email, phone, balance, rating);
    }
}
