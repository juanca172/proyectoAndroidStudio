package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.proyectotiendavirtual.R;

public class EditarPerfil extends AppCompatActivity {

    Button btnCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        btnCircle = findViewById(R.id.btnCircle);

    }
}