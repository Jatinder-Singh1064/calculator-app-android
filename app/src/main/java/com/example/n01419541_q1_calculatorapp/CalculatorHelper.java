package com.example.n01419541_q1_calculatorapp;

import android.util.Log;
import java.util.Arrays;

public class CalculatorHelper {
    double result;
    int number = 0;
    double memoryResults;
    String historyString;
    String resultString;
    String operator;

    public CalculatorHelper()
    {
        number = 0;
        resultString = "";
        historyString = "";
    }

    public void processResult(int num)
    {
        number = number * 10 + num;
        createResultString(number + "");
        number = 0;
    }

    public void createResultString(String res)
    {
        if (resultString.trim().equals("𝜋")) {
            resultString = "𝜋" + " " + "x" + " " + res;
        } else if (resultString.trim().equals("e")) {
            resultString = "e" + " " + "x" + " " + res;
        } else {
            resultString = resultString + res;
        }
    }

    public void processDivision() {
        operator = "÷";
        if (!updateOperatorSymbol(operator)) {
            createResultString(" " + operator + " ");
        }
    }

    private boolean updateOperatorSymbol(String operator) {
        String strParse[] = resultString.split(" ");

        if (strParse.length == 2) {
            resultString = strParse[0] + " " + operator + " ";
            return true;
        } else {
            return false;
        }
    }

    public void processMultiplication() {
        operator = "x";
        if (!updateOperatorSymbol(operator)) {
            createResultString(" " + operator + " ");
        }
    }

    public void processSubtraction() {
        operator = "-";
        if (!updateOperatorSymbol(operator)) {
            createResultString(" " + operator + " ");
        }
    }

    public void processAddition() {
        operator = "+";
        if (!updateOperatorSymbol(operator)) {
            createResultString(" " + operator + " ");
        }
    }

    public void processPercentage() {
        operator = "%";
        if (!updateOperatorSymbol(operator)) {
            createResultString(" " + operator + " ");
        }
    }

    public void processDecimalPoint() {
        operator = ".";
        createResultString(operator);
    }

    public void processEqualsTo() {
        String strParse[] = resultString.split(" ");

        Log.d("ProcessEqualsTo - Initial ResultString", Arrays.toString(strParse));
        if (strParse.length >= 2 && strParse.length <= 3 && (!strParse[0].equals(""))) {
            if (strParse[1].equals("x")) {
                if (strParse[0].trim().equals("𝜋")) {
                    result = 3.14 * Double.parseDouble(strParse[2]);
                } else if (strParse[0].trim().equals("e")) {
                    result = 2.718 * Double.parseDouble(strParse[2]);
                } else {
                    result = Double.parseDouble(strParse[0]) * Double.parseDouble(strParse[2]);
                }
            } else if (strParse[1].equals("-")) {
                result = Double.parseDouble(strParse[0]) - Double.parseDouble(strParse[2]);
            } else if (strParse[1].equals("÷")) {
                result = Double.parseDouble(strParse[0]) / Double.parseDouble(strParse[2]);
            } else if (strParse[1].equals("+")) {
                result = Double.parseDouble(strParse[0]) + Double.parseDouble(strParse[2]);
            } else if (strParse[1].equals("𝜋")) {
                result = Double.parseDouble(strParse[0]) * 3.14;
            } else if (strParse[1].equals("e")) {
                result = Double.parseDouble(strParse[0]) * 2.718;
            }else if (strParse[1].equals("%")) {
                if(strParse.length < 3) {
                    result = (Double.parseDouble(strParse[0]) / 100 );
                } else{
                    Log.d("Percent Result",strParse[0]);
                    Log.d("Percent Result",strParse[2]);
                    result = (Double.parseDouble(strParse[0]) / 100 ) * Double.parseDouble(strParse[2]);
                }
                Log.d("Percent Result",Double.toString(result));
            }
            Log.d("ProcessEqualsTo","if block");
            historyString = resultString + " = " + result;
            resultString = result + "";
        }
        else if (strParse.length > 3 || (strParse[0].equals("")))
        {
            if(strParse[0].equals(""))
            {
                historyString = "Invalid input";
            }
            else  if (strParse[3].equals("%"))
            {
                double no1  = Double.parseDouble(strParse[0]);
                double no2 = Double.parseDouble(strParse[2]);
                if(strParse[1].equals("+"))
                {
                    result = no1 + ((no1*no2)/100);
                }
                else if(strParse[1].equals("-"))
                {
                    result = no1 - ((no1*no2)/100);
                }
                else  if(strParse[1].equals("x"))
                {
                    result = (no1*no2)/100;
                }
                else if(strParse[1].equals("÷"))
                {
                    result = (no1/no2)*100;
                }
                Log.d("ProcessEqualsTo","else if block");
                Log.d("num1",Double.toString(no1));
                Log.d("num2",Double.toString(no2));
                Log.d("Current Result",Double.toString(result));
                Log.d("Final Result String",Arrays.toString(strParse));
                historyString = resultString + " = " + result;
                resultString = result + "";
            }
        }
        else {
            Log.d("ProcessEqualsTo","else block");
            result = Double.parseDouble(strParse[0]);
            historyString = resultString + " = " + result;
            resultString = result + "";
        }
    }

    public void processClearResult() {
        String strParse[] = resultString.split(" ");
        String res = "";
        int i;

        for (i = 0; i < strParse.length - 1; i++) {
            res = res + strParse[i] + " ";
        }
        if (i == 1) {
            resultString = res.trim();
        } else {
            resultString = res;
        }

        if(i==0)
        {
            historyString = "";
        }
    }

    public void processExponent() {
        operator = "e";
        createResultString(" " + operator + " ");
    }

    public void processPie() {
        operator = "𝜋";
        createResultString(" " + operator + " ");
    }

    public void processMemoryAddTo() {
        if(!resultString.trim().equals(""))
        {
            memoryResults = memoryResults + result;
            if (result == 0.0) {
                memoryResults += Double.parseDouble(resultString.trim());
            }
            result = 0.0;
            historyString = "M: " + memoryResults;
            resultString = "";
        }
    }

    public void processMemorySubtractFrom() {
        if(!resultString.trim().equals(""))
        {
            memoryResults = memoryResults - result;
            if (result == 0.0) {
                memoryResults -= Double.parseDouble(resultString.trim());
            }
            result = 0.0;
            historyString = "M: " + memoryResults;
            resultString = "";
        }
    }

    public void processMemoryClear() {
        if (memoryResults != 0)
        {
            memoryResults = 0;
            historyString = "M: Cleared";
            resultString = result + "";
        }
    }

    public void processMemoryRecall() {
        result = memoryResults;
        resultString = result + "";
    }
}
