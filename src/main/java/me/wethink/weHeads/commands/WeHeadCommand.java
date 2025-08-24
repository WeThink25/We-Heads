package me.wethink.weHeads.commands;

import me.wethink.weHeads.WeHeadPlugin;
import me.wethink.weHeads.utils.HeadUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeHeadCommand implements CommandExecutor, TabCompleter {

    private final WeHeadPlugin plugin;

    public WeHeadCommand(WeHeadPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("wehead.give")) {
            player.sendMessage("§cYou don't have permission to use this command.");
            return true;
        }

        if (args.length != 2 || !args[0].equalsIgnoreCase("give")) {
            player.sendMessage("Usage: /wehead give <value>");
            return true;
        }

        String base64Texture = args[1];
        HeadUtils.giveCustomHead(player, base64Texture, plugin);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> subCommands = new ArrayList<>();
            if ("give".startsWith(args[0].toLowerCase())) {
                subCommands.add("give");
            }
            return subCommands;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
            List<String> suggestions = new ArrayList<>();
            suggestions.add("<base64_value>");
            suggestions.add("exampleTexture1");
            suggestions.add("exampleTexture2");
            return suggestions;
        }

        return Collections.emptyList();
    }
}
