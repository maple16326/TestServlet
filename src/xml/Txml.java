package xml;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



public class Txml {

	public static void main(String[] args) {

		FibonacciSequenceRequest fibonacciSequenceRequest = new FibonacciSequenceRequest();
		try {
			fibonacciSequenceRequest.setLength(7);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		PrintWriter out=null;
		JAXBContext context;
				
		try {
			context = JAXBContext.newInstance(FibonacciSequenceRequest.class);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");	
			out = new PrintWriter(new BufferedWriter(
						new FileWriter("C:\\workspace\\exercise3\\src\\FibonacciSequenceRequest.xml")));		
			StringWriter writer = new StringWriter();
			mar.marshal(fibonacciSequenceRequest, writer);
			out.println(writer.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(out!=null)
			out.close();
		}
		
		JosephProblemRequest josephproblemrequest = new JosephProblemRequest();
		Circle circle1=new Circle();
		String []arr2={"a","b","c","1","2","3","d","ee"};		
			circle1.setPeoples(arr2);
			circle1.setInterval(1);
			circle1.setStartNo(0);
		josephproblemrequest.setCircle(circle1);
		PrintWriter out1=null;
		JAXBContext context1;
		try {
			context1 = JAXBContext.newInstance(JosephProblemRequest.class);
			Marshaller mar1 = context1.createMarshaller();
			mar1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mar1.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");	
			out1 = new PrintWriter(new BufferedWriter(
						new FileWriter("C:\\workspace\\exercise3\\src\\JosephProblemRequest.xml")));		
			StringWriter writer = new StringWriter();
			mar1.marshal(josephproblemrequest, writer);
			out1.println(writer.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{if(out1!=null)
			out1.close();
		}
		
	}

}
