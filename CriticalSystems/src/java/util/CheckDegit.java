package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s20163048
 */
public class CheckDegit {

    public static String Check(String num) {
//        if(num.length() != 7 ){
//            throw new IllegalArgumentException(num);
//        }
    final int[] weights = { 3, 1 };
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            sum += Character.getNumericValue(num.charAt(i)) * weights[i & 1];
        }
        sum = 10 - ( sum % 10 );
        if(sum == 10){
            sum = 0;
        }
        
        String s = num.concat(Integer.toString(sum));
        return s;
    }
}
