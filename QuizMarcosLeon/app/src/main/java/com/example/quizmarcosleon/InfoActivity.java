package com.example.quizmarcosleon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView tvTitulo = findViewById(R.id.tvTitulo);
        TextView tvTexto = findViewById(R.id.tvTexto);
        Button btnVolver = findViewById(R.id.btnVolver);


        String titulo = getIntent().getStringExtra("titulo");
        String texto = getIntent().getStringExtra("texto");

        tvTitulo.setText(titulo);
        tvTexto.setText(texto);

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}