package com.example.midterm_calc_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        TextView result = findViewById(R.id.result);
        int calc = (inIntent.getIntExtra("Num1", 0));

        int calValue = 0;
        String str = "전달받은 값 :"+calc;
        result.setText(str);



        final int retValue = calValue;


        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", calc);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}