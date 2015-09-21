package com.example.tse.listdirectorio.Parse;

import android.util.Log;

import com.example.tse.listdirectorio.Extras.Utils;
import com.example.tse.listdirectorio.Model.Diputado;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import static com.example.tse.listdirectorio.Extras.Keys.EndPointDiputado.*;

/**
 * Created by Marhinita on 18/9/2015.
 */
public class ParseJsonResponse {

    public static ArrayList<Diputado> parseJson(JSONArray response){

        ArrayList<Diputado> listDiputados = new ArrayList<>();
        if (response != null && response.length() > 0){
            try{
                for (int i = 0; i < response.length(); i++){
                    String entidad = "NA";
                    String tipo_de_eleccion = "NA";
                    String fraccion = "NA";
                    String suplente = "NA";
                    String nombre = "NA";
                    String currul = "NA";
                    String email = "NA";
                    JSONObject diputado = (JSONObject) response.get(i);
                    if (Utils.contains(diputado, KEY_ENTIDAD)){
                        entidad = diputado.getString(KEY_ENTIDAD);
                    }
                    if (Utils.contains(diputado,KEY_TIPO_ELECCION)) {
                        tipo_de_eleccion = diputado.getString(KEY_TIPO_ELECCION);
                    }
                    if (Utils.contains(diputado,KEY_FRACCION)){
                        fraccion = diputado.getString(KEY_FRACCION);
                    }
                    if (Utils.contains(diputado,KEY_SUPLENTE)){
                        suplente = diputado.getString(KEY_SUPLENTE);
                    }
                    if (Utils.contains(diputado,KEY_NOMBRE)){
                        nombre = diputado.getString(KEY_NOMBRE);
                    }
                    if (Utils.contains(diputado,KEY_CURRUL)){
                        currul = diputado.getString(KEY_CURRUL);
                    }
                    if (Utils.contains(diputado,KEY_EMAIL)){
                        email = diputado.getString(KEY_EMAIL);
                    }

                    Diputado currentDiputado = new Diputado();
                    currentDiputado.setEntidad(entidad);
                    currentDiputado.setTipo_de_eleccion(tipo_de_eleccion);
                    currentDiputado.setFraccion(fraccion);
                    currentDiputado.setSuplente(suplente);
                    currentDiputado.setNombre(nombre);
                    currentDiputado.setCurul(currul);
                    currentDiputado.setEmail(email);

                    if (!nombre.equals("NA")){
                        listDiputados.add(currentDiputado);
                    }
                }

            }catch (Exception e){
                Log.e("Error en Parse",e.getMessage());

            }
        }
        return listDiputados;
    }
}
