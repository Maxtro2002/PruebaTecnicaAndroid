package com.example.pruebatecnica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText1, editText2;
    TextView textView;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.txtNumber1);
        editText2 = (EditText)findViewById(R.id.txtNumber2);
        textView = (TextView)findViewById(R.id.lblResult);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String inputNumber1 = editText1.getText().toString();
            String inputNumber2 = editText2.getText().toString();

            if (TextUtils.isEmpty(inputNumber1) || TextUtils.isEmpty(inputNumber2)) {
                Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
                return;
            }

            float number1 = Float.parseFloat(inputNumber1);
            float number2 = Float.parseFloat(inputNumber2);

            float res = number1 + number2;
            res = (float) (Math.round(res * 100.0) / 100.0);

            textView.setText("Resultado: " + res);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }

}