package com.example.quizmarcosleon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSistema = findViewById(R.id.btnSistema);
        Button btnAplicacion = findViewById(R.id.btnAplicacion);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        
        btnSistema.setOnClickListener(v -> {
            Intent intent = new Intent(this, SistemaActivity.class);
            startActivity(intent);
        });
        btnAplicacion.setOnClickListener(v -> {
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra("titulo", "Software de Aplicación");
            intent.putExtra("texto", "El software de aplicación permite realizar tareas específicas para el usuario, como escribir documentos, editar imágenes o navegar por internet.");
            startActivity(intent);
        });
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });
    }
}
