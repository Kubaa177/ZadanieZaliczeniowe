package com.example.zadaniezaliczeniowe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        TextView wynikhasla = findViewById(R.id.wynikhasla);
        EditText imie = findViewById(R.id.imie);
        EditText nazwisko = findViewById(R.id.nazwisko);
        EditText iloscznakow = findViewById(R.id.iloscznakow);
        CheckBox maleiwielkieliterycheckbox = findViewById(R.id.maleiwielkieliterycheckbox);
        CheckBox cyfrycheckbox = findViewById(R.id.cyfrycheckbox);
        CheckBox znakispecjalnecheckbox = findViewById(R.id.znakispecjalnecheckbox);
        Button generujhaslobutton = findViewById(R.id.generujhaslobutton);
        Button zatwierdzbutton = findViewById(R.id.zatwierdzbutton);
        Spinner spinner = findViewById(R.id.spinner);

        String wygenerowanehaslo = "";

        String malelitery = "abcdefghijklmnopqrstuvwxyz";
        String duzelitery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String liczby = "0123456789";
        String znakispecjalne = "!@#$%^&*()_+-=.";

        String[] stanowiska = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stanowiska);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //.setAdapter(adapter);


    }
}