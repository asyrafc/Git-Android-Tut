package com.example.androidtutorial;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreator {
	
	public static String CreateSpreadSheetToXML() throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Contacts");
		doc.appendChild(rootElement);

		for (int i = 0; i < XMLParserClass.NameArray.size(); i++) {
			// PersonElement elements
			Element PersonElement = doc.createElement("Person");
			rootElement.appendChild(PersonElement);

			Element s_no = doc.createElement(XMLParserClass.Tag_Array.get(0));
			s_no.appendChild(doc.createTextNode(""+i));
			PersonElement.appendChild(s_no);

			Element Name = doc.createElement(XMLParserClass.Tag_Array.get(1));
			Name.appendChild(doc.createTextNode(XMLParserClass.NameArray.get(i)));
			PersonElement.appendChild(Name);

			Element Institute = doc.createElement(XMLParserClass.Tag_Array
					.get(2));
			Institute.appendChild(doc.createTextNode(XMLParserClass.InstituteArray.get(i)));
			PersonElement.appendChild(Institute);

			Element City = doc.createElement(XMLParserClass.Tag_Array.get(3));
			City.appendChild(doc.createTextNode(XMLParserClass.CityArray.get(i)));
			PersonElement.appendChild(City);

			Element O1 = doc.createElement(XMLParserClass.Tag_Array.get(4));
			O1.appendChild(doc.createTextNode(XMLParserClass.Off1_Array.get(i)));
			PersonElement.appendChild(O1);

			Element O2 = doc.createElement(XMLParserClass.Tag_Array.get(5));
			O2.appendChild(doc.createTextNode(XMLParserClass.Off2_Array.get(i)));
			PersonElement.appendChild(O2);

			Element O3 = doc.createElement(XMLParserClass.Tag_Array.get(6));
			O3.appendChild(doc.createTextNode(XMLParserClass.Off3_Array.get(i)));
			PersonElement.appendChild(O3);

			Element R1 = doc.createElement(XMLParserClass.Tag_Array.get(7));
			R1.appendChild(doc.createTextNode(XMLParserClass.Res1_Array.get(i)));
			PersonElement.appendChild(R1);

			Element R2 = doc.createElement(XMLParserClass.Tag_Array.get(8));
			R2.appendChild(doc.createTextNode(XMLParserClass.Res2_Array.get(i)));
			PersonElement.appendChild(R2);

			Element M1 = doc.createElement(XMLParserClass.Tag_Array.get(9));
			M1.appendChild(doc.createTextNode(XMLParserClass.Mob1_Array.get(i)));
			PersonElement.appendChild(M1);

			Element M2 = doc.createElement(XMLParserClass.Tag_Array.get(10));
			M2.appendChild(doc.createTextNode(XMLParserClass.Mob2_Array.get(i)));
			PersonElement.appendChild(M2);

			Element E1 = doc.createElement(XMLParserClass.Tag_Array.get(11));
			E1.appendChild(doc.createTextNode(XMLParserClass.Email1_Array.get(i)));
			PersonElement.appendChild(E1);

			Element E2 = doc.createElement(XMLParserClass.Tag_Array.get(12));
			E2.appendChild(doc.createTextNode(XMLParserClass.Email2_Array.get(i)));
			PersonElement.appendChild(E2);
		}
		
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(
				"{http://xml.apache.org/xslt}indent-amount", "2");

		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString();

		return output;
	}
	
}