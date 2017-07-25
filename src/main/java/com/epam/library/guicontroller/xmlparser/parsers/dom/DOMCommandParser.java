package com.epam.library.guicontroller.xmlparser.parsers.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.SAXException;
import com.epam.library.guicontroller.xmlparser.parsers.ParserException;
import com.epam.library.guicontroller.xmlparser.parsers.bean.XMLCommand;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMCommandParser {
	public static HashMap<String, ArrayList<XMLCommand>> getListOfCommand(String file_path) throws ParserException {
		DOMParser parser = new DOMParser();
		try {
			parser.parse(file_path);
		} catch (SAXException | IOException e) {
			throw new ParserException(e.getMessage(), e);
		}
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		ArrayList<XMLCommand> commandList;
		HashMap<String, ArrayList<XMLCommand>> menu = new HashMap<String, ArrayList<XMLCommand>>();
		String type = null;
		XMLCommand command = null;
		NodeList typeNodes = root.getElementsByTagName("type");
		for (int i = 0; i < typeNodes.getLength(); i++) {
			commandList = new ArrayList<XMLCommand>();
			Element typeElement = (Element) typeNodes.item(i);
			type = typeElement.getAttribute("id");
			NodeList commandNodes = typeElement.getElementsByTagName("command");
			for (int j = 0; j < commandNodes.getLength(); j++) {
				Element commandElement = (Element) commandNodes.item(j);
				command = getCommand(commandElement);
				commandList.add(command);
			}
			menu.put(type, commandList);
		}
		return menu;
	}

	private static XMLCommand getCommand(Element element) {
		XMLCommand command = new XMLCommand();
		command.setName(getSingleChild(element, "name").getTextContent().trim());
		command.setEnumInterpretation(getSingleChild(element, "enumInterpretation").getTextContent().trim());
		command.setDescription(getSingleChild(element, "description").getTextContent().trim());
		command.setCommandPath(getSingleChild(element, "commandPath").getTextContent().trim());
		return command;
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}