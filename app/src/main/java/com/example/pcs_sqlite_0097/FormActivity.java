package com.example.pcs_sqlite_0097;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    EditText edtTitle, edtNote;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtTitle = findViewById(R.id.edtTitle);
        edtNote = findViewById(R.id.edtNote);
        btnSimpan = findViewById(R.id.btnSimpan);

       btnSimpan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String title = edtTitle.getText().toString();
               String note = edtNote.getText().toString();

               DatabaseHelper db = new DatabaseHelper(getApplicationContext());
               Note nt = new Note();
               nt.setTitle(title);
               nt.setNote(note);

               db.addNote(nt);

               Intent main = new Intent(FormActivity.this, MainActivity.class);
               startActivity(main);
           }
       });
    }
}
