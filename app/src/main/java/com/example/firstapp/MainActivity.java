package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn =  findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstET =  findViewById(R.id.firstNum);
                EditText secondET =  findViewById(R.id.secondNum);
                TextView resultTV =  findViewById(R.id.result);

                int num1 = Integer.parseInt(firstET.getText().toString());
                int num2 = Integer.parseInt(secondET.getText().toString());
                int result = num1 + num2;

                resultTV.setText((String.valueOf(result)));
            }
        });
    }
}
