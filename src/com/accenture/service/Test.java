package com.accenture.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	public static final Logger LOGGER = Logger.getLogger(Test.class);
	public static final String LOG4JPROPERTIES = "log4j.properties";

	public static void main(String[] args) {
		PropertyConfigurator.configure(LOG4JPROPERTIES);
		PropertyTest pt = new PropertyTest();
		for (int i = 0; i < args.length; i++) {
			if ("f".equals(args[i])) {
				List<String> list = new ArrayList<>();
				list = pt.property("f");
				Problem fibo = new Fibonacci();
				String[] ss = list.toArray(new String[list.size()]);
				fibo.solve(ss[1], ss[0]);
			} else if ("j".equals(args[i])) {
				List<String> list = new ArrayList<>();
				list = pt.property("j");
				Problem jose = new Joseph();
				String[] ss = list.toArray(new String[list.size()]);
				jose.solve(ss[1], ss[0]);
			} else {
				LOGGER.info("The argument is invalid！");
			}
		}
	}

}
