package com.example.spinnerimageviewmarcosleon;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] nombres = {"Serbia", "Grecia", "Holanda", "Turquía", "España"};
    int[] imagenes = {R.drawable.belgrado, R.drawable.atenas, R.drawable.amsterdam,
            R.drawable.ankara, R.drawable.madrid};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ImageView imagen = findViewById(R.id.imagen);
        TextView nombre = findViewById(R.id.nombre);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nombres);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> padre, View vista, int posicion, long id) {
                imagen.setImageResource(imagenes[posicion]);
                nombre.setText(nombres[posicion]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> padre) {
            }
        });
    }
}