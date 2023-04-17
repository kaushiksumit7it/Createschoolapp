package com.niranjan.createschoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.niranjan.createschoolapp.Model.Transportmodel;
import com.niranjan.createschoolapp.R;

import java.util.List;

public class Onlineclassadapter extends RecyclerView.Adapter<Onlineclassadapter.ViewHolder> {
    private Context context;
    private List<Transportmodel.Onlineclassmodel> onlineclassmodelList;

    public Onlineclassadapter(Context context, List<Transportmodel.Onlineclassmodel> onlineclassmodelList) {
        this.context = context;
        this.onlineclassmodelList = onlineclassmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Onlineclassadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.onlineclass,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(onlineclassmodelList.get(position).getName());
        holder.link.setText(onlineclassmodelList.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return onlineclassmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.platformname);
            link=itemView.findViewById(R.id.link);

        }
    }
}
