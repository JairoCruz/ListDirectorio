package com.example.tse.listdirectorio.Extras;

import org.json.JSONObject;

/**
 * Created by Marhinita on 18/9/2015.
 */
public class Utils {
    public static boolean contains(JSONObject jsonObject, String key){
        return jsonObject != null && jsonObject.has(key) && !jsonObject.isNull(key) ? true : false;
    }
}
