package com.epam.library.guicontroller.xmlparser.parsers.exception;

/**
 * Class {@link ParserException}.
 * <P>
 * Class ParserException - user exception class for
 * {@link com.epam.library.service} layer, extends Exception Class and overloads
 * 3 constructors with different parameters.
 * <P>
 * <i>This Class is a member of the
 * {@link com.epam.library.guicontroller.xmlparser.parsers.exception}
 * package.</i>
 */
public class ParserException extends Exception {

	/**
	 * SerialVersionUID for object of {@link ParserException} Class.
	 */
	private static final long serialVersionUID = 1499539754326455467L;

	/**
	 * Constructor without any parameters.
	 */
	public ParserException() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            as info for creating user exception
	 */
	public ParserException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 */
	public ParserException(Exception e) {
		super(e);
	}

	/**
	 * Constructor.
	 * 
	 * @param e
	 *            as Exception object for saving first cause of exception
	 * @param message
	 *            as info for creating user exception
	 */
	public ParserException(String message, Exception e) {
		super(message, e);
	}
}