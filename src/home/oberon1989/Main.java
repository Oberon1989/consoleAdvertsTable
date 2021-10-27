package home.oberon1989;

import home.oberon1989.util.ConsoleInputFilter;
import home.oberon1989.views.AdvertView;
import home.oberon1989.views.UserView;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserView userView = new UserView();
        AdvertView advertView = new AdvertView();
        boolean isWork = true;

        while (isWork) {
            System.out.println("1: Список объявлений");
            System.out.println("2: Список пользователей");
            System.out.println("3: Выход");
            System.out.println();
            System.out.println("Выберите пункт меню.");
            int action = ConsoleInputFilter.getIntValue(1, 3);
            switch (action) {
                case 1:
                    advertView.View();
                    break;
                case 2:
                    userView.View();
                    break;
                case 3:
                    isWork = false;
                    break;
            }
        }


    }
}
