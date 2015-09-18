package com.example.tse.listdirectorio.Fragment;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tse.listdirectorio.Adapter.AdapterDiputado;
import com.example.tse.listdirectorio.Model.Diputado;
import com.example.tse.listdirectorio.Network.MyAplication;
import com.example.tse.listdirectorio.Network.VolleySingleton;
import com.example.tse.listdirectorio.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_diputado extends Fragment {

    private static final String STATE_DIPUTADOS = "state_diputados";

    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;

    private ArrayList<Diputado> listDiputados = new ArrayList<>();
    private RecyclerView recyclerListDiputados;

    private AdapterDiputado adapterDiputado;
    private TextView textVolleyError;


    public Fragment_diputado() {
        // Required empty public constructor
    }


    public static Fragment_diputado newInstance() {
        Fragment_diputado fragment = new Fragment_diputado();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
        sendJsonRequest();
    }


    private void sendJsonRequest() {
        /*JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getRequestUrl(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                textVolleyError.setVisibility(View.GONE);
                // listDiputados = parseJsonResponse(response);
               // adapterDiputado.setListDiputados(listDiputados);
                Log.e("Error: ", response.toString());
                Toast.makeText(getActivity(),response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleVolleyError(error);
            }
        });
        requestQueue.add(request);*/
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,getRequestUrl(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                textVolleyError.setVisibility(View.GONE);
                Log.e("Error: ", response.toString());
                Toast.makeText(getActivity(),response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleVolleyError(error);
            }
        });
        // Este codigo me permite especificar el tiempo que tiene que esperar para poder terminar la coneccion.
        // Esto me sirve cuando el servidor tarda demasiado tiempo en enviarme la respuesta.
        request.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(20),
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(request);
    }

    private void handleVolleyError(VolleyError error) {
        textVolleyError.setVisibility(View.VISIBLE);
        if (error instanceof TimeoutError || error instanceof NoConnectionError){
            Log.e("Error: ", "tiemp: " + error.toString());
            textVolleyError.setText(R.string.error_timeout);
        }else if (error instanceof AuthFailureError){
            textVolleyError.setText(R.string.error_auth_failure);
        }else if (error instanceof ServerError){
            textVolleyError.setText(R.string.error_auth_failure);
        }else if (error instanceof NetworkError){
            textVolleyError.setText(R.string.error_network);
        }else if (error instanceof ParseError){
            Log.e("Error: ", "errorrrr" + error.getMessage());
            textVolleyError.setText(R.string.error_parser);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_fragment_diputado,container,false);
        textVolleyError = (TextView) view.findViewById(R.id.textVolleyError);
        recyclerListDiputados = (RecyclerView) view.findViewById(R.id.listDiputados);
        recyclerListDiputados.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterDiputado = new AdapterDiputado(getActivity());
        recyclerListDiputados.setAdapter(adapterDiputado);
        sendJsonRequest();
        return view;
    }


    public static String getRequestUrl() {
        return MyAplication.API_DIPUTADOS;
    }


}
