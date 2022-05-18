package com.thannasorn.findminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnMin, btnClear;
    TextView labelShow;
    EditText numText;
    final String message = "Values Number Add: ";
    int count = 0;
    int min, numArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelShow = (TextView) findViewById(R.id.labelShow);
        numText = (EditText) findViewById(R.id.numText);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnAdd.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnMin.setEnabled(false);
        btnClear.setEnabled(false);
        numArray = new int[5];
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.btnAdd){
            if(numText.getText().toString().length() > 0) {
                if (count == 0) {
                    btnMin.setEnabled(true);
                    btnClear.setEnabled(true);
                }

                numArray[count] = Integer.parseInt(numText.getText().toString());
                labelShow.setText(labelShow.getText().toString() +

                        "\n - > " + numText.getText().toString());

                numText.setText("");
                count++;
                if (count == numArray.length) {
                    btnAdd.setEnabled(false);
                    Toast.makeText(this, "Add 5 Numbers", Toast.LENGTH_LONG).show();
                }
            }
            else
                Toast.makeText(this,"No input number : " + min,Toast.LENGTH_LONG).show();
        }
        else if (view.getId() == R.id.btnMin) {
            min = findMin();
            Toast.makeText(this,"Minimum number : " + min,Toast.LENGTH_LONG).show();
        }
        else if (view.getId() == R.id.btnClear) {
            numText.setText("");
            labelShow.setText( message);
            btnMin.setEnabled(false);
            btnClear.setEnabled(false);
            btnAdd.setEnabled(true);
            count = 0;
        }
    }
    public int findMin() {
        int min = numArray[0];
        for (int n = 1 ; n < count ; n++)
            if (min > numArray[n]) min = numArray[n];
        return min;
    }
}