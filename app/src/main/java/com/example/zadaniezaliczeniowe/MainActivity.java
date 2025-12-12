package com.example.zadaniezaliczeniowe;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String wygenerowaneHaslo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText imie = findViewById(R.id.imie);
        EditText nazwisko = findViewById(R.id.nazwisko);
        EditText iloscznakow = findViewById(R.id.iloscznakow);
        CheckBox cbLitery = findViewById(R.id.maleiwielkieliterycheckbox);
        CheckBox cbCyfry = findViewById(R.id.cyfrycheckbox);
        CheckBox cbZnaki = findViewById(R.id.znakispecjalnecheckbox);
        Button btnGeneruj = findViewById(R.id.generujhaslobutton);
        Button btnZatwierdz = findViewById(R.id.zatwierdzbutton);
        Spinner spinner = findViewById(R.id.spinner);

        String[] stanowiska = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stanowiska);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        String male = "abcdefghijklmnopqrstuvwxyz";
        String duze = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cyfry = "0123456789";
        String znaki = "!@#$%^&*()_+-=.";

        btnGeneruj.setOnClickListener(v -> {

            int dlugosc;
            try {
                dlugosc = Integer.parseInt(iloscznakow.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, "Podaj liczbę znaków!", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder haslo = new StringBuilder();

            for (int i = 0; i < dlugosc; i++) {
                int index = (int) (Math.random() * male.length());
                haslo.append(male.charAt(index));
            }

            if (cbLitery.isChecked() && dlugosc > 0) {
                int index = (int) (Math.random() * duze.length());
                haslo.setCharAt(0, duze.charAt(index));
            }

            if (cbCyfry.isChecked() && dlugosc > 1) {
                int index = (int) (Math.random() * cyfry.length());
                haslo.setCharAt(1, cyfry.charAt(index));
            }

            if (cbZnaki.isChecked() && dlugosc > 2) {
                int index = (int) (Math.random() * znaki.length());
                haslo.setCharAt(2, znaki.charAt(index));
            }

            wygenerowaneHaslo = haslo.toString();

            new AlertDialog.Builder(this)
                    .setTitle("Wygenerowane hasło")
                    .setMessage(wygenerowaneHaslo)
                    .setPositiveButton("OK", null)
                    .show();
        });

        btnZatwierdz.setOnClickListener(v -> {

            String komunikat =
                    "Imię: " + imie.getText().toString() +
                            "\nNazwisko: " + nazwisko.getText().toString() +
                            "\nStanowisko: " + spinner.getSelectedItem().toString() +
                            "\nHasło: " + wygenerowaneHaslo;

            new AlertDialog.Builder(this)
                    .setTitle("Dane pracownika")
                    .setMessage(komunikat)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}
