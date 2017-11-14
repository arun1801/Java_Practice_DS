package com.accenture.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMultiplication {

    private ArrayMultiplication()
    {

    }
    public void manipulatedString(Integer[] inputArray)
    {
        double multiplicationResult = 1;
        Double[] outputArray = new Double[inputArray.length];
        for(int i=0; i<inputArray.length; i++)
        {
            multiplicationResult = multiplicationResult*inputArray[i];
        }
        for(int j=0; j<inputArray.length; j++)
        {
            outputArray[j] = (multiplicationResult/inputArray[j]);
        }
        System.out.println("Updated Array is:-\n");
        for (int z=0; z<outputArray.length; z++)
        {
            System.out.println("At index "+(z+1)+" value is updated to "+Math.round(outputArray[z]));

        }

    }

    public static void main(String args[])
    {
        ArrayMultiplication arrayObj = new ArrayMultiplication();
        int size;
        Scanner scObj = new Scanner(System.in);
        System.out.println("Enter Size of  Array:- \n");
        size = scObj.nextInt();
        Integer[] arrayInput = new Integer[size];
        System.out.println("Enter Array Elements:- \n");
        for(int i=0; i<size; i++)
        {
            arrayInput[i]=scObj.nextInt();
        }
        arrayObj.manipulatedString(arrayInput);
    }
}
