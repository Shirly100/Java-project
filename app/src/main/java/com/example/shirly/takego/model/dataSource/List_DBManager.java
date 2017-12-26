package com.example.shirly.takego.model.dataSource;

import android.content.ContentValues;

import com.example.shirly.takego.model.backend.ICarManager;
import com.example.shirly.takego.model.entities.Branch;
import com.example.shirly.takego.model.entities.Car;
import com.example.shirly.takego.model.entities.CarModel;
import com.example.shirly.takego.model.entities.Client;
import com.example.shirly.takego.model.entities.Login;

import java.util.ArrayList;
import java.util.List;

import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToBranch;
import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToCar;
import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToCarModel;
import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToClient;
import static com.example.shirly.takego.model.backend.CarConst.ContentValuesToLogin;

/**
 * Created by Shirly on 12/12/2017.
 */

public class List_DBManager implements ICarManager {
    static List<Client> clients;
    static List<Car> cars;
    static List<Branch> branches;
    static List<CarModel> models;
    static List<Login> users;
    static {
        clients = new ArrayList<>();
        cars = new ArrayList<>();
        branches = new ArrayList<>();
        models = new ArrayList<>();
        users = new ArrayList<>();

    }
    @Override
    public String addUser(ContentValues user) {
        Login item = ContentValuesToLogin(user);
        users.add(item);
        return item.getUser();
    }

    @Override
    public long addClient(ContentValues client) {
        Client item = ContentValuesToClient(client);
        clients.add(item);
        return item.getID();
    }
    @Override
    public long addCar(ContentValues car) {
        Car item = ContentValuesToCar(car);
        cars.add(item);
        return item.getCarNumber();
    }
    @Override
    public int addBranch(ContentValues branch) {
        Branch item = ContentValuesToBranch(branch);
        branches.add(item);
        return item.getBranchNumber();
    }
    @Override
    public String addCarModel(ContentValues model) {
        CarModel item = ContentValuesToCarModel(model);
        models.add(item);
        return item.getModelCode();
    }

    @Override
    public List<Client> getClients() {
        return null;
    }
    @Override
    public List<Car> getCars() {return null;}
    @Override
    public List<Branch> getBranches() {return null;}
    @Override
    public List<CarModel> getModels() {return null;}
    @Override
    public List<Login> getUsers() {return null;}
    @Override
    public boolean isExistClient(ContentValues values) {return false;}

}
