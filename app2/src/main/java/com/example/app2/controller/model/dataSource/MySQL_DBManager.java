package com.example.app2.controller.model.dataSource;

import android.content.ContentValues;
import android.util.Log;

import com.example.app2.controller.model.backend.ICarManager;
import com.example.app2.controller.model.entities.Branch;
import com.example.app2.controller.model.entities.Car;
import com.example.app2.controller.model.entities.CarModel;
import com.example.app2.controller.model.entities.Client;
import com.example.app2.controller.model.entities.Enums;
import com.example.app2.controller.model.entities.Login;
import com.example.app2.controller.model.entities.Order;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.app2.controller.model.backend.CarConst.ContentValuesToBranch;
import static com.example.app2.controller.model.backend.CarConst.ContentValuesToClient;
import static com.example.app2.controller.model.dataSource.List_DBManager.branches;
import static java.lang.Integer.parseInt;

/**
 * Created by Shirly on 12/12/2017.
 */

public class MySQL_DBManager implements ICarManager{

    private final String UserName="ohanona";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/TakeGo";

    private boolean updateFlag = false;
    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }
    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }

    @Override
    public long addClient(ContentValues values) {
       try {


            String result = PHPtools.POST(WEB_URL +"/addClient.php", values);
            long id = Long.parseLong(result.trim());
            if (id > 0)
                SetUpdate();
            printLog("addClient:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addClient Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public long addCar(ContentValues values) {
        try {


            String result = PHPtools.POST(WEB_URL +"/addCar.php", values);
            long id = Long.parseLong(result.trim());
            if (id > 0)
                SetUpdate();
            printLog("addCar:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public int addBranch(ContentValues values) {
        try {


            String result = PHPtools.POST(WEB_URL +"/addBranch.php", values);
            int id = parseInt(result.trim());
            if (id > 0)
                SetUpdate();
            printLog("addBranch:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addBranch Exception:\n" + e);
            return -1;
        }
    }
    public String addCarModel(ContentValues values) {
        try {


            String result = PHPtools.POST(WEB_URL +"/addModel.php", values);
            String id = result.trim();
            printLog("addModel:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addModel Exception:\n" + e);
            return "Error";
        }
    }
    private void SetUpdate()
    {
        updateFlag = true;
    }


    @Override
    public List<Client> getClients(){
        List<Client> result = new ArrayList<Client>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getClients.php");
            JSONArray array = new JSONObject(str).getJSONArray("clients");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);


           Client client = new Client();
           client.setID(jsonObject.getLong("_id"));
           client.setFirstName(jsonObject.getString("firstName"));
           client.setLastName(jsonObject.getString("lastName"));
           client.setPhoneNumber(jsonObject.getString("phoneNumber"));
           client.setMail(jsonObject.getString("mail"));
           client.setMail(jsonObject.getString("cardNumber"));
           ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
          //Client client = CarConst.ContentValuesToClient(contentValues);


                    //ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                //Client client = CarConst.ContentValuesToClient(contentValues);
                result.add(client);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getCars(){
        List<Car> result = new ArrayList<Car>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getCars.php");
            JSONArray array = new JSONObject(str).getJSONArray("cars");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Car car = new Car();
                car.setCarNumber(jsonObject.getInt("carNumber"));
                car.setBranchNumber(jsonObject.getInt("branchNumber"));
                car.setModelType(jsonObject.getString("modelType"));
                float value = Float.valueOf(jsonObject.getString("mileage"));
                car.setMileage(value);
                car.setOccupied(Enums.Answer.valueOf(jsonObject.getString("occupied")));

                result.add(car);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Branch> getBranches(){
        List<Branch> result = new ArrayList<Branch>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getBranches.php");
            JSONArray array = new JSONObject(str).getJSONArray("branches");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Branch branch = new Branch();
                branch.setBranchNumber(jsonObject.getInt("branchNumber"));
                branch.setParking_spacees(jsonObject.getInt("parking_spaces"));
                branch.setCity(jsonObject.getString("city"));
                branch.setStreet(jsonObject.getString("street"));
                branch.setNumber(jsonObject.getInt("number"));


                result.add(branch);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Login> getUsers(){
        List<Login> result = new ArrayList<Login>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getUsers.php");
            JSONArray array = new JSONObject(str).getJSONArray("users");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Login login = new Login();
                login.setPassword(jsonObject.getString("Password"));
                login.setUser(jsonObject.getString("User"));
                ;


                result.add(login);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<CarModel> getModels(){
        List<CarModel> result = new ArrayList<CarModel>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getModels.php");
            JSONArray array = new JSONObject(str).getJSONArray("models");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                CarModel model = new CarModel();
                model.setModelCode(jsonObject.getString("modelCode"));
                model.setCompany(jsonObject.getString("company"));
                model.setModelName(jsonObject.getString("modelName"));
                model.setEngineCapacity(jsonObject.getString("EngineCapacity"));
                model.setGear(Enums.Gear.valueOf(jsonObject.getString("gear")));
                model.setSeatingCapacity(jsonObject.getInt("SeatingCapacity"));
                model.setDoorsNumber(jsonObject.getInt("DoorsNumber"));
                model.setEmptyMass(jsonObject.getString("emptyMass"));
                model.setFuel(jsonObject.getString("fuel"));
                model.setEngine_type(jsonObject.getString("engine_type"));
                model.setTurbo(Enums.Answer.valueOf(jsonObject.getString("turbo")));
                model.setLighted_makeup_mirror(Enums.Answer.valueOf(jsonObject.getString("Lighted_makeup_mirror")));
                model.setDigital_radio(Enums.Answer.valueOf(jsonObject.getString("Digital_radio")));
                model.setPanorama(Enums.Answer.valueOf(jsonObject.getString("Panorama")));
                model.setDriver_airbag(Enums.Answer.valueOf(jsonObject.getString("Driver_airbag")));
                model.setEmergency_brake_assist(Enums.Answer.valueOf(jsonObject.getString("Emergency_brake_assist")));
                model.setTotal_max_power(jsonObject.getString("Total_max_power"));



                result.add(model);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isExistClient(ContentValues values) {

        List<Client> result=getClients();
        Client item = ContentValuesToClient(values);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getID() == item.getID())
                return true;
        }
        return false;


    }
    public String addUser(ContentValues values) {
        try {


            String result = PHPtools.POST(WEB_URL +"/addUser.php", values);
            String user = result.trim();
            printLog("addUser:\n" + result);
            return user;
        } catch (IOException e) {
            printLog("addUser Exception:\n" + e);
            return "Error";
        }
    }

    public String getDesc(long id)
    {
        int index=(int)id;
        int number=getBranches().get(index).getBranchNumber();
        int parking=getBranches().get(index).getParking_spacees();
        String address=getBranches().get(index).getCity()+", "+getBranches().get(index).getStreet()+", "+getBranches().get(index).getNumber();
        String desc="brunch number: "+number+"\n"+"parking spaces: "+parking+"\n"+"address: "+address;
        return desc;


    }

    @Override
    public List<Car> getBranchCars(ContentValues values){
        List<Car> result = new ArrayList<Car>();

        try {

            String str = PHPtools.POST(WEB_URL + "/getBranchCars.php",values);
            JSONArray array = new JSONObject(str).getJSONArray("cars");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Car car = new Car();
                car.setCarNumber(jsonObject.getInt("carNumber"));
                car.setBranchNumber(jsonObject.getInt("branchNumber"));
                car.setModelType(jsonObject.getString("modelType"));
                float value = Float.valueOf(jsonObject.getString("mileage"));
                car.setMileage(value);
                car.setOccupied(Enums.Answer.valueOf(jsonObject.getString("occupied")));

                result.add(car);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String updateOccupied(ContentValues values)
    {
        try {

            String str = PHPtools.POST(WEB_URL + "/updateCar.php",values);
            return str;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public String returnCar(ContentValues values)
    {
        try {

            String str = PHPtools.POST(WEB_URL + "/returnCar.php",values);
            return str;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public int addOrder(ContentValues values) {
        try {


            String result = PHPtools.POST(WEB_URL +"/addOrder.php", values);
            int id = parseInt(result.trim());
            printLog("addOrder:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addOrder Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public List<Order> getOrders(){
        List<Order> result = new ArrayList<Order>();

        try {

            String str = PHPtools.GET(WEB_URL + "/getOrders.php");
            JSONArray array = new JSONObject(str).getJSONArray("orders");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

                Order order = new Order();
                order.setOrderNumber(jsonObject.getInt("orderNumber"));
                order.setClientNumber(jsonObject.getInt("clientNumber"));
                order.setOrder(Enums.Order.valueOf(jsonObject.getString("order")));
                order.setCarNumber(jsonObject.getInt("carNumber"));
                order.setRental_srart_date(jsonObject.getString("rental_srart_date"));
                order.setRental_end_date(jsonObject.getString("rental_end_date"));
                order.setMileage_start_value(BigDecimal.valueOf(jsonObject.getDouble("mileage_start_value")).floatValue());
                order.setMileage_end_value(BigDecimal.valueOf(jsonObject.getDouble("mileage_end_value")).floatValue());
                order.setFuel_filling(Enums.Answer.valueOf(jsonObject.getString("fuel_filling")));
                order.setQuantity_of_fuel(BigDecimal.valueOf(jsonObject.getDouble("quantity_of_fuel")).floatValue());
                order.setPayment(BigDecimal.valueOf(jsonObject.getDouble("payment")).floatValue());



                result.add(order);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




}
