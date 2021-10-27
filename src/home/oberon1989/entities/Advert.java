package home.oberon1989.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter

public class Advert {

    private int id;
    private String name;
    private String description;
    private int ownerUserid;
    private double price;


}
