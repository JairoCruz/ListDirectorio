package com.example.tse.listdirectorio.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tse.listdirectorio.Model.Diputado;
import com.example.tse.listdirectorio.Network.VolleySingleton;
import com.example.tse.listdirectorio.R;

import java.util.ArrayList;

/**
 * Created by TSE on 17/09/2015.
 */
public class AdapterDiputado extends RecyclerView.Adapter<AdapterDiputado.ViewHolderDiputado>{

    private LayoutInflater layoutInflater;
    private ArrayList<Diputado> listDiputados = new ArrayList<>();
    private VolleySingleton volleySingleton;

    public AdapterDiputado(Context context) {
        layoutInflater = layoutInflater.from(context);
        volleySingleton = volleySingleton.getInstance();
    }

    public void setListDiputados(ArrayList<Diputado> listDiputados){
        this.listDiputados = listDiputados;
        notifyItemRangeChanged(0, listDiputados.size());
    }

    @Override
    public ViewHolderDiputado onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewDiputadoRow = layoutInflater.inflate(R.layout.diputado_row, viewGroup, false);
        ViewHolderDiputado viewHolder = new ViewHolderDiputado(viewDiputadoRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderDiputado viewHolderDiputado, int position) {
        Diputado currentDiputado = listDiputados.get(position);
        viewHolderDiputado.diputadoNombre.setText(currentDiputado.getNombre());
        viewHolderDiputado.diputadoSuplente.setText(currentDiputado.getSuplente());
        viewHolderDiputado.diputadoEmail.setText(currentDiputado.getEmail());
        viewHolderDiputado.diputadoEntidad.setText(currentDiputado.getEntidad());
        viewHolderDiputado.diputadoCurrul.setText(currentDiputado.getCurul());
        viewHolderDiputado.diputadoFraccion.setText(currentDiputado.getFraccion());
        viewHolderDiputado.diputadoTipoEleccion.setText(currentDiputado.getTipo_de_eleccion());
    }

    @Override
    public int getItemCount() {
        return listDiputados.size();
    }

    static class ViewHolderDiputado extends RecyclerView.ViewHolder{

        private TextView diputadoEntidad;
        private TextView diputadoTipoEleccion;
        private TextView diputadoFraccion;
        private TextView diputadoSuplente;
        private TextView diputadoNombre;
        private TextView diputadoCurrul;
        private TextView diputadoEmail;


        public ViewHolderDiputado(View itemView) {
            super(itemView);
            diputadoEntidad = (TextView) itemView.findViewById(R.id.diputadoEntidad);
            diputadoTipoEleccion = (TextView) itemView.findViewById(R.id.diputadoTipoEleccion);
            diputadoFraccion = (TextView) itemView.findViewById(R.id.diputadoFraccion);
            diputadoSuplente = (TextView) itemView.findViewById(R.id.diputadoSuplente);
            diputadoNombre = (TextView) itemView.findViewById(R.id.diputadoNombre);
            diputadoCurrul = (TextView) itemView.findViewById(R.id.diputadoCurrul);
            diputadoEmail = (TextView) itemView.findViewById(R.id.diputadoEmail);
        }

    }
}
