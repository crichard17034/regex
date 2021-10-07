/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author crichard
 */
public class Regex {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Pattern basePat = Pattern.compile("([(]?)([0-9]{3})([)]?)([-|.| ]?)"
                + "([0-9]{3})([.|-])([0-9]{4})");
        String phoneNum = "419-123-4567";
        
        System.out.println(validateNum(phoneNum, basePat));
    }
    
    static String validateNum(String phoneNumber, Pattern basePattern)
    { 
        String resultNum;
        Matcher phoneM = basePattern.matcher(phoneNumber);
        if(phoneM.matches())
        {
            String firstInput = phoneM.group(2);
            String secondInput = phoneM.group(5);
            String thirdInput = phoneM.group(7);
            resultNum = ("(" + firstInput + ")" + secondInput + "-" 
                    + thirdInput);
        }
        else
        {
            resultNum = "This is not a valid phone number format.";
        }
        
        return resultNum;
    }
    
}
