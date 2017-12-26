package com.example.shirly.takego.model.backend;

import android.content.ContentValues;
import com.example.shirly.takego.model.entities.*;
import java.util.ArrayList;
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

}
