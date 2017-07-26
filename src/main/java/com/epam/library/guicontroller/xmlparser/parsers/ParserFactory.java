package com.epam.library.guicontroller.xmlparser.parsers;

import com.epam.library.guicontroller.xmlparser.parsers.dom.DOMCommandParser;

/**
 * Singleton Class {@link ParserFactory}.
 * <P>
 * Class ParserFactory gives different parser. There are only one parser.
 * <P>
 * <i>This Class is a member of the
 * {@link com.epam.library.guicontroller.xmlparser.parsers} package.</i>
 */
public class ParserFactory {
	private static final ParserFactory instance = new ParserFactory();

	public static ParserFactory getInstance() {
		return instance;
	}

	/**
	 * Creating {@link DOMCommandParser} object.
	 */
	private DOMCommandParser domCommandParser = new DOMCommandParser();

	/**
	 * @return the domCommandParser as object of {@link DOMCommandParser} type
	 */
	public DOMCommandParser getDOMCommandParser() {
		return domCommandParser;
	}
}
