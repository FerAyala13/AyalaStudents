package com.example.ayalastudents.cnn;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConexionBD {

    public Connection conexionBD(){
        Connection cnn = null;

        try {
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.9" +
                    "databaseName=AyalaUni; user= ayalas; password= ayalas3");
        }
        catch (Exception e){

        }

        return cnn;
    }

}
