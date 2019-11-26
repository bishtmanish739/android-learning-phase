package com.technicalkeeda.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

            public  static  final  String msg = "technicalkeeda.in/multiscreenapp.order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void placeOrder(View view){
        //intent will move one activity to another
       Intent intent =new Intent(this,Main2Activity.class);
        EditText editText1=findViewById(R.id.editText1);
        EditText editText2=findViewById(R.id.editText2);
        EditText editText3=findViewById(R.id.editText3);
        String massege = editText1.getText().toString() +
                ","+ editText2.getText().toString() +
                "&"+ editText3.getText().toString();
        intent.putExtra(msg, massege);
        startActivity(intent);

    }
}
