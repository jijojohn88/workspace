package com.lab.exercise;

public class ReverseAnInteger {
	
	
public int reverse(int x) {
		
		Long reversedInt = 0l;
        boolean negative = x < 0;
        
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
        	return 0;
        }
		if(x/10 <1 && negative != true) {
			return x;
		}
        if(negative) {
            x = Math.abs(x); 
        }
		
		while(x/10 >=1) {
			int digit = x%10;
			reversedInt = (10*reversedInt) + digit;
			x = x/10;
		}
		reversedInt = (10*reversedInt) + x;		
        
		if(reversedInt > Integer.MAX_VALUE) {
            return 0;
        } else if(negative) {
            reversedInt = -1 * reversedInt;
        }
        
        
		return reversedInt.intValue();
	
	}
	public static void main(String[] args) {
		int value = new ReverseAnInteger().reverse(2147483647);
		System.out.println(Integer.MIN_VALUE <= -2147483648);
		System.out.println("MInvalue = " + Integer.MIN_VALUE);
		System.out.println("test " + (Integer.MIN_VALUE * -1));
		System.out.println("result " + value);
	}

}
