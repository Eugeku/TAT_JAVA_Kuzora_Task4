package com.epam.library.guicontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.guicontroller.xmlparser.parsers.exception.ParserException;
import com.epam.library.guicontroller.xmlparser.parsers.ParserFactory;
import com.epam.library.guicontroller.xmlparser.parsers.bean.XMLCommand;

/**
 * Class {@link CommandProvider}.
 * <P>
 * Class CommandProvider includes 1 method {@link #getCommand(int, String)}.
 * <P>
 * <i>This Class is a member of the {@link com.epam.library.guicontroller}
 * package.</i>
 */
public class CommandProvider {
	private static final String ILLEGAL_COMMAND = "Illegal command for current user.";
	private static final String GUEST_COMMAND_GROUP = "guestCommands";
	private static final String USER_COMMAND_GROUP = "userCommands";
	private static final String ADMIN_COMMAND_GROUP = "adminCommands";
	private static final String SUPER_ADMIN_COMMAND_GROUP = "superAdminCommands";
	private static final String PATH_TO_XML_FILE = "/commandList.xml";
	/**
	 * Contains HashMap of guest commands.
	 */
	private Map<CommandName, Command> guestCommands = new HashMap<>();
	/**
	 * Contains HashMap of user commands.
	 */
	private Map<CommandName, Command> userCommands = new HashMap<>();
	/**
	 * Contains HashMap of admin commands.
	 */
	private Map<CommandName, Command> adminCommands = new HashMap<>();
	/**
	 * Contains HashMap of super admin commands.
	 */
	private Map<CommandName, Command> superAdminCommands = new HashMap<>();
	private static final CommandProvider instance = new CommandProvider();

	private CommandProvider() {
		try {
			HashMap<String, ArrayList<XMLCommand>> commandList = ParserFactory.getInstance().getDOMCommandParser().getListOfCommand(PATH_TO_XML_FILE);
			for (Map.Entry<String, ArrayList<XMLCommand>> entry : commandList.entrySet()) {
				String commandGroup = entry.getKey();
				ArrayList<XMLCommand> commands = entry.getValue();
				switch (commandGroup) {
				case SUPER_ADMIN_COMMAND_GROUP:
					superAdminCommands = loadCommands(commands);
					break;
				case ADMIN_COMMAND_GROUP:
					adminCommands = loadCommands(commands);
					break;
				case USER_COMMAND_GROUP:
					userCommands = loadCommands(commands);
					break;
				case GUEST_COMMAND_GROUP:
					guestCommands = loadCommands(commands);
					break;
				}
			}
			adminCommands.putAll(userCommands);
			superAdminCommands.putAll(adminCommands);
		} catch (ParserException e) {
			/* Not for user info about parser exception */
		}
	}

	/**
	 * Private method loadCommands returns object of Map<CommandName, Command>
	 * type. The logic based on reflection is inside.
	 * 
	 * @param userLevel
	 *            id of user access level
	 * 
	 * @return object of Map<CommandName, Command> type
	 */
	private Map<CommandName, Command> loadCommands(ArrayList<XMLCommand> commands) {
		Map<CommandName, Command> defaultMap = new HashMap<>();
		CommandName name;
		Class reflectObject;
		for (XMLCommand command : commands) {
			try {
				reflectObject = Class.forName(command.getCommandPath() + command.getName());
				Command builder = (Command) reflectObject.newInstance();
				if ((name = CommandName.valueOf(command.getEnumInterpretation())) != null) {
					defaultMap.put(name, builder);
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				/* Not for user info about reflection exceptions */
			}
		}
		return defaultMap;
	}

	public static CommandProvider getInstance() {
		return instance;
	}

	/**
	 * Method getCommand returns object of {@link Command} type.
	 * 
	 * @param userLevel
	 *            id of user access level
	 * @param stringCommand
	 *            commnd name in String presentation
	 * @return object of {@link Command} type
	 * @throws CommandException
	 *             Exception type for controller layer
	 */
	public Command getCommand(int userLevel, String stringCommand) throws CommandException {
		String com = stringCommand.replace("-", "_").toUpperCase();
		Command command;
		CommandName name = null;
		try {
			name = CommandName.valueOf(com);
			switch (userLevel) {
			case 1:
				command = guestCommands.get(name);
				break;
			case 2:
				command = userCommands.get(name);
				break;
			case 3:
				command = adminCommands.get(name);
				break;
			case 4:
				command = superAdminCommands.get(name);
				break;
			default:
				command = guestCommands.get(name);
			}
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new CommandException(e.getMessage(), e);
		}
		if (command == null)
			throw new CommandException(ILLEGAL_COMMAND);
		return command;
	}
}
