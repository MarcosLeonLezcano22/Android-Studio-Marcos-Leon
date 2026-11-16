package com.example.myapplication3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb1,cb2,cb3;

    private Button bt1;
    boolean check1on=false;
    boolean check2on=false;
    boolean check3on=false;

    public void checkOptions(View v){
        if (cb1.isChecked()){
            check1on= true;
        }
        if (cb2.isChecked()){
            check2on= true;
        }
        if (cb3.isChecked()){
            check3on= true;
        }

    }
    public void buttonPressed(View v){
        Toast.makeText(this, "1="+check1on+"\n2 ="+check2on+"\n3 ="+check1on+"\n", Toast.LENGTH_SHORT).show();
    }
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

        cb1=findViewById(R.id.checkBox1);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox3);
    }
}