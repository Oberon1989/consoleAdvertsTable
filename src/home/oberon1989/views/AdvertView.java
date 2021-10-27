package home.oberon1989.views;

import home.oberon1989.util.BuilderViewString;

import java.sql.SQLException;

public class AdvertView implements ConsoleView {
    @Override
    public void View() throws SQLException {
        System.out.println(BuilderViewString.getAdvertsString());
    }
}
