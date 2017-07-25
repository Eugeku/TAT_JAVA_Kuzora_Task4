/**
 * 
 */
package com.epam.library.guicontroller.xmlparser.parsers.bean;

import java.io.Serializable;

/**
 * @author Eugene13
 *
 */
public class XMLCommand implements Serializable {

	private static final long serialVersionUID = -7621251609058733391L;

	private String name;

	private String enumInterpretation;

	private String description;

	private String commandPath;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enumInterpretation
	 */
	public String getEnumInterpretation() {
		return enumInterpretation;
	}

	/**
	 * @param enumInterpretation
	 *            the enumInterpretation to set
	 */
	public void setEnumInterpretation(String enumInterpretation) {
		this.enumInterpretation = enumInterpretation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the commandPath
	 */
	public String getCommandPath() {
		return commandPath;
	}

	/**
	 * @param commandPath
	 *            the commandPath to set
	 */
	public void setCommandPath(String commandPath) {
		this.commandPath = commandPath;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
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
