package com.myown.common;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by mkoduri on 7/3/2018.
 *
 *
 * 
 */
public class BaseDocumentBuilder {

    protected static DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    protected static DocumentBuilder builder = null;
    protected static Document xmlDocument = null;
    protected static XPath xpath =null;
    protected static XPathExpression expressionObj = null;
    protected static NodeList nodeslist = null;
    protected static BaseDocumentBuilder baseDocumentBuilder;

    public static BaseDocumentBuilder getBaseDocumentBuilder() {
        return baseDocumentBuilder;
    }

    public static DocumentBuilder getDocumentBuilder()    {
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder ;
    }

    public static Document getXmlDocument(String xmlResponseDoc) {
        try {
            xmlDocument = builder.parse(System.getProperty("user.dir")+"//xmlOutput//" +xmlResponseDoc ) ;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlDocument;
    }

    public static XPath getXPathFactory() {
        xpath = XPathFactory.newInstance().newXPath();
        return xpath;
    }


    public int getNumberOfNodes(String expression)    {
        try {
            expressionObj = xpath.compile(expression);
            nodeslist = (NodeList) expressionObj.evaluate(xmlDocument, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodeslist.getLength();
    }

    public String getNodeNameAndValue(String expression) {
        String nodeNameAndValue = null;
        try {
            nodeNameAndValue = xpath.compile(expression).evaluate(xmlDocument);

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodeNameAndValue;
    }

    /*
     * this method builds DocumentBuilder, Document, XPath.
     * a new Object "BaseDocumentBuilder" gets created.
     *
     */
    public static BaseDocumentBuilder xmlBuilder(String xmlResponseDoc) {
        builder = getDocumentBuilder();
        xmlDocument = getXmlDocument(xmlResponseDoc);
        xpath = getXPathFactory();
        return new BaseDocumentBuilder();
    }

    public String getAllChildNodesAndValue(String expression) {
        String nodeNameAndValue = null;
        try {
            NodeList elements = (NodeList)xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

           /* for (int i = 0; i < elements.getLength(); i++)
            {
                System.out.println(elements.item(i).getChildNodes().item(1).getNodeName() + " : "+
                        elements.item(i).getChildNodes().item(1).getTextContent());
            }*/

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodeNameAndValue;
    }



}
