package com.example.ayalastudents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ayalastudents.cnn.ConexionBD;

import java.sql.PreparedStatement;

public class AgregarUsuario extends AppCompatActivity {
    private EditText nombres, apellidos, usuario, contraseña;
    private Button Agregar;

    ConexionBD conexionBD = new ConexionBD();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);

        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);
        Agregar = findViewById(R.id.btn_Agregar);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Agregar_Usuario();}
        });

    }

    public void Agregar_Usuario(){
        try {
            PreparedStatement ins= conexionBD.conexionBD().prepareStatement( "INSERT INTO Usuarios Values(?,?,?,?,?,?,?)");
            ins.setString(1,nombres.getText().toString());
            ins.setString(2,apellidos.getText().toString());
            ins.setString(3,usuario.getText().toString());
            ins.setString(4,contraseña.getText().toString());
            ins.executeUpdate();
            Toast.makeText(getApplicationContext(), " Usuario registrado exitosamente...",Toast.LENGTH_SHORT).show();

            new Handler(Looper.getMainLooper()).postDelayed(()->{
                Intent i = new Intent(AgregarUsuario.this,login.class);
                startActivity(i);
                finish();
            },2500);

            nombres.setText("");
            apellidos.setText("");
            usuario.setText("");
            contraseña.setText("");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}