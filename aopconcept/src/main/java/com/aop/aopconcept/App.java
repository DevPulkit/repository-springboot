package com.aop.aopconcept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext context=new ClassPathXmlApplicationContext("com/aop/aopconcept/config.xml");
    	
    	PaymentService paymentObj=context.getBean("payment", PaymentService.class);
    	
    	paymentObj.makePayment();
    	
    }
}
