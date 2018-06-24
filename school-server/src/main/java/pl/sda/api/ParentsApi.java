package pl.sda.api;


import pl.sda.model.Parents;

import java.util.List;

public interface ParentsApi {

    Parents create();

    Parents delete();

    Parents edit();

    Parents find();

    List<Parents> findAll();
}
