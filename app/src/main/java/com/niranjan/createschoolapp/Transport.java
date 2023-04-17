package com.niranjan.createschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.niranjan.createschoolapp.Adapter.Libraryadapter;
import com.niranjan.createschoolapp.Adapter.Transportadapter;
import com.niranjan.createschoolapp.Model.Librarymodel;
import com.niranjan.createschoolapp.Model.Transportmodel;

import java.util.ArrayList;
import java.util.List;

public class Transport extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Transportmodel> transportmodelList;
    Transportadapter transportadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.transportrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        transportmodelList = new ArrayList<>();
        transportadapter = new Transportadapter(getApplicationContext(),transportmodelList);
        recyclerView.setAdapter(transportadapter);
        firestore.collection("Transport")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Transportmodel transportmodel = document.toObject(Transportmodel.class);
                                transportmodelList.add(transportmodel);
                                transportadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
    }
}