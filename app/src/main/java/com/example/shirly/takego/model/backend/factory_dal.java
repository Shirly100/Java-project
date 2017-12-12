package com.example.shirly.takego.model.backend;

import com.example.shirly.takego.model.dataSource.MySQL_DBManager;

/**
 * Created by Shirly on 11/22/2017.
 */

public class factory_dal
{
    static ICarManager idal = null;
    public static ICarManager get_dal()
    {
        if(idal==null)
            idal= new MySQL_DBManager();
        return idal;
    }
}
