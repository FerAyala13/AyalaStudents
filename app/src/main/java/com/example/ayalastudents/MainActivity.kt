package com.example.ayalastudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var vista:DrawerLayout
    private lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vista = findViewById(R.id.drawerly)
        toogle = ActionBarDrawerToggle(this,vista,R.string.Abrir_Drawer, R.string.Cerrar_Drawer)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navVista = findViewById(R.id.navista)
        navVista.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.inicio->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragview,InicioFragment())
                        commit()
                    }
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}