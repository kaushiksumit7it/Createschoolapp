package com.niranjan.createschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.assist.AssistContent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.niranjan.createschoolapp.Adapter.Assignmentadapter;
import com.niranjan.createschoolapp.Adapter.Classworkadapter;
import com.niranjan.createschoolapp.Model.Assignmentmodel;
import com.niranjan.createschoolapp.Model.Classworkmodel;

import java.util.ArrayList;
import java.util.List;

public class Assignment extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Assignmentmodel> assignmentmodelList;
    Assignmentadapter assignmentadapter;
    private SharedPreferences getShared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.assignmentrec);


        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
        String className = getShared.getString("classname","");
       // Toast.makeText(this, className, Toast.LENGTH_SHORT).show();


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        assignmentmodelList = new ArrayList<>();
        assignmentadapter= new Assignmentadapter(getApplicationContext(),assignmentmodelList);
        recyclerView.setAdapter(assignmentadapter);
        firestore.collection("Assignment")
                .whereEqualTo("classname", className)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Assignmentmodel assignmentmodel = document.toObject(Assignmentmodel.class);
                                assignmentmodelList.add(assignmentmodel);
                                assignmentadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

    }
}