package org.enjekt.osgi.echo;

import org.enjekt.osgi.echo.api.EchoService;
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
		String strResponse = resource.echoString("hello");
		logger.info(strResponse);
		assertNotNull(strResponse);
		assertEquals("Echo:hello",strResponse);


		EchoRequestMessage request = new EchoRequestMessage("hello");
		EchoResponseMessage response = resource.echoObject(request);
		logger.info(response);
		assertNotNull(response);
		assertEquals("Echo:hello",response.getEchoResponse());


	}



}
