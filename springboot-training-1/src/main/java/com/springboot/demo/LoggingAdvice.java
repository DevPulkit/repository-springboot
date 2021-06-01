package com.springboot.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;


@Aspect
@Component
public class LoggingAdvice {
	
	Logger log=org.slf4j.LoggerFactory.getLogger(LoggingAdvice.class);
	
	//@Pointcut(value="execution(* com.springboot.demo .*.*(..)")
	@Pointcut(value="execution(* com.springboot.demo.*.*(..))")
	public void myPointcut() {
		
	}
	
	@Pointcut(value="execution(* com.springboot.demo.*.*(..))")
	public void pointcutTime() {
		
	}
	
	@Around("myPointcut()")
	public Object appLogger(ProceedingJoinPoint pjp) throws Throwable {
		
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
		log.info("method invoked" + className +" : " +methodName+"()"+ mapper.writeValueAsString(array));
		
		Object object=pjp.proceed();
		log.info(className + " : "+ methodName + "()" + "Response : "+ mapper.writeValueAsString(object));
		return object;
		}
	
	
	@Around("pointcutTime()")
	 public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		 
		 long startTime=System.currentTimeMillis();
		 Object obj=pjp.proceed();
		 long endTime=System.currentTimeMillis();
		 log.info("Method name"+ pjp.getSignature()+" time taken to execute: "+ (endTime-startTime));
		 return obj;
		 
		 
		 
	 }

}
