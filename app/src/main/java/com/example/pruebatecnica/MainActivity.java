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

    EditText et1, et2;
    TextView tv1;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txtNumber1);
        et2 = (EditText)findViewById(R.id.txtNumber2);
        tv1 = (TextView)findViewById(R.id.lblResult);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            String input1 = et1.getText().toString();
            String input2 = et2.getText().toString();

            if (TextUtils.isEmpty(input1) || TextUtils.isEmpty(input2)) {
                Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
                return;
            }

            float n1 = Float.parseFloat(input1);
            float n2 = Float.parseFloat(input2);

            float res = n1 + n2;
            res = (float) (Math.round(res * 100.0) / 100.0);

            tv1.setText("Resultado: " + res);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }

}