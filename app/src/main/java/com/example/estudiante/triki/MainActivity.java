package com.example.estudiante.triki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int jugador;
    boolean turno;
    Servidor servidor;
    int[][] botones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turno = true;
        botones = new int[3][3];

        servidor = new Servidor(this, jugador);
        servidor.start();


        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        //new Thread(servidor).start();



        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {


            impirmirX(view);
            btn.setText("x");







    }

    private void impirmirX(View view) {
        if(view.getId() == R.id.button){
            btn.setText("x");
            btn.setEnabled(false);
        }
        else if(view.getId() == R.id.button2){
            btn2.setText("x");
            btn2.setEnabled(false);
        }
        else if(view.getId() == R.id.button3){
            btn3.setText("x");
            btn3.setEnabled(false);
        }
        else if(view.getId() == R.id.button4){
            btn4.setText("x");
            btn4.setEnabled(false);
        }
        else if(view.getId() == R.id.button5){
            btn5.setText("x");
            btn5.setEnabled(false);
        }
        else if(view.getId() == R.id.button6){
            btn6.setText("x");
            btn6.setEnabled(false);
        }
        else if(view.getId() == R.id.button7){
            btn7.setText("x");
            btn7.setEnabled(false);
        }
        else if(view.getId() == R.id.button8){
            btn8.setText("x");
            btn8.setEnabled(false);
        }
        else if(view.getId() == R.id.button9){
            btn9.setText("x");
            btn9.setEnabled(false);
        }
    }


}
