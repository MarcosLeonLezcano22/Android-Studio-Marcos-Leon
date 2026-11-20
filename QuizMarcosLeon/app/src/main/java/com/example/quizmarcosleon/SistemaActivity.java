package com.example.quizmarcosleon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SistemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema);

        Button btnAndroid = findViewById(R.id.btnAndroid);
        Button btnWindows = findViewById(R.id.btnWindows);
        Button btnLinux = findViewById(R.id.btnLinux);
        Button btnVolver = findViewById(R.id.btnVolver);

        btnAndroid.setOnClickListener(v -> abrirInfo("Android",
                "Android es un sistema operativo móvil basado en el kernel de Linux, desarrollado por Google."));

        btnWindows.setOnClickListener(v -> abrirInfo("Windows",
                "Windows es un sistema operativo creado por Microsoft, muy usado en ordenadores personales."));

        btnLinux.setOnClickListener(v -> abrirInfo("Linux",
                "Linux es un sistema operativo de código abierto, basado en el kernel creado por Linus Torvalds."));

        // Vuelve al menú principal
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }


    private void abrirInfo(String titulo, String texto) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("texto", texto);
        startActivity(intent);
    }
}