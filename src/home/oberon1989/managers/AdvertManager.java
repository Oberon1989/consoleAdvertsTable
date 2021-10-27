package home.oberon1989.managers;

import home.oberon1989.entities.Advert;
import home.oberon1989.entityMappers.AdvertMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AdvertManager implements Manager<Advert> {

    private AdvertMapper mapper;


    @Override
    public void add(Advert entity) {

    }


    @Override
    public void update(Advert entity) {

    }

    @Override
    public void delete(Advert entity) {

    }
}
