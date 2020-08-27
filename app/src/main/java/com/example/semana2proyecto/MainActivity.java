package com.example.semana2proyecto;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = ".MainActivity";
    private OnDateSetListener mDateSetListener;
    private EditText mDisplayDate;
    EditText nombre,fecha,telefono,email,descripcion;
    Button btnNext;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre     =findViewById(R.id.textNombre);
        fecha      =findViewById(R.id.textFecha);
        telefono   =findViewById((R.id.textTelefono));
        email      =findViewById(R.id.textEmail);
        descripcion=findViewById(R.id.textDescripcion);
        btnNext    =findViewById(R.id.btnSiguiente);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name     = nombre.getText().toString();
                String date     = fecha.getText().toString();
                String tel      = telefono.getText().toString();
                String mail     = email.getText().toString();
                String descr    = descripcion.getText().toString();

                Intent i=new Intent(MainActivity.this,ConfirmarDatos.class);
                i.putExtra("name", name);
                i.putExtra("date", date);
                i.putExtra("tel", tel);
                i.putExtra("mail", mail);
                i.putExtra("descr", descr);
                startActivity(i);
            }
        });
        mDisplayDate = findViewById(R.id.textFecha);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View x) {
                Calendar cal = Calendar.getInstance();
                int year    = cal.get(Calendar.YEAR);
                int month   = cal.get(Calendar.MONTH);
                int day     = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }
    @Override

}