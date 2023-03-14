package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editWeight,editHeightFt,editHeightIn;
        TextView txtResult;
        Button btnCalculate;
        LinearLayout llmColor;

        editWeight=findViewById(R.id.bWeight);
        editHeightFt=findViewById(R.id.heightFt);
        editHeightIn=findViewById(R.id.heightIn);
        btnCalculate=findViewById(R.id.calcResult);
        txtResult=findViewById(R.id.result);
        llmColor=findViewById(R.id.llm);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(editWeight.getText().toString());
                int ft=Integer.parseInt(editHeightFt.getText().toString());
                int in=Integer.parseInt(editHeightIn.getText().toString());
                int totalIn=ft*12+in;
                double totalCm=totalIn*2.53;
                double totalM=totalCm/100;
                double bmi=wt/(totalM*totalM);
                if(bmi>25){
                    txtResult.setText("You're Overweight");
                    llmColor.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(bmi<19)
                {
                    txtResult.setText("You're UnderWeight");
                    llmColor.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    txtResult.setText("You're Healthy");
                    llmColor.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });



    }
}