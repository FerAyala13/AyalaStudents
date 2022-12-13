package com.example.ayalastudents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MenuUni extends AppCompatActivity {
    private Button btnInscripcion, btnPrecios, btnLista, btninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_uni);

        btnInscripcion = findViewById(R.id.Inscripcion);
        btnPrecios = findViewById(R.id.Precios);
        btnLista = findViewById(R.id.Lista);
        btninfo = findViewById(R.id.info);


    }
}