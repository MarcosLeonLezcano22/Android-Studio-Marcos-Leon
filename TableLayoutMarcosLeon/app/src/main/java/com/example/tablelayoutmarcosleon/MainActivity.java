package com.example.tablelayoutmarcosleon;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView[] c = new TextView[9];
    TextView textoX, textoO, textoEmpates;
    String turno = "X";
    int jugadas = 0, puntosX = 0, puntosO = 0, empates = 0;
    boolean fin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoX = findViewById(R.id.puntosX);
        textoO = findViewById(R.id.puntosO);
        textoEmpates = findViewById(R.id.puntosEmpates);

        int[] ids = {R.id.c0, R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5, R.id.c6, R.id.c7, R.id.c8};
        for (int i = 0; i < 9; i++) {
            c[i] = findViewById(ids[i]);
            c[i].setOnClickListener(v -> jugar((TextView) v));
        }

        findViewById(R.id.botonNueva).setOnClickListener(v -> nuevaPartida());
        findViewById(R.id.botonReiniciar).setOnClickListener(v -> {
            puntosX = 0;
            puntosO = 0;
            empates = 0;
            nuevaPartida();
        });
    }

    void jugar(TextView casilla) {
        if (fin || !casilla.getText().toString().isEmpty()) {
            return;
        }
        casilla.setText(turno);
        casilla.setTextColor(turno.equals("X") ? Color.BLUE : Color.RED);
        jugadas++;

        if (ganador()) {
            fin = true;
            if (turno.equals("X")) puntosX++;
            else puntosO++;
        } else if (jugadas == 9) {
            fin = true;
            empates++;
        } else {
            turno = turno.equals("X") ? "O" : "X";
        }
        puntos();
    }

    boolean linea(int a, int b, int d) {
        String t = c[a].getText().toString();
        return !t.isEmpty() && t.equals(c[b].getText().toString()) && t.equals(c[d].getText().toString());
    }

    boolean ganador() {
        return linea(0, 1, 2) || linea(3, 4, 5) || linea(6, 7, 8)
                || linea(0, 3, 6) || linea(1, 4, 7) || linea(2, 5, 8)
                || linea(0, 4, 8) || linea(2, 4, 6);
    }

    void nuevaPartida() {
        for (TextView casilla : c) {
            casilla.setText("");
        }
        turno = "X";
        jugadas = 0;
        fin = false;
        puntos();
    }

    void puntos() {
        textoX.setText("" + puntosX);
        textoO.setText("" + puntosO);
        textoEmpates.setText("" + empates);
    }
}