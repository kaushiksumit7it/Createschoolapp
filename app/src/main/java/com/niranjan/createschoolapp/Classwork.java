package com.niranjan.createschoolapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.niranjan.createschoolapp.Adapter.Classworkadapter;
import com.niranjan.createschoolapp.Adapter.Homeworkadapter;
import com.niranjan.createschoolapp.Model.Classworkmodel;
import com.niranjan.createschoolapp.Model.Usermodel;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class Classwork extends AppCompatActivity {
    FirebaseFirestore firestore;
    FirebaseAuth auth;

    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    List<Classworkmodel> classworkmodelList;
    Classworkadapter classworkadapter;
    private SharedPreferences getShared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork);

        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
        String className = getShared.getString("classname","");
      //  Toast.makeText(this, className, Toast.LENGTH_SHORT).show();

        firestore=FirebaseFirestore.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();


        

        recyclerView=findViewById(R.id.classworkrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
       classworkmodelList = new ArrayList<>();
        classworkadapter= new Classworkadapter(getApplicationContext(),classworkmodelList);
        recyclerView.setAdapter(classworkadapter);

            firestore.collection("Classwork")

                   .whereEqualTo("classname", className)


                //.whereEqualTo("classname",FirebaseAuth.getInstance().getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Classworkmodel classworkmodel = document.toObject(Classworkmodel.class);
                                    classworkmodelList.add(classworkmodel);
                                    classworkadapter.notifyDataSetChanged();
                                }
                            } else {

                            }
                        }
                    });


    }
}