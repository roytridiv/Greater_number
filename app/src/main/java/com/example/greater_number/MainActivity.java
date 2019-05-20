package com.example.greater_number;


import android.content.DialogInterface;



import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;



public class MainActivity extends AppCompatActivity {
    public Button s, b;
    private TextView t;
    private boolean button_pressed_s = false, button_pressed_b = false , num_2_is_Greater = false , num_1_is_Greater = false;
    int counter = 0;
    int point = 0 ;
    public Random random = new Random();
    boolean header = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        s = findViewById(R.id.button1);
        b = findViewById(R.id.button2);
        t = findViewById(R.id.point);

        changeNumber(random);
        if (!header && counter != 10) t.setText("Attempt: "+ counter +", Point : "+ point );



        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(!header) {
                    header = true;
                    button_pressed_s = true ;
                    button_pressed_b = false;

                    Log.d("MY_APP_DEBUG", "s button clicked " + counter);
                    checkCondition();
                    Log.d("MY_APP_DEBUG", "ki hoitese halar ajaira " + button_pressed_s +" "+ num_1_is_Greater);
                    changeNumber(random);

                }else{

                    button_pressed_s = true ;
                    button_pressed_b = false;

                    Log.d("MY_APP_DEBUG", "s button clicked " + counter);
                    checkCondition();
                    Log.d("MY_APP_DEBUG", "ki hoitese halar ajaira " + button_pressed_s +" "+ num_1_is_Greater);
                    changeNumber(random);

                }

            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(!header){
                    header = true;
                    button_pressed_s = false ;
                    button_pressed_b = true;
                    Log.d("MY_APP_DEBUG", "b button clicked " + counter);
                    checkCondition();
                    Log.d("MY_APP_DEBUG", "ki hoitese halar  " + button_pressed_b +" "+ num_2_is_Greater);
                    changeNumber(random);
                }else{

                    button_pressed_s = false ;
                    button_pressed_b = true;
                    Log.d("MY_APP_DEBUG", "b button clicked " + counter);
                    checkCondition();
                    Log.d("MY_APP_DEBUG", "ki hoitese halar  " + button_pressed_b +" "+ num_2_is_Greater);
                    changeNumber(random);

                }


            }
        });




        Log.d("MY_APP_DEBUG" , " " + point);

    }




    private void checkCondition() {

        if (counter == 10) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Remarks")
                    .setMessage("You have reached your limit .\nYour score is : " + point + "\nWant to try again ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            counter = 0;
                            point = 0;
                            changeNumber(random);
                            t.setText("Attempt: "+ counter +", Point : "+ point );
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            alertDialog.setCancelable(false);
            alertDialog.show();
        }else{

            if(num_1_is_Greater==true && button_pressed_s == true){

                Log.d("MY_APP_DEBUG" , "num 1 greater");

                point++;

                Log.d("MY_APP_DEBUG" , " " + point);
                Toast.makeText(MainActivity.this , " Good Choice , number 1 was greater" , Toast.LENGTH_SHORT).show();

            }else if(num_2_is_Greater==true && button_pressed_b == true){
                Log.d("MY_APP_DEBUG" , "num 2 greater");
                point++;
                Log.d("MY_APP_DEBUG" , " " + point);
                Toast.makeText(MainActivity.this , " Good Choice number 2 was greater " , Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, " Sorry WRONG ANSWER ", Toast.LENGTH_SHORT).show();
            }

        }
        t.setText("Attempt: "+ counter +", Point : "+ point );
    }

    private void changeNumber(Random rand) {
        Log.d("MY_APP_DEBUG" , "random number");
        int num1 = rand.nextInt(5) + 1 ;
        int num2 = rand.nextInt(6) + 2 ;


        if(num1 == num2){
            num1 = num1 + 2;
        }

        s.setText(" "+num1);

        b.setText(" " + num2);

        Log.d("MY_APP_DEBUG", "kon number ta boro ajaira  check e pthaitesi  " + num1 +" "+ num2);
        checknumber(num1, num2);

    }


    private void checknumber(int num1 , int num2) {
        Log.d("MY_APP_DEBUG" , "chcking numeber");
        Log.d("MY_APP_DEBUG", "kon number ta boro ajaira " + num1 +" "+ num2);
        if(num1 > num2){
            num_1_is_Greater= true;
            num_2_is_Greater = false;
        }else{
            num_1_is_Greater = false;
            num_2_is_Greater = true;
        }

    }
}

