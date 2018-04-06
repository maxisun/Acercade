package com.example.max00.acercade;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //variables
    private TextView nombre;
    private TextView ocupacion;
    private TextView github;
    private TextView twitter;
    private TextView correo;
    private TextView telefono;
    private ImageView maxisun;
    private Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancias
        nombre = findViewById(R.id.TV_name);
        ocupacion = findViewById(R.id.TV_profesion);
        github = findViewById(R.id.TV_gituser);
        twitter = findViewById(R.id.TV_twitteruser);
        correo = findViewById(R.id.TV_emailuser);
        telefono = findViewById(R.id.TV_phone);
        share = findViewById(R.id.B_share);
        maxisun = findViewById(R.id.IV_maxisun);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_TEXT(nombre.getText().toString(),ocupacion.getText().toString(),github.getText().toString(),twitter.getText().toString(),correo.getText().toString(),telefono.getText().toString());
            }
        });




    }

    public void intent_TEXT(String nombre, String ocupacion, String github, String twitter, String correo, String telefono){
        Intent sendTextIntent = new Intent();
        sendTextIntent.setAction(Intent.ACTION_SEND);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,nombre);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,ocupacion);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,github);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,twitter);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,correo);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,telefono);
        sendTextIntent.setType("text/plain");
        startActivity(sendTextIntent);
/*
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, maxisun);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));*/

    }
}
