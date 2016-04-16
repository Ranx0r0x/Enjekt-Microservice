package org.enjekt.osgi.echo;

import org.enjekt.osgi.api.echo.EchoService;
import org.enjekt.osgi.microserver.impl.WSClientFactory;
import org.enjekt.osgi.models.impl.EchoRequestMessage;
import org.enjekt.osgi.models.impl.EchoResponseMessage;
import org.junit.Test;

/**
 * The Class SoapServiceTest.
 */

public class SoapServiceTest extends BaseTest{
 
	@Test
	public void testEcho() throws Exception {
		EchoService wsClient = WSClientFactory.create("http://localhost:9001/services/echo",EchoService.class);

		String echo = wsClient.echoString("hello");
		assertNotNull(echo);
		assertEquals("Echoing: hello", echo);
		logger.info(echo);

	}
 
	@Test
	public void testEchoObject() throws Exception {
		EchoService wsClient = WSClientFactory.create("http://localhost:9001/services/echo",EchoService.class);
		EchoRequestMessage request = new EchoRequestMessage("A message to echo.");
	
		EchoResponseMessage echo = wsClient.echoObject(request);
		assertNotNull(echo);

		logger.info(echo.getEchoResponse());

	}

}