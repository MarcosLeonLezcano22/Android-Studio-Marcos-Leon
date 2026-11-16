package com.example.buttontextviewmarcosleon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText caja1, caja2;
    private TextView textview1, textview2, textview3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caja1 = findViewById(R.id.caja1);
        caja2 = findViewById(R.id.caja2);
        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);
        button = findViewById(R.id.button);
    }

    public void calcular(View v) {
        int numero1 = 10;
        int numero2 = 5;

        String operacion = caja1.getText().toString().trim().toLowerCase();
        String resultado;

        switch (operacion) {
            case "suma":
                resultado = String.valueOf(numero1 + numero2);
                break;
            case "resta":
                resultado = String.valueOf(numero1 - numero2);
                break;
            case "multiplicacion":
                resultado = String.valueOf(numero1 * numero2);
                break;
            case "division":
                    resultado = String.valueOf((double) numero1 / numero2);
                break;
            default:
                resultado = "Operación no válida";
                break;
        }

        String mensaje = "El resultado es: "+resultado;

        caja2.setText(mensaje);
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}