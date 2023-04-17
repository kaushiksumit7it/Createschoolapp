package com.niranjan.createschoolapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.niranjan.createschoolapp.Adapter.Libraryadapter;
import com.niranjan.createschoolapp.Model.Librarymodel;

import java.util.ArrayList;
import java.util.List;

public class Timetable extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Librarymodel>librarymodelList;
    Libraryadapter libraryadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
      firestore=FirebaseFirestore.getInstance();
      recyclerView=findViewById(R.id.librec);
      recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
      librarymodelList = new ArrayList<>();
      libraryadapter = new Libraryadapter(getApplicationContext(),librarymodelList);
      recyclerView.setAdapter(libraryadapter);
        firestore.collection("Timetable")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               Librarymodel librarymodel = document.toObject(Librarymodel.class);
                               librarymodelList.add(librarymodel);
                               libraryadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

    }
}