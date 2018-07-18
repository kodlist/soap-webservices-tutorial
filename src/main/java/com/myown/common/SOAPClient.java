package com.myown.common;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;


/*
 * Created by mkoduri on 7/3/2018.
 * 
 * 
 * @
 * SOAP with Attachments API for Java (SAAJ) is mainly used for dealing directly with SOAP Request/Response messages 
 * which happens behind the scenes in any Web Service API. It allows the developers to directly send and receive 
 * soap messages instead of using JAX-WS.
 * 
 * we need to makesure cacerts are in place for the realpage certificate to have in our cacerts keystore.
 * 
 * usually the cacerts are in C:\Program Files\Java\jre1.8.0_172\lib\security
 * you can open in tools like keystore  and save certificates in cacerts. ( http://keystore-explorer.org/downloads.html)
 * 
 * for ref on keystore to save certificates:
 * 
 * https://stackoverflow.com/questions/38426695/sun-security-provider-certpath-suncertpathbuilderexception-unable-to-find-valid
 * https://stackoverflow.com/questions/6784463/error-trustanchors-parameter-must-be-non-empty/25188331#25188331
 * 
 * to download keystore : http://keystore-explorer.org/downloads.html
 * you can also do it using jdk tools ex: keytool -import -alias root-ca1 -file rootca.crt -keystore keystore.jks (but this is little daunting)
 * 
 * 
 */
public class SOAPClient {
	
	/*
	 * this method doesn't return anything.
	 * we makesure certificates file is in project location.
	 * cacerts is a file in our C:\Program Files\Java\jre1.8.0_172\lib\security
	 * 
	 * we need to makesure cacerts are in place for the realpage certificate to have in our cacerts keystore.
	 * 
	 * before you call soapweb service makesure to call this method.
	 * 
	 * note: this method is not needed if there is no need for certificates.
	 * 
	 */
	public static void setCaCertificatesReady(){		
		System.setProperty ("javax.net.ssl.trustStore", System.getProperty("user.dir")+"\\cacertificate\\cacertscopy");
    	System.setProperty ("javax.net.ssl.trustStorePassword", "changeit");
    	System.setProperty ("javax.net.ssl.trustStoreType","JKS");
	}
	
	public static void saveSOAPresponseToXMLFile(SOAPMessage soapResponse, String soapReponseOutPutXml ){	
        FileOutputStream fileOutputStream;        
		try {
			fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+"//xmlOutput//" +soapReponseOutPutXml);
			soapResponse.writeTo(fileOutputStream);
			fileOutputStream.close();
		} catch (SOAPException | IOException e) {
			
			e.printStackTrace();
		}
        
	}	
    
	
	public static SOAPConnection getSOAPconnection() throws UnsupportedOperationException, SOAPException{
		setCaCertificatesReady();
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        return soapConnection;
	}
	public static SOAPMessage getSOAPmessage() throws SOAPException
	{
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		return soapMessage;
	}
	
	public static SOAPBody getSOAPEnvelopeReady(SOAPMessage soapMessage, String myNamespace, String myNamespaceURI) throws SOAPException
	{
		SOAPPart soapPart = soapMessage.getSOAPPart();
		// *********** These two lines will be configured from testng.xml at later stage ********** //
         myNamespace = "web";
         myNamespaceURI = "http://realpage.com/webservices";
        // **************************************************************************************** //

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);
        
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        return soapBody;
	}
   
    
   


}
