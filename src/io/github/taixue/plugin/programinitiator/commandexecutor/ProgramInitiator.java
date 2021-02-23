package io.github.taixue.plugin.programinitiator.commandexecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ProgramInitiator implements CommandExecutor {

    File dataFolder;
    Logger logger;

    public ProgramInitiator(File dataFolder, Logger logger) {
        this.dataFolder = dataFolder;
        this.logger = logger;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            return false;
        }
        if (strings[0].equalsIgnoreCase("command") && commandSender.hasPermission("pinit.command")) {
            if (strings.length > 1) {
                String[] arguments = Arrays.copyOfRange(strings, 1, strings.length);
                logger.info(commandSender.getName() + " input command: " + Arrays.toString(strings));
                try {
                    Runtime.getRuntime().exec(arguments);
                } catch (Throwable throwable) {
                    commandSender.sendMessage("unknown mistake: " + throwable.toString());
                }
                return true;
            } else {
                return false;
            }
        }
        if (strings[0].equalsIgnoreCase("execute") && commandSender.hasPermission("pinit.execute")) {
            if (strings.length >= 2) {
                String[] arguments = Arrays.copyOfRange(strings, 1, strings.length);
                logger.info(commandSender.getName() + " input command: " + Arrays.toString(strings));
                try {
                    arguments[0] = new File(dataFolder, arguments[0]).getAbsolutePath();
                    Runtime.getRuntime().exec(arguments);
                } catch (Throwable throwable) {
                    commandSender.sendMessage("unknown mistake: " + throwable.toString());
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
