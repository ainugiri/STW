package com;

import com.FunctionalInterface.sayable;

public class FuncInterface implements sayable {

	public FuncInterface() {
		// TODO Auto-generated constructor stub
	}
    public void say(String msg){  
        System.out.println(msg);  
    }  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncInterface fi1 = new FuncInterface();
		fi1.say("Functional Interface");
		
	}

}
