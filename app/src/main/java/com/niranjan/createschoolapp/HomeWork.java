package com.niranjan.createschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.niranjan.createschoolapp.Adapter.Homeworkadapter;
import com.niranjan.createschoolapp.Model.Usermodel;

import java.util.ArrayList;
import java.util.List;

public class HomeWork extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Usermodel.Homeworkmodel> homeworkmodelList;
    Homeworkadapter homeworkadapter;
    private SharedPreferences getShared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);

        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
        String className = getShared.getString("classname","");
        //Toast.makeText(this, className, Toast.LENGTH_SHORT).show();


        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.homworkrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        homeworkmodelList = new ArrayList<>();
        homeworkadapter= new Homeworkadapter(getApplicationContext(),homeworkmodelList);
        recyclerView.setAdapter(homeworkadapter);
        firestore.collection("HomeWork")

                .whereEqualTo("classname", className)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Usermodel.Homeworkmodel homeworkmodel = document.toObject(Usermodel.Homeworkmodel.class);
                                homeworkmodelList.add(homeworkmodel);
                                homeworkadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

}}