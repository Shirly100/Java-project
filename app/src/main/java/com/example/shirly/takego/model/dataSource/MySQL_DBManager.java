package com.example.shirly.takego.model.dataSource;

import android.content.ContentValues;
import android.util.Log;

import com.example.shirly.takego.model.backend.CarConst;
import com.example.shirly.takego.model.backend.ICarManager;
import com.example.shirly.takego.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shirly on 12/12/2017.
 */

public class MySQL_DBManager implements ICarManager{

    private final String UserName="ohanona";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/Take&Go/";

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
            String result = PHPtools.POST(WEB_URL + "addClient.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addClient:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addClient Exception:\n" + e);
            return -1;
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

            String str = PHPtools.GET(WEB_URL + "getClients.php");
            JSONArray array = new JSONObject(str).getJSONArray("Clients");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);

           //Client client = new Client();
          // client.setID(jsonObject.getLong("ID"));
           //client.setFirstName(jsonObject.getString("first_name"));
          // client.setLastName(jsonObject.getString("last_name"));
          // client.setPhoneNumber(jsonObject.getString("phone_number"));
          // client.setMail(jsonObject.getString("mail"));
          // client.setMail(jsonObject.getString("card_number"));
           ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
          Client client = CarConst.ContentValuesToClient(contentValues);


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


}
