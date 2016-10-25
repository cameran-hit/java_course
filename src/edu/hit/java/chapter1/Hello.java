package edu.hit.java.chapter1;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		//
        System.out.println("Hello world!");
        //
        System.out.println(0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1);
        System.out.println(0.1*10);

        System.out.println((float)32.3989211134);
        System.out.println((float)32.3989214399);
        //
        float r = 12.0F;
        String str = "The circular area with radius ";
        str = str + r + " is %.3f\n ";
        System.out.printf(str, Math.PI*r*r);
        
        //
        boolean A=true, B=false, C=true;
        System.out.println(A && (B || C));
        //
        Scanner in = new Scanner(System.in); 
        String  yourName= in.nextLine(); 
        System.out.println("Hello, " + yourName);
        in.close();
    }
	/**
	* This method calculates the Body Mass Index(BMI).<BR>
	* Precondition: the height and weight are positive double values<BR>
	* postcondition: return BMI which equals kg/(m*m)<BR>
	* @param m the value of height (positive)
	* @param kg the value of weight (positive)
	* @return the result of kg/(m*m);
	*/
	public static double BMI(double m, double kg) {
		return kg/(m*m);
	}

}
