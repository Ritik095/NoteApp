package com.example.noteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.noteapp.adapters.NotesRecyclerAdapter;
import com.example.noteapp.model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //ui components
    RecyclerView mRecyclerView;

    //vars.......
    ArrayList<Note> mNote = new ArrayList<>();
    NotesRecyclerAdapter mNotesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recylerview);

        initRecyclerview();
        fakeNotes();
    }

    private void fakeNotes(){
        for(int i =0; i<100; i++){
              Note note = new Note();
              note.setTitle("title "+ i);
              note.setTimestamp("jan 2019" + i);
              mNote.add(note);
        }
        mNotesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerview(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNotesRecyclerAdapter = new NotesRecyclerAdapter(mNote);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);
    }
}
