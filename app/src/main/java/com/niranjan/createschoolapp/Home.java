package com.niranjan.createschoolapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;


public class Home extends  Fragment{

    CardView classwork,attendance,timetable,holiday,assignment,noticboard,books,activity,result,transport,navigation,onlineclass,tour,fee,homework;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homework=root.findViewById(R.id.homework);
        classwork=root.findViewById(R.id.classwork);
        attendance=root.findViewById(R.id.attendance);
        timetable=root.findViewById(R.id.timetable);
        holiday=root.findViewById(R.id.holiday);
        assignment=root.findViewById(R.id.assignment);
noticboard=root.findViewById(R.id.noticboard);
books=root.findViewById(R.id.books);
activity=root.findViewById(R.id.activity);
result=root.findViewById(R.id.result);
transport=root.findViewById(R.id.transport);
navigation=root.findViewById(R.id.navigation);
onlineclass=root.findViewById(R.id.onlineclass);
tour=root.findViewById(R.id.tour);
fee=root.findViewById(R.id.fee);
assignment.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Assignment.class);
        startActivity(intent);
    }
});
homework.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), HomeWork.class);
        startActivity(intent);
    }
});
fee.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), FeeStructure.class);
        startActivity(intent);
    }
});
tour.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Tour.class);
        startActivity(intent);
    }
});
onlineclass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Onlineclass.class);
        startActivity(intent);
    }
});
 navigation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent notificationIntent = new Intent(getContext(),Navigation.class);
        startActivity(notificationIntent);
    }
});
transport.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Transport.class);
        startActivity(intent);
    }
});
result.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Result.class);
        startActivity(intent);
    }
});
activity.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Activity.class);
        startActivity(intent);
    }
});
books.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Books.class);
        startActivity(intent);
    }
});
noticboard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), NoticeBoard.class);
        startActivity(intent);
    }
});
        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Holiday.class);
                startActivity(intent);
            }
        });
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Timetable.class);
                startActivity(intent);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Attendance.class);
                startActivity(intent);
            }
        });
        classwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Classwork.class);
                startActivity(intent);
            }
        });

return root;
}



}