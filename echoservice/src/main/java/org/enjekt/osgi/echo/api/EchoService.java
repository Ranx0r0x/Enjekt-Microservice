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
package org.enjekt.osgi.echo.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.enjekt.osgi.models.EchoRequestMessage;
import org.enjekt.osgi.models.EchoResponseMessage;

/**
 * The Interface EchoService is for testing deployment of a microservice bundle.
 */
@WebService
@Path("/echo")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public interface EchoService  {
	
	/**
	 * Echo a string back in either SOAP or REST
	 *
	 * @param echoString the echo string
	 * @return the string
	 */
	@GET
	@Path("/{echoID}")
	@WebMethod(operationName = "echoString")
	public String echoString(@WebParam(name = "echoID", targetNamespace = "") @PathParam("echoID") String echoString);
	
	/**
	 * Echo object uses a message wrapper for request/responses in SOAP or REST.
	 *
	 * @param echoObject the echo object
	 * @return the echo response message
	 */
	@GET
	@Path("/")
	@WebMethod(operationName = "echoObject")
	public EchoResponseMessage echoObject(@WebParam(name = "echoObject", targetNamespace = "") @QueryParam("") EchoRequestMessage echoObject);
}
