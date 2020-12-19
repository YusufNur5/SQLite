package com.example.pcs_sqlite_0097;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private ArrayList<Note> noteList;
    private Note note;

    private Context mContext;

    public NoteAdapter(Context context, ArrayList<Note> noteList) {
        this.noteList = noteList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        note = noteList.get(position);

        holder.txtTitle.setText(note.getTitle());
        holder.txtNote.setText(note.getNote());

        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note = noteList.get(position);

                DatabaseHelper db = new DatabaseHelper(mContext);
                db.deleteNote(String.valueOf(note.getId()));

                notifyItemRemoved(position);
                noteList.remove(position);

                Toast.makeText(mContext,"data yang terhapus : "+note.getTitle(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtNote;
        Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtNote = itemView.findViewById(R.id.txtNote);
            btnHapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}

