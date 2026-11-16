package com.example.radiobuttonmarcosleon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero1, etNumero2;
    private RadioGroup rgOperaciones;
    private RadioButton rbSumar, rbMultiplicar, rbDividir, rbRestar;
    private Button btCalcular;
    private TextView tvResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etNumero1 = findViewById(R.id.etNumero1);
        etNumero2 = findViewById(R.id.etNumero2);
        rgOperaciones = findViewById(R.id.rgOperaciones);
        rbSumar = findViewById(R.id.rbSumar);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);
        rbRestar = findViewById(R.id.rbRestar);
        btCalcular = findViewById(R.id.btCalcular);
        tvResultado = findViewById(R.id.tvResultado);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        String texto1 = etNumero1.getText().toString();
        String texto2 = etNumero2.getText().toString();

        if (texto1.isEmpty() || texto2.isEmpty()) {
            Toast.makeText(this, "Introduce los dos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(texto1);
        double num2 = Double.parseDouble(texto2);
        double resultado = 0;

        if (rbSumar.isChecked()) {
            resultado = num1 + num2;
        } else if (rbMultiplicar.isChecked()) {
            resultado = num1 * num2;
        } else if (rbDividir.isChecked()) {
            if (num2 == 0) {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                return;
            }
            resultado = num1 / num2;
        } else if (rbRestar.isChecked()) {
            resultado = num1 - num2;
        } else {
            Toast.makeText(this, "Elige una operación", Toast.LENGTH_SHORT).show();
        }

        tvResultado.setText("Resultado: " + resultado);
    }
}