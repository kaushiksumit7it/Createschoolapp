package com.niranjan.createschoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.niranjan.createschoolapp.Model.Booksmodel;
import com.niranjan.createschoolapp.Model.Noticemodel;
import com.niranjan.createschoolapp.R;

import java.util.List;

public class Booksadapter extends RecyclerView.Adapter<Booksadapter.ViewHolder>{
    private Context context;
    private List<Booksmodel> booksmodelList;

    public Booksadapter(Context context, List<Booksmodel> booksmodelList) {
        this.context = context;
        this.booksmodelList = booksmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Booksadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.books,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(booksmodelList.get(position).getUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return booksmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.bookname);
        }
    }
}
