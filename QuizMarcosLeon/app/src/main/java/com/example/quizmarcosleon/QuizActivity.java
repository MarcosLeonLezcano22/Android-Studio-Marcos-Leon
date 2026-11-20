package com.example.quizmarcosleon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {


    String[] preguntas = {
            "¿Qué empresa mantiene y desarrolla Android?",
            "¿En qué kernel se basa Android?",
            "¿Qué lenguaje es oficial para programar apps Android junto con Java?",
            "¿Qué sistema de archivos usa Windows por defecto?",
            "¿Cómo se llama la línea de comandos clásica de Windows?",
            "¿Quién creó el kernel de Linux?",
            "¿Qué comando de Linux muestra el contenido de un directorio?"
    };

    String[][] opciones = {
            {"Apple", "Google", "Microsoft"},
            {"Linux", "Windows NT", "Darwin"},
            {"Swift", "C#", "Kotlin"},
            {"ext4", "NTFS", "APFS"},
            {"Zsh", "Finder", "Símbolo del sistema (CMD)"},
            {"Linus Torvalds", "Bill Gates", "Steve Jobs"},
            {"cd", "ls", "rm"}
    };


    int[] correctas = {1, 0, 2, 1, 2, 0, 1};

    int preguntaActual = 0;
    int aciertos = 0;
    int fallos = 0;

    TextView tvPregunta, tvResultado;
    RadioGroup rgOpciones;
    RadioButton rbOpcion1, rbOpcion2, rbOpcion3;
    Button btnSiguiente, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvPregunta = findViewById(R.id.tvPregunta);
        tvResultado = findViewById(R.id.tvResultado);
        rgOpciones = findViewById(R.id.rgOpciones);
        rbOpcion1 = findViewById(R.id.rbOpcion1);
        rbOpcion2 = findViewById(R.id.rbOpcion2);
        rbOpcion3 = findViewById(R.id.rbOpcion3);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnVolver = findViewById(R.id.btnVolver);

        mostrarPregunta();

        btnSiguiente.setOnClickListener(v -> {
            int idSeleccionado = rgOpciones.getCheckedRadioButtonId();


            if (idSeleccionado == -1) {
                Toast.makeText(this, "Elige una opción", Toast.LENGTH_SHORT).show();
                return;
            }


            int elegida = rgOpciones.indexOfChild(findViewById(idSeleccionado));

            if (elegida == correctas[preguntaActual]) {
                aciertos++;
            } else {
                fallos++;
            }

            preguntaActual++;

            if (preguntaActual < preguntas.length) {
                mostrarPregunta();
            } else {
                mostrarResultado();
            }
        });

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    private void mostrarPregunta() {
        tvPregunta.setText((preguntaActual + 1) + ". " + preguntas[preguntaActual]);
        rbOpcion1.setText(opciones[preguntaActual][0]);
        rbOpcion2.setText(opciones[preguntaActual][1]);
        rbOpcion3.setText(opciones[preguntaActual][2]);
        rgOpciones.clearCheck();

        if (preguntaActual == preguntas.length - 1) {
            btnSiguiente.setText("Finalizar");
        }
    }

    private void mostrarResultado() {

        double puntuacion = aciertos - (fallos * 0.33);


        tvPregunta.setVisibility(View.GONE);
        rgOpciones.setVisibility(View.GONE);
        btnSiguiente.setVisibility(View.GONE);

        tvResultado.setText("Puntuación total: " + String.format("%.2f", puntuacion)
                + "\n\nAciertos: " + aciertos
                + "\nFallos: " + fallos);
        tvResultado.setVisibility(View.VISIBLE);
        btnVolver.setVisibility(View.VISIBLE);
    }
}
