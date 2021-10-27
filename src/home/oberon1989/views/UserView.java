package home.oberon1989.views;

import home.oberon1989.util.BuilderViewString;
import home.oberon1989.util.ConsoleInputFilter;

import java.sql.SQLException;

public class UserView implements ConsoleView {


    @Override

    public void View() throws SQLException {
        boolean isRun = true;
        while (isRun) {

            System.out.println(BuilderViewString.getUsersString());
            System.out.println("Выберите пользователя по его Id цифрами 0-9\n");
            int userId = ConsoleInputFilter.getIntValue();
            if (!BuilderViewString.isUserExistById(userId)) {
                System.out.println("Неверный id! Пользователь с id" + userId + " не найден!\"");
                continue;
            }
            boolean isCancel;
            do {
                isCancel = false;
                System.out.println("1. Просмотреть профиль пользователя.");
                System.out.println("2. Просмотреть обьявления пользователя.");
                System.out.println("3. Просмотреть комментарии пользователя.");
                System.out.println("4. Вернуться в предыдущее меню.\n");
                System.out.println("5. Выйти из просмотра пользователей.\n");
                int action = ConsoleInputFilter.getIntValue(1, 5);
                switch (action) {
                    case 1:
                        System.out.println(BuilderViewString.getUserStringById(userId));
                        break;
                    case 2:
                        System.out.println(BuilderViewString.getAdvertsForUser(userId));

                        break;
                    case 3:
                        System.out.println(BuilderViewString.getCommentsByUserId(userId));
                        break;
                    case 4:
                        isCancel = true;
                        break;
                    case 5:
                        isRun = false;
                        isCancel = true;
                        break;
                    default:
                        System.out.println("Команда не распознана!");
                        break;
                }
            }
            while (!isCancel);
        }
    }
}
