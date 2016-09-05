package org.enjekt.osgi.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EchoRequestMessage {

	private String messageToEcho;
	
	public EchoRequestMessage(){}
	public EchoRequestMessage(String messageToEcho) {
		super();
		this.messageToEcho = messageToEcho;
	}

	public String getMessageToEcho() {
		return messageToEcho;
	}

	public void setMessageToEcho(String messageToEcho) {
		this.messageToEcho = messageToEcho;
	}
	
}
