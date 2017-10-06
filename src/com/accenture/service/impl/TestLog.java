package com.accenture.service;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public abstract class TestLog {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		PropertyConfigurator.configure("log4j.properties");
	        logger.debug("This is debug message.");  
	        logger.info("This is info message.");  
	        logger.error("This is error message."); 
	       
	    

	}

}
