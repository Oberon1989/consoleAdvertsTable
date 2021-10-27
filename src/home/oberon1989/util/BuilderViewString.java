package home.oberon1989.util;

import home.oberon1989.entities.Advert;
import home.oberon1989.entities.User;
import home.oberon1989.entityMappers.AdvertMapper;
import home.oberon1989.entityMappers.CommentMapper;
import home.oberon1989.entityMappers.MessageMapper;
import home.oberon1989.entityMappers.UserMapper;
import home.oberon1989.managers.AdvertManager;
import home.oberon1989.managers.CommentManager;
import home.oberon1989.managers.MessageManager;
import home.oberon1989.managers.UserManager;

import java.sql.SQLException;

import java.util.Optional;


public class BuilderViewString {
    private static AdvertManager advertManager = new AdvertManager(new AdvertMapper());
    private static MessageManager messageManager = new MessageManager(new MessageMapper());
    private static CommentManager commentManager = new CommentManager(new CommentMapper());
    private static UserManager userManager = new UserManager(new UserMapper());

    //Получаем список пользователей
    public static String getUsersString() throws SQLException {
        StringBuilder builder = new StringBuilder();
        userManager.get("users", userManager.getMapper()).stream().forEach(user -> builder.append(String.format("Id: %s Login: %s\n", user.getId(), user.getLogin())));
        return builder.toString();
    }

    //получаем список объявлений с комментариями
    public static String getAdvertsString() throws SQLException {
        StringBuilder builder = new StringBuilder();
        advertManager.get("adverts", advertManager.getMapper()).forEach(advert ->
        {
            builder.append(getAdvertString(advert));
        });
        return builder.toString();
    }

    //возвращаем конкретного юзера в виде строки
    public static String getUserStringById(int id) throws SQLException {
        Optional<User> user = userManager.get(id, "users", "id", userManager.getMapper()).stream().findFirst();
        if (user.isPresent()) {
            return user.get().toString();
        } else {
            return "Неверный id! Пользователь с id " + id + " не найден!";
        }
    }


    public static boolean isUserExistById(int id) throws SQLException {
        return userManager.get(id, "users", "id", userManager.getMapper()).stream().findFirst().isPresent();
    }

    public static String getAdvertsForUser(int userId) throws SQLException {
        StringBuilder builder = new StringBuilder();
        advertManager.get(userId, "adverts", "owner_user_id", advertManager.getMapper()).forEach(advert -> {
            builder.append(getAdvertString(advert));

        });

        return builder.toString();

    }

    //конструируем и возвращаем конкретное обьявление с комментариями в виде строки
    public static String getAdvertString(Advert advert) {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append(String.format("Обьявление:\nId: %s\nВладелец: %s(Id: %s)\nИмя: %s\nОписание: %s\nЦена: %s\n", advert.getId(), userManager.getColumnTextValueById(advert.getOwnerUserid(), "users", "login"), advert.getOwnerUserid(), advert.getName(), advert.getDescription(), advert.getPrice()));
            commentManager.get(advert.getId(), "comments", "advert_id", commentManager.getMapper()).forEach(comment ->
            {
                try {
                    builder.append(String.format("%s (%s) %s\n дата: %s\n", userManager.getColumnTextValueById(comment.getOwnerUserId(), "users", "login"), comment.getOwnerUserId(), comment.getCommentText(), comment.getDate()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            System.out.println(builder);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return builder.toString();
    }

    public static String getCommentsByUserId(int userId) throws SQLException {
        StringBuilder builder = new StringBuilder();
        commentManager.get(userId, "comments", "owner_user_id", commentManager.getMapper()).stream().forEach(comment ->
        {
            try {
                builder.append(String.format("Комментарий\nid: %s\nразмещен в обьявлении: %s (Id: %s)\nТекст: %s\nДата: %s\n", comment.getId(), advertManager.getColumnTextValueById(comment.getAdvertId(), "adverts", "name"), comment.getAdvertId(), comment.getCommentText(), comment.getDate()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return builder.toString();
    }

}
