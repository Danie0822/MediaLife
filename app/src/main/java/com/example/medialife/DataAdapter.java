package com.example.medialife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<DataModel> dataList;

    public DataAdapter(List<DataModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel data = dataList.get(position);

        holder.txtId.setText(String.valueOf(data.getId()));
        holder.txtNombre.setText(data.getNombre());
        holder.txtEnfermedad.setText(data.getEnfermedad());
        holder.txtPeso.setText(data.getPeso());
        holder.txtTemperatura.setText(data.getTemperatura());
        holder.txtPresion.setText(data.getPresion());
        holder.txtAltura.setText(data.getAltura());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId;
        TextView txtNombre;
        TextView txtEnfermedad;
        TextView txtPeso;
        TextView txtTemperatura;
        TextView txtPresion;
        TextView txtAltura;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.viewId);
            txtNombre = itemView.findViewById(R.id.viewNombre);
            txtEnfermedad= itemView.findViewById(R.id.viewEnfermedad);
            txtPeso= itemView.findViewById(R.id.viewPeso);
            txtTemperatura= itemView.findViewById(R.id.viewTemperatura);
            txtPresion= itemView.findViewById(R.id.viewPresion);
            txtAltura= itemView.findViewById(R.id.viewAltura);
        }
    }
}

