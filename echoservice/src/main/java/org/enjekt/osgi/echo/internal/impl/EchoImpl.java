/**
Copyright 2016 Brad Johnson, Enjekt Software
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * 
 */
package org.enjekt.osgi.echo.internal.impl;


import org.enjekt.osgi.echo.api.EchoService;
import org.enjekt.osgi.models.EchoRequestMessage;
import org.enjekt.osgi.models.EchoResponseMessage;

/**
 * The Class EchoTestImpl is a simple implementation class for an echo service.  In this
 * case it is using some common objects via interfaces for logical operations.  This would
 * be overkill for a small service like this but would make sense in a larger context.
 * 
 * 
 */
public class EchoImpl implements EchoService{

	
	/* (non-Javadoc)
	 * @see org.enjekt.osgi.api.echo.EchoService#echoString(java.lang.String)
	 */
	@Override
	public String echoString(String toEcho) {
		
			return createEcho(toEcho);
		
	}

 	/* (non-Javadoc)
	  * @see org.enjekt.osgi.api.echo.EchoService#echoObject(org.enjekt.osgi.models.impl.EchoRequestMessage)
	  */
	 @Override
	public EchoResponseMessage echoObject(EchoRequestMessage request) {
		 return new EchoResponseMessage(createEcho(request.getMessageToEcho()));
 	
	}

	 private String createEcho(String toEcho)
	 {
		 return "Echo:"+toEcho;
	 }


	

}
