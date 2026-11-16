package com.example.spinnermarcosleon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText caja,caja2;
    private Spinner spinner;
    private TextView resultado;
    private String[] operaciones={"sumar","restar","multiplicar","dividir"};

    public void PulsarBoton(View v){
        double num1=Double.parseDouble(caja.getText().toString());
        double num2=Double.parseDouble(caja2.getText().toString());
        double total=0;

        switch (spinner.getSelectedItemPosition()){
            case 0:
                total=num1+num2;
                break;
            case 1:
                total=num1-num2;
                break;
            case 2:
                total=num1*num2;
                break;
            case 3:
                total=num1/num2;
                break;
        }

        resultado.setText(String.valueOf(total));
    }
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
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

        caja=findViewById(R.id.caja);
        caja2=findViewById(R.id.caja2);
        spinner=findViewById(R.id.spinner);
        resultado=findViewById(R.id.resultado);
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,operaciones);
        spinner.setAdapter(adaptador);
    }
}