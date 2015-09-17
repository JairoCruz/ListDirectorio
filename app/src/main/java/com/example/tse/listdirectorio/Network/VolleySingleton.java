package com.example.tse.listdirectorio.Network;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Created by TSE on 17/09/2015.
 */
public class VolleySingleton {
    private static VolleySingleton instance = null;
    private RequestQueue requestQueue;


    public VolleySingleton() {
        requestQueue = Volley.newRequestQueue(MyAplication.getAppContext());
    }

    public static VolleySingleton getInstance(){
        if (instance == null){
            instance = new VolleySingleton();
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

    public static void handleVolleyError(VolleyError error){



    }
}
