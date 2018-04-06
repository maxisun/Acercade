package com.example.max00.acercade;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //variables
    private TextView nombre;
    private TextView ocupacion;
    private TextView github;
    private TextView twitter;
    private TextView correo;
    private TextView telefono;
    //private ImageView maxisun;
    private Uri maxisun;
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
        maxisun = Uri.parse("android.resource://res/drawable/telefono.png");

        /*ArrayList<Uri> imageUris = new ArrayList<Uri>();
        imageUris.add(imageUri1); // Add your image URIs here
        imageUris.add(imageUri2);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share images to.."));*/

        final ArrayList<String> imageUris = new ArrayList<String>();
        imageUris.add(nombre.getText().toString()); // Add your image URIs here
        imageUris.add(ocupacion.getText().toString());


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent_TEXT();
            }
        });




    }

    public void intent_TEXT(){

        final ArrayList<String> imageUris = new ArrayList<String>();
        imageUris.add(nombre.getText().toString()); // Add your image URIs here
        imageUris.add(ocupacion.getText().toString());

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putExtra(Intent.EXTRA_TEXT, imageUris);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Share text to.."));

        /*Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putExtra(Intent.EXTRA_TEXT, nombre.getText().toString());
        shareIntent.putExtra(Intent.EXTRA_TEXT, ocupacion.getText().toString());
        //shareIntent.putExtra(Intent.EXTRA_STREAM, maxisun);
        shareIntent.setType("image/*");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "Share images..."));

        /*Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share images to.."));


        Intent sendTextIntent = new Intent();
        sendTextIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,nombre);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,ocupacion);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,github);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,twitter);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,correo);
        sendTextIntent.putExtra(Intent.EXTRA_TEXT,telefono);
        startActivity(sendTextIntent);

        /*Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, maxisun);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));*/

    }
}
