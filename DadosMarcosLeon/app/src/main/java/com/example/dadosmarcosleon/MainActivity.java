package com.example.dadosmarcosleon;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] caras = {R.drawable.cara1, R.drawable.cara2, R.drawable.cara3,
            R.drawable.cara4, R.drawable.cara5, R.drawable.cara6};
    Random aleatorio = new Random();
    int puntos = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton cubilete = findViewById(R.id.cubilete);
        ImageView dado1 = findViewById(R.id.dado1);
        ImageView dado2 = findViewById(R.id.dado2);

        cubilete.setOnClickListener(v -> {
            int n1 = aleatorio.nextInt(6);
            int n2 = aleatorio.nextInt(6);

            dado1.setImageResource(caras[n1]);
            dado2.setImageResource(caras[n2]);

            if (n1 == n2) {
                Toast.makeText(this, "¡Los dados coinciden!", Toast.LENGTH_SHORT).show();
            }

            puntos = puntos - 10;

            if (puntos == 0) {
                Toast.makeText(this, "Fin del juego", Toast.LENGTH_LONG).show();
                cubilete.setEnabled(false);
            }
        });
    }
}