package com.example.lucky_number;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class second_activity extends AppCompatActivity {
    Button button;
    TextView text1,tex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button=findViewById(R.id.button3);
        text1=findViewById(R.id.textView2);
        tex2=findViewById(R.id.textView3);
        //receiving the data from the main activity.
        Intent in=getIntent();
        //get the string value from the receiving intent
        String i= in.getStringExtra("name");
        int b=random_no();
        tex2.setText(""+b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(i,b);
            }
        });

    }
    //generate the lucking number
    public int random_no(){
        //Random is the in-built class
        Random random=new Random();
        int upper_limit=1000;
        int a=random.nextInt(upper_limit);
        return  a;
    }
    //SHARE THE DETAILS THROUGH THE OTHER APPS
    public void send(String i,int b){
        Intent a=new Intent(Intent.ACTION_SEND);
        a.setType("text/plain");
        //additional information
        a.putExtra(Intent.EXTRA_SUBJECT,i+" got the lucky number");
        a.putExtra(Intent.EXTRA_TEXT,"HIS LUCKY NUMBER IS "+b);
        //FOR SHOWING THE MULTIPLE APPS TO CHOOSE ONLY ONE APP FOR SEND THE DETAILS.
        startActivity(Intent.createChooser(a,"choose the app"));

    }

}