package org.enjekt.osgi.models.impl;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EchoResponseMessage {

	private String echoResponse;
	
	public EchoResponseMessage(){}
	public EchoResponseMessage(String messageToEcho) {
		super();
		this.echoResponse = messageToEcho;
	}
	public String getEchoResponse() {
		return echoResponse;
	}
	public void setEchoResponse(String echoResponse) {
		this.echoResponse = echoResponse;
	}



}
