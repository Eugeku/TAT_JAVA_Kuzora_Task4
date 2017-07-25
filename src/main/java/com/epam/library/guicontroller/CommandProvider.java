package com.epam.library.guicontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;
import com.epam.library.guicontroller.xmlparser.parsers.ParserException;
import com.epam.library.guicontroller.xmlparser.parsers.bean.XMLCommand;
import com.epam.library.guicontroller.xmlparser.parsers.dom.DOMCommandParser;

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
	private Map<CommandName, Command> guestCommands = new HashMap<>();
	private Map<CommandName, Command> userCommands = new HashMap<>();
	private Map<CommandName, Command> adminCommands = new HashMap<>();
	private Map<CommandName, Command> superAdminCommands = new HashMap<>();
	private static final CommandProvider instance = new CommandProvider();

	private CommandProvider() {
		try {
			HashMap<String, ArrayList<XMLCommand>> commandList = DOMCommandParser.getListOfCommand("/commandList.xml");
			for (Map.Entry<String, ArrayList<XMLCommand>> entry : commandList.entrySet()) {
				System.out.println(entry.getKey() + "  " + entry.getValue());
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
		}
		//
		// Guest or banned user
		// guestCommands.put(CommandName.LOGIN, new Login());
		// guestCommands.put(CommandName.REGISTRATION, new Registration());
		// guestCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		//
		// User
		// userCommands.put(CommandName.LOGOUT, new Logout());
		// userCommands.put(CommandName.UPDATE_USER_INFO, new UpdateInfo());
		// userCommands.put(CommandName.VIEW_ALL_BOOKS, new ViewAllBooks());
		// userCommands.put(CommandName.VIEW_ALL_ORDERS, new ViewAllOrders());
		// userCommands.put(CommandName.ORDER_BOOK, new OrderBook());
		//
		// Admin
		// adminCommands.putAll(userCommands);
		// adminCommands.put(CommandName.VIEW_ALL_USERS, new ViewAllUsers());
		// adminCommands.put(CommandName.CHANGE_BOOK_STATUS, new
		// ChangeBookStatus());
		// adminCommands.put(CommandName.CONFIRM_ORDER, new SendOrder());
		// adminCommands.put(CommandName.RETURN_ORDER, new ReturnOrder());
		// adminCommands.put(CommandName.BAN_USER, new BanUser());
		// adminCommands.put(CommandName.UNBAN_USER, new UnBanUser());
		// adminCommands.put(CommandName.ADD_BOOK, new AddBook());
		//
		// SuperAdmin
		// superAdminCommands.putAll(adminCommands);
		// superAdminCommands.put(CommandName.GIVE_ADMIN, new
		// GiveAdminForUser());
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
