package com.epam.library.guicontroller.xmlparser.parsers.bean;

import java.io.Serializable;

/**
 * Beans Class {@link XMLCommand}.
 * <P>
 * Class XMLCommand includes 5 fields ({@link #serialVersionUID}, {@link #name},
 * {@link #enumInterpretation}, {@link #description}, {@link #commandPath}),
 * getters and setters for changeable fields, methods {@link #hashCode()} and
 * {@link #equals(Object)}.
 * <P>
 * <i>This Class is a member of the
 * {@link com.epam.library.guicontroller.xmlparser.parsers.bean} package.</i>
 */
public class XMLCommand implements Serializable {
	/**
	 * SerialVersionUID for object of {@link XMLCommand} Class.
	 */
	private static final long serialVersionUID = -7621251609058733391L;
	/**
	 * Contains name of command as name of Class where this command is
	 * implemented.
	 */
	private String name;
	/**
	 * Contains name of command as enumeration name from
	 * {@link com.epam.library.guicontroller.CommandName}.
	 */
	private String enumInterpretation;
	/**
	 * Contains description of command.
	 */
	private String description;
	/**
	 * Contains path where command is implemented.
	 */
	private String commandPath;

	/**
	 * Getter getName.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter setName.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter getEnumInterpretation.
	 * 
	 * @return the enumInterpretation
	 */
	public String getEnumInterpretation() {
		return enumInterpretation;
	}

	/**
	 * Setter enumInterpretation.
	 * 
	 * @param enumInterpretation
	 *            the enumInterpretation to set
	 */
	public void setEnumInterpretation(String enumInterpretation) {
		this.enumInterpretation = enumInterpretation;
	}

	/**
	 * Getter getDescription.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter setDescription.
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter getCommandPath.
	 * 
	 * @return the commandPath
	 */
	public String getCommandPath() {
		return commandPath;
	}

	/**
	 * Setter setCommandPath.
	 * 
	 * @param commandPath
	 *            the commandPath to set
	 */
	public void setCommandPath(String commandPath) {
		this.commandPath = commandPath;
	}

	/**
	 * Method hashCode.
	 * 
	 * @return unique hashCode for {@link XMLCommand} object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandPath == null) ? 0 : commandPath.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enumInterpretation == null) ? 0 : enumInterpretation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            the reference object with which to compare
	 * @return boolean value as the result of comparing {@link XMLCommand}
	 *         objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XMLCommand other = (XMLCommand) obj;
		if (commandPath == null) {
			if (other.commandPath != null)
				return false;
		} else if (!commandPath.equals(other.commandPath))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enumInterpretation == null) {
			if (other.enumInterpretation != null)
				return false;
		} else if (!enumInterpretation.equals(other.enumInterpretation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
