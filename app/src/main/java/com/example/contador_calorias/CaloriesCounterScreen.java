package com.example.contador_calorias;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesCounterScreen extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private Button confirmarBtn;
    private ImageView arrowIcon;
    private EditText[] alimentosET = new EditText[6];
    private EditText[] caloriasET = new EditText[6];
    String alimentoText;
    String caloriasText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_counter_activity);

        confirmarBtn = findViewById(R.id.confirmarButton);
        arrowIcon = findViewById(R.id.arrowIcon);
        alimentosET[0] = findViewById(R.id.alimentosET);
        alimentosET[1] = findViewById(R.id.alimentosET2);
        alimentosET[2] = findViewById(R.id.alimentosET3);
        alimentosET[3] = findViewById(R.id.alimentosET4);
        alimentosET[4] = findViewById(R.id.alimentosET5);
        alimentosET[5] = findViewById(R.id.alimentosET6);
        caloriasET[0] = findViewById(R.id.caloriasET);
        caloriasET[1] = findViewById(R.id.caloriasET2);
        caloriasET[2] = findViewById(R.id.caloriasET3);
        caloriasET[3] = findViewById(R.id.caloriasET4);
        caloriasET[4] = findViewById(R.id.caloriasET5);
        caloriasET[5] = findViewById(R.id.caloriasET6);

        confirmarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obterDadosCampos();
                if (!caloriasText.isEmpty() && !alimentoText.isEmpty()) {
                    Intent intent = new Intent(CaloriesCounterScreen.this, ResultadoScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        arrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaloriesCounterScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void obterDadosCampos() {
        int totalCalorias = 0;
        sp = getSharedPreferences("PREFS_KEY", Context.MODE_PRIVATE);
        spEditor = sp.edit();

        for (int i = 0; i < alimentosET.length; i++) {
            alimentoText = alimentosET[i].getText().toString().trim();
            caloriasText = caloriasET[i].getText().toString().trim();

            if (!caloriasText.isEmpty() && !alimentoText.isEmpty()) {
                int calorias = Integer.parseInt(caloriasText);
                totalCalorias += calorias;
                spEditor.putString("caloriasTotal", String.valueOf(totalCalorias));
            }
        }

        spEditor.apply();

    }

}
