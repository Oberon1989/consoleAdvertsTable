package home.oberon1989.entityMappers;

import home.oberon1989.entities.Advert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdvertMapper implements EntityMapper<Advert> {
    @Override
    public Advert mapField(ResultSet set) throws SQLException {
        return new Advert(set.getInt("id"), set.getString("name"), set.getString("description"), set.getInt("owner_user_id"), set.getDouble("price"));
    }
}
