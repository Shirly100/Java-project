package com.example.shirly.takego.model.backend;

/**
 * Created by Shirly on 11/22/2017.
 */

public class factory_dal
{
    static ICarManager idal = null;
    public static ICarManager get_dal()
    {
        if(idal==null)
            idal= new List_CarManager();
        return idal;
    }
}
