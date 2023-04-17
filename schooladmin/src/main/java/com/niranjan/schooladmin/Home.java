package com.niranjan.schooladmin;

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

import java.util.ArrayList;
import java.util.HashMap;


public class Home extends  Fragment{
CardView homework,circle,news,payment,feedetails,event,feesummary,booksearch,examreport,examsechedule,transport,attendance,leaves,birthday,myprofile,project,activity,syllabus,timetable,myteacher;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
homework=root.findViewById(R.id.homework);
circle=root.findViewById(R.id.circle);
news=root.findViewById(R.id.news);
payment=root.findViewById(R.id.payment);
feedetails=root.findViewById(R.id.fedetails);
event= root.findViewById(R.id.events);
feesummary=root.findViewById(R.id.feesummary);
booksearch=root.findViewById(R.id.booksearch);
examreport=root.findViewById(R.id.examreport);
examsechedule=root.findViewById(R.id.examschedule);
transport=root.findViewById(R.id.transport);
attendance=root.findViewById(R.id.attendance);
leaves=root.findViewById(R.id.leaves);
birthday=root.findViewById(R.id.birthdays);
myprofile=root.findViewById(R.id.myprofile);
project=root.findViewById(R.id.project);
activity=root.findViewById(R.id.activity);
syllabus=root.findViewById(R.id.syylabus);
timetable=root.findViewById(R.id.timetable);
myteacher=root.findViewById(R.id.myteachers);
 // homework
homework.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),HomeWork.class));
    }
});

// circle

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Circular.class));
            }
        });
        //news
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),News.class));
            }
        });

        //payment

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Payment.class));
            }
        });

        //feedetails
        feedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Feedeatils.class));
            }
        });
        //events
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Events.class));
            }
        });

        //feesumary
        feesummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Feesummary.class));
            }
        });
        //booksearch
        booksearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Booksearch.class));
            }
        });
        //examreport
        examreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Examreport.class));
            }
        });
        //examseudle
        examsechedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ExamSchedule.class));
            }
        });
        //transport
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Transport.class));

            }
        });
        //attendace
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Attendance.class));

            }
        });
        //leaves
        leaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Leaves.class));

            }
        });
        //birtday
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Birthdays.class));

            }
        });
        //myprofile
        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Myprofile.class));

            }
        });
        // project
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Project.class));

            }
        });

        // activity
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Activity.class));

            }
        });
        //Syllabus
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Syylabus.class));

            }
        });
        //timetable
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Timetable.class));

            }
        });
        // myteacher
        myteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Myteacher.class));

            }
        });
return root;
}



}