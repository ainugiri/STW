/*is used to refer method of functional interface. 
It is compact and easy form of lambda expression. 
Each time when you are using lambda expression to just referring a method, 
you can replace your lambda expression with method reference. 

types of method references in java:

Reference to a static method.
Reference to an instance method.
Reference to a constructor.
*/
package com;

import java.util.function.BiFunction;

interface Sayable{  
    void say();  
}  

interface Messageable{  
    Message getMessage(String msg);  
}  

public class MethodRef {

	public MethodRef() {
		// TODO Auto-generated constructor stub
	}
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }
    public static void ThreadStatus(){  
        System.out.println("Thread is running...");  
    }  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		Reference to a Static Method
 * 		You can refer to static method defined in the class. 
 * 		Following is the syntax and example which describe 
 * 		the process of referring static method in Java.
*/
        // Referring static method  
        Sayable sayable = MethodRef::saySomething;  
        // Calling interface method  
        sayable.say();  
        
        
//        predefined functional interface Runnable to refer static method
        Thread t2=new Thread(MethodRef::ThreadStatus);  
        t2.start();       

/*      we can use predefined functional interface to refer methods. 
 * 		In the following example, we are using BiFunction interface and using it's apply() method.
*/

        BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  
        int result = adder.apply(10, 20);  
        System.out.println(result);  

/*        You can also override static methods by referring methods. 
 * 		  	In the following example, 
 * 				we have defined and overloaded three add methods.
*/
        BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;  
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;  
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;  
        int result1 = adder1.apply(10, 20);  
        float result2 = adder2.apply(20, 30.0f);  
        float result3 = adder3.apply(30.0f, 40.0f);  
        System.out.println(result1);  
        System.out.println(result2);  
        System.out.println(result3);  

        
/*        2) Reference to an Instance Method
        	like static methods, you can refer instance methods also. 
        	In the following example, we are describing the process of referring the instance method.
*/
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object  
        // Referring non-static method using reference  
            Sayable sayableInst = methodReference::saySomething;  
        // Calling interface method  
            sayableInst.say();  
            // Referring non-static method using anonymous object
            
            Sayable sayableInst2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also  
            // Calling interface method  
            sayableInst2.say();  

/*            In the following example, 
            we are referring instance (non-static) method. 
            Runnable interface contains only one abstract method. 
            So, we can use it as functional interface.
*/
            Thread instT1=new Thread(new InstanceMethodReference()::printnMsg);  
            instT1.start();       

/*            In the following example, 
 * 			we are using BiFunction interface. 
 * 			It is a predefined interface and contains a functional method apply(). 
 * 			Here, we are referring add method to apply method.
*/
//            BiFunction<Integer, Integer, Integer>adder = Arithmetic::add;  //for static method

            BiFunction<Integer, Integer, Integer>adderInst = new Arithmetic()::add1;  
            int resultInst = adderInst.apply(10, 20);  
            System.out.println(resultInst);  

            
            
/*            3) Reference to a Constructor
 * 				You can refer a constructor by using the new keyword.
 * 				Here, we are referring constructor with the help of functional interface.
 * 				SYNTAX  :  ClassName::new  
*/

            Messageable hello = Message::new;  
            hello.getMessage("Hello");  

	}
}
