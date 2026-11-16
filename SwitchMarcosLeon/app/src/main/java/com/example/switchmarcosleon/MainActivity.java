package com.example.switchmarcosleon;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch switchDatos, switchWifi;
    Button botonVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchDatos = findViewById(R.id.switchDatos);
        switchWifi = findViewById(R.id.switchWifi);
        botonVerificar = findViewById(R.id.botonVerificar);

        botonVerificar.setOnClickListener(v -> verificar());
    }

    void verificar() {
        if (switchDatos.isChecked() && switchWifi.isChecked()) {
            Toast.makeText(this, "Datos móviles y Wifi activados", Toast.LENGTH_SHORT).show();
        } else if (switchDatos.isChecked()) {
            Toast.makeText(this, "Datos móviles activados", Toast.LENGTH_SHORT).show();
        } else if (switchWifi.isChecked()) {
            Toast.makeText(this, "Wifi activado", Toast.LENGTH_SHORT).show();
        }
    }
}