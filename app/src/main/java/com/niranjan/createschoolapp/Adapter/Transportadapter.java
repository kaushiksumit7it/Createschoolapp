package com.niranjan.createschoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.niranjan.createschoolapp.Model.Booksmodel;
import com.niranjan.createschoolapp.Model.Transportmodel;
import com.niranjan.createschoolapp.R;

import java.util.List;

public class Transportadapter extends RecyclerView.Adapter<Transportadapter.ViewHolder> {
    private Context context;
    private List<Transportmodel> transportmodelList;

    public Transportadapter(Context context, List<Transportmodel> transportmodelList) {
        this.context = context;
        this.transportmodelList = transportmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Transportadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.transport,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vannumber.setText(transportmodelList.get(position).getVannumber());
        holder.time.setText(transportmodelList.get(position).getTime());
        holder.startlocation.setText(transportmodelList.get(position).getStartlocation());
        holder.lastlocation.setText(transportmodelList.get(position).getLastlocation());
        holder.drivernumber.setText(transportmodelList.get(position).getDrivernumber());
    }

    @Override
    public int getItemCount() {
        return transportmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vannumber,time,startlocation,lastlocation,drivernumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vannumber=itemView.findViewById(R.id.vannumber);
            startlocation=itemView.findViewById(R.id.startlocation);
            time=itemView.findViewById(R.id.vantime);
            lastlocation=itemView.findViewById(R.id.lastlocation);
            drivernumber=itemView.findViewById(R.id.drivernumber);
        }
    }
}
