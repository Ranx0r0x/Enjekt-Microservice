/*
 * Copyright Servicemaster Corporation 2016
 * 
 * All rights reserved.
 * 
 * @author Bradlee Johnson
 */
package org.enjekt.osgi.echo;

import org.enjekt.osgi.echo.api.EchoService;
import org.enjekt.osgi.models.EchoRequestMessage;
import org.enjekt.osgi.models.EchoResponseMessage;
import org.junit.Test;

public class OSGiServiceTest extends BaseTest {

	@Test
	public void testStringEcho() throws Exception {

		EchoService service = super.getOsgiService(EchoService.class);
		assertNotNull(service);

		String response = service.echoString("hello");
		assertNotNull(response);


	}

	@Test
	public void echoWrapperTest() {
		EchoService service = super.getOsgiService(EchoService.class);
		EchoRequestMessage request = new EchoRequestMessage("hello");
		EchoResponseMessage response = service.echoObject(request);
		logger.info(response);
		assertNotNull(response);


	}

}