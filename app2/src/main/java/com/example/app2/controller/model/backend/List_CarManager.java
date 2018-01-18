package com.example.app2.controller.model.backend;

import android.content.ContentValues;

import com.example.app2.controller.model.entities.Order;

import java.util.ArrayList;
import java.util.List;

import com.example.app2.controller.model.entities.Branch;
import com.example.app2.controller.model.entities.Car;
import com.example.app2.controller.model.entities.CarModel;
import com.example.app2.controller.model.entities.Client;
import com.example.app2.controller.model.entities.Enums;
import com.example.app2.controller.model.entities.Login;
import com.example.app2.controller.model.entities.Order;

import static com.example.app2.controller.model.backend.CarConst.ContentValuesToBranch;
import static com.example.app2.controller.model.backend.CarConst.ContentValuesToCar;
import static com.example.app2.controller.model.backend.CarConst.ContentValuesToCarModel;
import static com.example.app2.controller.model.backend.CarConst.ContentValuesToClient;
import static com.example.app2.controller.model.backend.CarConst.ContentValuesToLogin;

/**
 * Created by Shirly on 11/15/2017.
 */

public class List_CarManager implements ICarManager
{
    static List<Branch> branches;
    static List<Car>cars;
    static List<CarModel>models;
    static List<Client>clients;
    static List<Order>orders;
    static List<Login>users;


    static {
        branches = new ArrayList<>();
        cars = new ArrayList<>();
        models = new ArrayList<>();
        clients = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();
    }

    @Override
   public  long addClient(ContentValues client)//throws Exception
    {
        Client item = ContentValuesToClient(client);
        int index=clients.indexOf(item);
        /*if (index!= -1)
        {
            throw new Exception("this client already exist.");
        }*/
        clients.add(item);
        return item.getID();

    }


    /*@Override
    public long removeClient(ContentValues client)throws Exception
    {
        Client item = ContentValuesToClient(client);
        int index=clients.indexOf(item);
        if (index== -1)
        {
            throw new Exception("this client is not exist.");
        }
        clients.remove(item);
        return item.getID();

    }
    @Override
    public long updateClient( ContentValues values)throws Exception
    {
        Client item = ContentValuesToClient(values);
        int index=clients.indexOf(item);
        if (index == -1) throw new Exception("You are trying to update non-existing client");
        clients.set(index, item);
        return item.getID();


    }*/
    @Override
    public List<Client> getClients()
    {
        return clients;
    }
    @Override
    public boolean isExistClient(ContentValues client)
    {
        Client item = ContentValuesToClient(client);
        for (int i = 0; i < factory_dal.get_dal().getClients().size(); i++) {
            if (factory_dal.get_dal().getClients().get(i).getID() == item.getID())
                return true;
        }
        return false;
    }
    @Override
    public String addCarModel(ContentValues model)//throws  Exception
    {
        CarModel item = ContentValuesToCarModel(model);
        int index=models.indexOf(item);
        /*if (index!= -1)
        {
            throw new Exception("this model already exist.");
        }*/
        models.add(item);
        return item.getModelCode();

    }
   /* @Override
    public List<CarModel> getModels()
    {
        return models;
    }*/
    @Override
    public long addCar(ContentValues car)//throws Exception
    {
        Car item = ContentValuesToCar(car);
        int index=cars.indexOf(item);
        /*if (index!= -1)
        {
            throw new Exception("this car already exist.");
        }*/
        cars.add(item);
        return item.getCarNumber();

    }

    @Override
    public List<Branch> getBranches()
    {
        return branches;
    }
    @Override
    public List<Car> getCars()
    {
        return cars;

    }
    @Override
    public List<CarModel> getModels()
    {
        return models;

    }
    @Override
    public List<Login> getUsers()
    {
        return users;

    }
    @Override
    public List<Order> getOrders()
    {
        return orders;

    }


    @Override
    public int addBranch(ContentValues branch) //throws Exception
    {
        Branch item = ContentValuesToBranch(branch);
        int index=branches.indexOf(item);
        /*if (index!= -1)
        {
            throw new Exception("this branch already exist.");
        }*/
        branches.add(item);
        return item.getBranchNumber();

    }
    @Override
    public String addUser(ContentValues user)//throws  Exception
    {
        Login item = ContentValuesToLogin(user);
        int index=users.indexOf(item);
        /*if (index!= -1)
        {
            throw new Exception("this model already exist.");
        }*/
        users.add(item);
        return item.getPassword();

    }
    @Override
    public String getDesc(long id)
    {
        return null;

    }
    @Override
   public List<Car>getBranchCars(ContentValues car){return null;}
    @Override
    public int addOrder(ContentValues order) {
        return  -1;
    }
    public String updateOccupied(ContentValues order){return null;}
    public String returnCar(ContentValues order){return null;}
    public String updateOrder(ContentValues values){return null;}
    public  String getAddressLink(long id){return null;}
    public boolean getClosedOrders(){return false;}

}
