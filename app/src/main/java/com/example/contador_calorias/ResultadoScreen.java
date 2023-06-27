package com.example.contador_calorias;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadoScreen extends AppCompatActivity {

    TextView caloriasTotal;
    SharedPreferences sp;
    String caloriasText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_activity);

        caloriasTotal = findViewById(R.id.caloriasTotal);
        sp = getSharedPreferences("PREFS_KEY", Context.MODE_PRIVATE);

        caloriasText = sp.getString("caloriasTotal","");

        caloriasTotal.setText(caloriasText);

    }
}
