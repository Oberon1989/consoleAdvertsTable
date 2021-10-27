package home.oberon1989.entityMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapper<T> {
    T mapField(ResultSet set) throws SQLException;
}
