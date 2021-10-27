package home.oberon1989.managers;

import home.oberon1989.entityMappers.EntityMapper;
import home.oberon1989.data.JdbcManager;

import java.sql.SQLException;
import java.util.List;

public interface Manager<T> {


    default List<T> get(int id, String tableName, String columnForFilter, EntityMapper mapper) throws SQLException {
        return JdbcManager.getEntityFromDb(mapper, String.format("SELECT * FROM %s WHERE %s=%s", tableName, columnForFilter, id));
    }

    default List<T> get(String tableName, EntityMapper mapper) throws SQLException {
        return JdbcManager.getEntityFromDb(mapper, String.format("SELECT * FROM %s", tableName));
    }

    default String getColumnTextValueById(int id, String tableName, String columnName) throws SQLException {
        return JdbcManager.getColumnTextValueById(id, tableName, columnName);
    }


    void add(T entity);


    void update(T entity);

    void delete(T entity);


}
