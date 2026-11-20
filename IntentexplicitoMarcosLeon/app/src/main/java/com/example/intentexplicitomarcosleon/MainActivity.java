package com.example.intentexplicitomarcosleon;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbWeb = findViewById(R.id.cbWeb);
        CheckBox cbLlamar = findViewById(R.id.cbLlamar);
        CheckBox cbCorreo = findViewById(R.id.cbCorreo);
        CheckBox cbMaps = findViewById(R.id.cbMaps);
        CheckBox cbGaleria = findViewById(R.id.cbGaleria);
        CheckBox cbFoto = findViewById(R.id.cbFoto);
        Button btnAbrir = findViewById(R.id.btnAbrir);

        btnAbrir.setOnClickListener(v -> {
            if (!cbWeb.isChecked() && !cbLlamar.isChecked() && !cbCorreo.isChecked()
                    && !cbMaps.isChecked() && !cbGaleria.isChecked() && !cbFoto.isChecked()) {
                Toast.makeText(this, "Marca al menos una opción", Toast.LENGTH_SHORT).show();
                return;
            }
            if (cbWeb.isChecked()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                abrir(intent);
            }
            if (cbLlamar.isChecked()) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:600123456"));
                abrir(intent);
            }
            if (cbCorreo.isChecked()) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ejemplo@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hola");
                intent.putExtra(Intent.EXTRA_TEXT, "Este es un correo de prueba");
                abrir(intent);
            }
            if (cbMaps.isChecked()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.4168,-3.7038?q=Madrid"));
                abrir(intent);
            }
            if (cbGaleria.isChecked()) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                abrir(intent);
            }
            if (cbFoto.isChecked()) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                abrir(intent);
            }
        });
    }


    private void abrir(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No hay ninguna app para esta opción", Toast.LENGTH_SHORT).show();
        }
    }
}