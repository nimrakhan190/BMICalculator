package com.nimra.bmicalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalc;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalc = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htF = Integer.parseInt(edtHeightFt.getText().toString());
                int htI = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = htF*12 + htI;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You are Overweight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Ow));
                }
                else if(bmi<18){
                    txtResult.setText("You are Underweight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Uw));
                }
                else{
                    txtResult.setText("You are healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.H));
                }
            }
        });

    }
}