package org.enjekt.osgi.echo;

import org.enjekt.osgi.api.echo.EchoService;
import org.enjekt.osgi.microserver.impl.RSClientFactory;
import org.enjekt.osgi.models.impl.EchoRequestMessage;
import org.enjekt.osgi.models.impl.EchoResponseMessage;
import org.junit.Test;

public class RestTest extends BaseTest {
	


	@Test
	//@Ignore
	public void testEchoString() throws Exception {
		EchoService resource = RSClientFactory.create("http://localhost:9001/resources/echo",EchoService.class) ;
		assertNotNull(resource);
		String strReponse = resource.echoString("hello");
		logger.info(strReponse);
		assertNotNull(strReponse);
		
		System.out.println(strReponse);


		EchoRequestMessage request = new EchoRequestMessage("hello");
		EchoResponseMessage response = resource.echoObject(request);
		logger.info(response);
		assertNotNull(response);
		
		System.out.println("Response EchoObject: " + response);


	}



}
