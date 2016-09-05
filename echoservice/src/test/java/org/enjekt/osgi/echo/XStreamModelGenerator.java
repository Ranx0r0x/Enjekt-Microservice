package org.enjekt.osgi.echo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.enjekt.osgi.models.EchoResponseMessage;

import com.thoughtworks.xstream.XStream;

public class XStreamModelGenerator {


	
	public static void main(String[] args) throws IOException
	{
		
		Map<String, EchoResponseMessage> models = new HashMap<String,EchoResponseMessage>();
		

		File f =  new File("src/main/resources/test/test.xml");
		if(f.exists())
			f.delete();
		f.createNewFile();
		FileOutputStream fos = new FileOutputStream(f);
		
		new XStream().toXML(models, fos);
		

		
	}
	
}
