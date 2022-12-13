package com.example.ayalastudents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ayalastudents.cnn.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends AppCompatActivity {
    private EditText Usuario, Contraseña;
    private Button btnlogeo, Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogeo = findViewById(R.id.login);
        Registrar = findViewById(R.id.Registrarse);
        Usuario = findViewById(R.id.usuario);
        Contraseña = findViewById(R.id.contraseña);

        ConexionBD conexionBD = new ConexionBD();

        btnlogeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Connection connection = conexionBD.conexionBD();

                try {
                    if(conexionBD!=null) {

                        Statement stm = connection.createStatement();
                        ResultSet rs = stm.executeQuery("select * from Login where Usuario='"
                                + Usuario.getText().toString() + "' and contraseña='" + Contraseña.getText().toString() + "'");

                        if (rs.next()) {

                            Toast.makeText(login.this, " Bienvenido: " + " " + Usuario.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(login.this, MenuUni.class);
                            startActivity(i);
                            finish();

                        } else {

                            Toast.makeText(login.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    Log.e("ERROR", e.getMessage());
                }
            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this,AgregarUsuario.class);
                startActivity(i);
            }
        });

    }
}