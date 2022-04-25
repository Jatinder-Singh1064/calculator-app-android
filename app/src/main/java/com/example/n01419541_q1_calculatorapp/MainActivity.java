package com.example.n01419541_q1_calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalculatorHelper calcHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcHelper = new CalculatorHelper();
    }

    public void numberButtonClicked(View view) {
        Button button = (Button) view;
        int number;

        switch(button.getText().charAt(0))
        {
            case '0' : number = 0; break;
            case '1' : number = 1; break;
            case '2' : number = 2; break;
            case '3' : number = 3; break;
            case '4' : number = 4; break;
            case '5' : number = 5; break;
            case '6' : number = 6; break;
            case '7' : number = 7; break;
            case '8' : number = 8; break;
            case '9' : number = 9; break;
            default: number = -1;
        }
        if(number !=-1)
        {
            calcHelper.processResult(number);
        }
        updateCalcUI();
    }

    private void updateCalcUI() {
        TextView tvResult = findViewById(R.id.tv_result);
        TextView tvHistory = findViewById(R.id.tv_history);

        tvResult.setText(calcHelper.resultString);
        tvHistory.setText(calcHelper.historyString);
    }

    public void divisionButtonClicked(View view) {
        calcHelper.processDivision();
        updateCalcUI();
    }

    public void multiplicationButtonClicked(View view) {
        calcHelper.processMultiplication();
        updateCalcUI();
    }

    public void subtractionButtonClicked(View view) {
        calcHelper.processSubtraction();
        updateCalcUI();
    }

    public void additionButtonClicked(View view) {
        calcHelper.processAddition();
        updateCalcUI();
    }

    public void percentageButtonClicked(View view) {
        calcHelper.processPercentage();
        updateCalcUI();
    }

    public void pointButtonClicked(View view) {
        calcHelper.processDecimalPoint();
        updateCalcUI();
    }

    public void equalsToButtonClicked(View view) {
        calcHelper.processEqualsTo();
        updateCalcUI();
    }

    public void clearButtonClicked(View view) {
        calcHelper.processClearResult();
        updateCalcUI();
    }

    public void exponentButtonClicked(View view) {
        calcHelper.processExponent();
        updateCalcUI();
    }

    public void pieButtonClicked(View view) {
        calcHelper.processPie();
        updateCalcUI();
    }

    public void memoryAddToButtonClicked(View view) {
        calcHelper.processMemoryAddTo();
        updateCalcUI();
    }

    public void memorySubtractFromButtonClicked(View view) {
        calcHelper.processMemorySubtractFrom();
        updateCalcUI();
    }

    public void memoryClearButtonClicked(View view) {
        calcHelper.processMemoryClear();
        updateCalcUI();
    }

    public void memoryRecallButtonClicked(View view) {
        calcHelper.processMemoryRecall();
        updateCalcUI();
    }
}