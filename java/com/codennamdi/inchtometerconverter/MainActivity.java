package com.codennamdi.inchtometerconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Class variables
    EditText inchesText;
    Button calculateBtn;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inches = inchesText.getText().toString();

                // Checking if the inches input field is empty
                if (inches.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input a text value", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Result", Toast.LENGTH_LONG).show();
                    double meterResult = convertToMeters();
                    displayResult(meterResult);
                }
            }
        });
    }

    //Getting all the ids needed
    private void getViews() {
        inchesText = findViewById(R.id.inches_text_id);
        calculateBtn = findViewById(R.id.calculate_btn_id);
        resultText = findViewById(R.id.result_text_id);
    }

    private double convertToMeters() {
        //Getting the Inch Text from the EditText view and converting it to a string
        String inches = inchesText.getText().toString();

        //String text to Integer
        int inchesText = Integer.parseInt(inches);

        // Converting Inches to Meters
       return inchesText * 0.0254;
    }

    private void displayResult(double meter){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
         String meterFormattedResult = myDecimalFormatter.format(meter);

        resultText.setText(meterFormattedResult + " meters");
    }
}