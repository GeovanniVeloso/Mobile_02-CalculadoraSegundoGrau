package com.example.calceq2g;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et01;
    private EditText et02;
    private EditText et03;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et01 = findViewById(R.id.et01);
        et01.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        et02 = findViewById(R.id.et02);
        et02.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        et03 = findViewById(R.id.et03);
        et03.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btCalc = findViewById(R.id.btCalc);

        btCalc.setOnClickListener(op -> calc());

    }

    private void calc(){

        float a = Float.parseFloat(et01.getText().toString());
        float b = Float.parseFloat(et02.getText().toString());
        float c = Float.parseFloat(et03.getText().toString());


        float delta = (b * b) - (4 * a * c);


        if (a == 0) {
            tvRes.setText(R.string.erro01);
        } else {
            if (delta < 0) {
                tvRes.setText(R.string.erro02);
            } else {

                float x1 = (-b + (float)Math.sqrt(delta)) / (2 * a);
                float x2 = (-b - (float)Math.sqrt(delta)) / (2 * a);


                String res = "Delta = " + delta + "\n";
                res += "x1 = " + x1 + "\n";
                res += "x2 = " + x2;
                tvRes.setText(res);
            }
        }

        et01.setText("");
        et02.setText("");
        et03.setText("");

    }

}