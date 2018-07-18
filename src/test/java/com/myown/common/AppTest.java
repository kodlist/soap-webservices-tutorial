package com.myown.common;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.myown.common.BaseDocumentBuilder;
import com.myown.common.SOAPClient;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseDocumentBuilder
{
	 private String endPointUrlToHit;
	    SOAPConnection soapConnection = null;
		SOAPMessage soapMessage = null;
		SOAPBody soapBody =null;
		private String myNamespace = null;
     private String myNamespaceURI = null;
	
		@Parameters({"protocol", "env","target","endPoint","NameSpace","NameSpaceURI"})
		@BeforeClass	
		public void setup(String protocol, String env,String target, String endPoint, String NameSpace, String NameSpaceURI ){
			endPointUrlToHit = protocol+env+target+endPoint;
			myNamespace = NameSpace;
			myNamespaceURI = NameSpaceURI;
		}
	
     
     
     @org.testng.annotations.Test(enabled=true,groups = {"first"})
		@Parameters({"soapReponseOutPutXml", "soapAction","searchExpression_one"})
		public void testProtocolNameForCard_01(String soapReponseOutPutXml, String soapAction, String searchExpression) throws UnsupportedOperationException, SOAPException, IOException
		{
			soapConnection = SOAPClient.getSOAPconnection();
			soapMessage = SOAPClient.getSOAPmessage();
			soapBody = SOAPClient.getSOAPEnvelopeReady(soapMessage, myNamespace, myNamespaceURI);
			
			// SOAP Body for Request 	        
	        SOAPElement soapBodyElem1 = soapBody.addChildElement("GetSiteSettings", myNamespace);
	        SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("pmcID", myNamespace);	        
	        SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("siteID",myNamespace);
	        SOAPElement soapBodyElem4 = soapBodyElem1.addChildElement("userID",myNamespace);
	        SOAPElement soapBodyElem5 = soapBodyElem1.addChildElement("applicationGuid",myNamespace);
	        soapBodyElem2.addTextNode("3482785");
	        soapBodyElem3.addTextNode("3482786");
	        soapBodyElem4.addTextNode("13");
	        soapBodyElem5.addTextNode("FAC7C095-D652-471C-9218-E55B7CF4A643");
	        
	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        headers.addHeader("SOAPAction", soapAction);	        
	        soapMessage.saveChanges();
  	    // Send SOAP Message to SOAP Server
	        SOAPMessage soapResponse = soapConnection.call(soapMessage, endPointUrlToHit);
	        /* Print the request message, just for debugging purposes */
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out); 
	        System.out.println("\n=========================== END OF SOAP REQUEST ===============================\n");
	        /* Print the response message, just for debugging purposes */
	        System.out.println("\n=========================== START OF SOAP RESPONSE ===============================\n");
	        SOAPClient.saveSOAPresponseToXMLFile(soapResponse, soapReponseOutPutXml);
	        System.out.println("Response SOAP Message:");
         soapResponse.writeTo(System.out);
         soapConnection.close();
         
         // parse SOAP output and fetch values to verify expected output in our current
	        baseDocumentBuilder = BaseDocumentBuilder.xmlBuilder(soapReponseOutPutXml);	        
	        
	        AssertJUnit.assertEquals("ACH", baseDocumentBuilder.getNodeNameAndValue(searchExpression));
	        Reporter.log("Expected Protocol Name For Card : ACH "+ "   |:::|   Actual Protocol Name For Card : "+ baseDocumentBuilder.getNodeNameAndValue(searchExpression));

			
		}
     
     @org.testng.annotations.Test(enabled=true, dependsOnGroups  ={"first"} )
		@Parameters({"soapReponseOutPutXml", "soapAction","searchExpression_two"})
     public void testProtocolDescriptionForCard_02(String soapReponseOutPutXml, String soapAction, String searchExpression)
     {
     	// parse SOAP output and fetch values to verify expected output in our current
	        baseDocumentBuilder = BaseDocumentBuilder.xmlBuilder(soapReponseOutPutXml);	        
	        System.out.println("searchExpression : "+baseDocumentBuilder.getNodeNameAndValue(searchExpression));
	        
	        AssertJUnit.assertEquals("CARD", baseDocumentBuilder.getNodeNameAndValue(searchExpression));
	        Reporter.log("Expected Protocol Name For Description : CARD "+ "   |:::|   Actual Protocol Name For Description : "+ baseDocumentBuilder.getNodeNameAndValue(searchExpression));
     }
			
}
