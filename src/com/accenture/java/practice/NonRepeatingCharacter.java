package com.accenture.java.practice;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatingCharacter {

    HashMap<Character, Integer> mapObj = new LinkedHashMap<Character, Integer>();

    private NonRepeatingCharacter()
    {

    }

    public List<Character> checkNonRepeatingCharacter(String stringtoCheck)
    {
        for(int i=0; i<stringtoCheck.length(); i++)
        {
            if(!mapObj.containsKey(stringtoCheck.charAt(i)))
            {
                mapObj.put(stringtoCheck.charAt(i),1);
            } else
            {
                mapObj.put(stringtoCheck.charAt(i),mapObj.get(stringtoCheck.charAt(i))+1);
            }

        }
        System.out.println("Non Repeating Characters are:- \n");
      /*  for(Map.Entry<Character, Integer> entry : mapObj.entrySet())
        {
            if(entry.getValue() == 1)
            {
                System.out.print(entry.getKey());
            }
        }*/
        return mapObj.entrySet().stream().filter(entry -> entry.getValue() == 1).map(value -> value.getKey()).collect(Collectors.toList());
    }

    public static void main(String args[])
    {
        NonRepeatingCharacter nObj = new NonRepeatingCharacter();
        String stringToCheck;
        Scanner scObj = new Scanner(System.in);
        stringToCheck = scObj.nextLine();
        List<Character> listTemp = nObj.checkNonRepeatingCharacter(stringToCheck);
        System.out.println(listTemp);
    }
}
