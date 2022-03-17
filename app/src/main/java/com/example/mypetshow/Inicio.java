package com.example.mypetshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class Inicio extends AppCompatActivity  implements View.OnClickListener{

    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        TextView = findViewById(R.id.textView);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                TextView.setText(l+"");
            }

            @Override
            public void onFinish() {
                Intent Y = new Intent(Inicio.this,MainActivity.class);
                startActivity(Y);
            }
        }.start();
    }

    @Override
    public void onClick(View view) {

    }
}