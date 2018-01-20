package com.example.app2.controller.model.backend;

import android.content.ContentValues;

import com.example.app2.controller.model.entities.Branch;
import com.example.app2.controller.model.entities.Car;
import com.example.app2.controller.model.entities.CarModel;
import com.example.app2.controller.model.entities.Client;
import com.example.app2.controller.model.entities.Login;
import com.example.app2.controller.model.entities.Order;

import java.util.List;

/**
 * Created by Shirly on 11/15/2017.
 */

public interface ICarManager
{
    long addClient(ContentValues client); //throws Exception;
    //long removeClient(ContentValues client)throws Exception;
    //long updateClient( ContentValues values) throws Exception;
    List<Client> getClients();
    boolean isExistClient(ContentValues client);
    List<Login> getUsers();
    String addCarModel(ContentValues model);//throws Exception;
    String addUser(ContentValues user);//throws Exception;
    List<CarModel> getModels();
   long addCar(ContentValues car);//throws Exception;

    int addBranch(ContentValues branch); //throws Exception;
    List<Branch> getBranches();
    List<Car> getCars();
    List <Order> getOrders();
    List<Car>getBranchCars(ContentValues car);
    String getDesc(long id);
    int addOrder(ContentValues order) ;
    String updateOccupied(ContentValues car);
    String returnCar(ContentValues car);
     String updateOrder(ContentValues values);
    String getAddressLink(long id);
   boolean getClosedOrders();
   List<Car> getAvailableCars();



}
