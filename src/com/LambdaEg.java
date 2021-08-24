/**
 * provides a clear and concise way to represent one method interface using an expression. 
 * It is very useful in collection library. It helps to iterate, filter and extract data from collection.
 */
package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

interface Drawable{
	public void draw();
}
interface Sayable1{  
    public String say1();  
}
interface Sayable2{  
	public String say2(String name);
}

interface Addable{
    int add(int a,int b);  	
 }  
interface Sayable3{  
    String say(String message);  
}  
/**
 * @author Dhasaradan
 *
 */
public class LambdaEg {

	/**
	 * 
	 */
	public LambdaEg() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width1 = 10;
		Drawable d1 = new Drawable()
		{
			public void draw() 
			{
				System.out.println("Drawing Width is :\t"+width1);
			}
		};
		d1.draw();
		
		int width2 =25;
		Drawable d2 = ()->{		//
			System.out.println("Drawing Width is :\t"+width2);
		};
		d2.draw();

		Sayable1 s1=()->{  
	        return "I have nothing to say.";  
	    };  
	    System.out.println(s1.say1());  
	    
        Sayable2 s2=(name)->{  
            return "Hello, "+name;  
        };  
        System.out.println(s2.say2("Giri"));  
          
        // You can omit function parentheses    
        Sayable2 s3= name ->{  
            return "Hello, "+name;  
        };  
        System.out.println(s3.say2("Prasad"));  
        
        // Multiple parameters in lambda expression  
        Addable ad1=(a,b)->(a+b);  
        System.out.println(ad1.add(10,20));  
          
        // Multiple parameters with data type in lambda expression  
        Addable ad2=(int a,int b)->(a+b);  
        System.out.println(ad2.add(300,200));  
        Addable ad3=(int a,int b)->{  
            return (a+b);   
            };  
        System.out.println("With return"+ad3.add(100,200)); 
        
        List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
        System.out.println("list.forEach((n)->System.out.println(n));  ");
        list.forEach((n)->System.out.println(n));  
        
        Sayable3 person = (message)-> {  
            String str1 = "You can pass, ";  
            String str2 = str1 + message;   
            return str2;  
        };  
            System.out.println(person.say(person.say("multiple statements in LAMBDA Expression.")));  
            
            Runnable r1=new Runnable(){  
                public void run(){  
                    System.out.println("Thread1 is running...");  
                }  
            };  
            Thread t1=new Thread(r1);  
            t1.start();  
            //Thread Example with lambda  
            Runnable r2=()->{  
                    System.out.println("Thread2 is running...");  
            };  
            Thread t2=new Thread(r2);  
            t2.start();  
            List<Product> list1=new ArrayList<Product>();  
            
            //Adding Products  
            list1.add(new Product(1,"HP Laptop",25000f));  
            list1.add(new Product(3,"Keyboard",300f));  
            list1.add(new Product(2,"Dell Mouse",150f));  
              
            System.out.println("Sorting on the basis of name...");  
      
            // implementing lambda expression  
            Collections.sort(list1,(p1,p2)->{  
            return p1.name.compareTo(p2.name);  
            });  
            for(Product p:list1){  
                System.out.println(p.id+" "+p.name+" "+p.price);
            } 
            
            List<Product> list2=new ArrayList<Product>();  
            list2.add(new Product(1,"Samsung A5",17000f));  
            list2.add(new Product(3,"Iphone 6S",65000f));  
            list2.add(new Product(2,"Sony Xperia",25000f));  
            list2.add(new Product(4,"Nokia Lumia",15000f));  
            list2.add(new Product(5,"Redmi4 ",26000f));  
            list2.add(new Product(6,"Lenevo Vibe",19000f));  

            // using lambda to filter data  
            Stream<Product> filtered_data = list2.stream().filter(p -> p.price > 20000);  
              
            // using lambda to iterate through collection  
            filtered_data.forEach(  
                    product -> System.out.println(product.name+": "+product.price));
            
            //EVENT LISTENER
            JTextField tf=new JTextField();  
            tf.setBounds(50, 50,150,20);  
            JButton b=new JButton("click");  
            b.setBounds(80,100,70,30);  
              
            // lambda expression implementing here.  
            b.addActionListener(e-> {tf.setText("hello swing");});  
              
            JFrame f=new JFrame();  
            f.add(tf);f.add(b);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            f.setLayout(null);  
            f.setSize(300, 200);  
            f.setVisible(true);  


	}

}
