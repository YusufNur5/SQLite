package com.example.pcs_sqlite_0097;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNote;
    FloatingActionButton btnAdd;
    private ArrayList<Note> noteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNote = findViewById(R.id.rv_note);
        btnAdd = findViewById(R.id.btnAdd);

        rvNote.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper db = new DatabaseHelper(this);
        noteList = db.getAllNote();

        if(noteList.size() != 0){
            NoteAdapter adapter = new NoteAdapter(this,noteList);
            rvNote.setAdapter(adapter);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent form = new Intent(getApplicationContext(),FormActivity.class);
                startActivity(form);
            }
        });

    }
}
