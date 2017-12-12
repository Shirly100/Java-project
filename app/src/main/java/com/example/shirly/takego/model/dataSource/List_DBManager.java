package com.example.shirly.takego.model.dataSource;

import android.content.ContentValues;

import com.example.shirly.takego.model.backend.ICarManager;
import com.example.shirly.takego.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToClient;

/**
 * Created by Shirly on 12/12/2017.
 */

public class List_DBManager implements ICarManager {
    static List<Client> clients;
    static {
        clients = new ArrayList<>();

    }

    @Override
    public long addClient(ContentValues client) {
        Client item = ContentValuesToClient(client);
        clients.add(item);
        return item.getID();
    }

    @Override
    public List<Client> getClients() {
        return null;
    }

}
