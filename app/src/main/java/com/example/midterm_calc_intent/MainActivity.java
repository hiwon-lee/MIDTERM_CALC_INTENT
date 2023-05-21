package com.example.midterm_calc_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        final EditText edtNum1 = findViewById(R.id.edtNum1);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);


                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));


                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            int result = 2021-hap+2;
            String resultstr = "한국나이:" + result+"세";
            TextView tw = findViewById(R.id.result);
            tw.setText(resultstr);
        }
    }
}