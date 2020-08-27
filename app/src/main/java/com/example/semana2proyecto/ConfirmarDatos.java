package com.example.semana2proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    TextView vNombre,vFecha,vTelefono,vEmail,vDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        vNombre = findViewById(R.id.vNombre);
        vFecha = findViewById(R.id.vFecha);
        vTelefono = findViewById(R.id.vTelefono);
        vEmail = findViewById(R.id.vEmail);
        vDescripcion = findViewById(R.id.vDescripcion);
        btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mostrarDato();
    }

    private void mostrarDato() {
        Bundle datos=this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String fecha = datos.getString("date");
        String telefono = datos.getString("tel");
        String email = datos.getString("mail");
        String descripcion = datos.getString("descr");

        vNombre.setText("Nombre: "+nombre);
        vFecha.setText("Fecha de nacimiento: "+fecha);
        vTelefono.setText("Telefono: "+telefono);
        vEmail.setText("Email: "+email);
        vDescripcion.setText("Descripción: "+descripcion);
    }
}