package com.example.noteapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noteapp.R;
import com.example.noteapp.model.Note;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.viewHolder>{

    ArrayList<Note> mNote = new ArrayList<>();

    public NotesRecyclerAdapter(ArrayList<Note> notes) {
        this.mNote = notes;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.title.setText(mNote.get(position).getTitle());
        holder.timestamp.setText(mNote.get(position).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return mNote.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView timestamp;

        public viewHolder(View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
        }
    }
}
