package com.example.mypetshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_intent;
    private Button ActionView;
    private Button Llamada;
    private Button LlamadaE;
    private Button Mensaje;
    private Button Alarma;
    private Button Temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_intent = (Button)findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(this);

        ActionView = findViewById(R.id.btn1);
        ActionView.setOnClickListener(this);

        Llamada = findViewById(R.id.btn2);
        Llamada.setOnClickListener(this);

        LlamadaE = findViewById(R.id.btn3);
        LlamadaE.setOnClickListener(this);

        Mensaje = findViewById(R.id.btn4);
        Mensaje.setOnClickListener(this);

        Alarma = findViewById(R.id.btn5);
        Alarma.setOnClickListener(this);

        Temp = findViewById(R.id.btn6);
        Temp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button B = (Button) view;

        if(B == btn_intent){
            Intent I = new Intent(this,MyVisor.class);

            startActivity(I);
        }
        if(B == ActionView){
            Uri webpage = Uri.parse("https://www.develou.com/desarrollo-android-intents/#Intents_Implicitos");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }
        if(B == Llamada){
            Uri telefono = Uri.parse("tel:8712655150");
            Intent intent = new Intent(Intent.ACTION_DIAL, telefono);
            startActivity(intent);
        }
        if(B == LlamadaE){
            Uri Telefono = Uri.parse("tel:" + "8712655150");
            Intent intent = new Intent(Intent.ACTION_CALL, Telefono);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startService(intent);
            }
        }
        if(B == Mensaje){
            // Create the text message with a string
            String textMessage = "Hola";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
            sendIntent.setType("text/plain");

            // Verify that the intent will resolve to an activity
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(sendIntent);
            }
        }
        if(B == Alarma){

            String message = "Ya";
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_HOUR, 02)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 30);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        if(B == Temp){
            String message = "Hola";
            int seconds = 60;
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}