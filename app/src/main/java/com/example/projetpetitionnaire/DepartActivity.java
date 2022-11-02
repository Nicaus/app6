package com.example.projetpetitionnaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class DepartActivity extends AppCompatActivity {

    Button boutonRecup, boutonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart);

        boutonRecup = findViewById(R.id.boutonRecup);
        boutonStart = findViewById(R.id.boutonStart);

        Ecouteur ec = new Ecouteur();
        boutonStart.setOnClickListener(ec);
        boutonRecup.setOnClickListener(ec);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private class Ecouteur implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == boutonRecup){
                Context context = getApplicationContext();
                Vector<String> vector = new Vector<>();
                Object text;
                String test;
                try {
                    List<Membre> membres = new ArrayList<>();

                    FileInputStream fis = openFileInput("fichier.ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    text = ois.readObject();

                    //for loop

                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text.toString(), duration);
                    toast.show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (view == boutonStart){
                startActivity(new Intent(DepartActivity.this, ConteneurFragmentsActivity.class));
            }
        }
    }
}