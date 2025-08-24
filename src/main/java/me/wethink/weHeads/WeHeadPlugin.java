package me.wethink.weHeads;

import com.tcoded.folialib.FoliaLib;
import me.wethink.weHeads.commands.WeHeadCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeHeadPlugin extends JavaPlugin {

    private FoliaLib foliaLib;

    @Override
    public void onEnable() {
        this.foliaLib = new FoliaLib(this);

        sendConsole("&a╔══════════════════════════════════════╗");
        sendConsole("&a║              &6WeHead Plugin&a           ║");
        sendConsole("&a║                                      ║");
        sendConsole("&a║  &bVersion: &f" + getDescription().getVersion() + "                        &a║");
        sendConsole("&a║  &bAuthor: &fWeThink                   &a║");
        sendConsole("&a║                                      ║");
        sendConsole("&a║  &eCustom heads with Base64 support   &a║");
        sendConsole("&a║  &eFolia/Paper/Spigot compatible      &a║");
        sendConsole("&a║                                      ║");
        sendConsole("&a║  &2✓ &fPlugin enabled successfully!    &a║");
        sendConsole("&a╚══════════════════════════════════════╝");

        WeHeadCommand command = new WeHeadCommand(this);
        getCommand("wehead").setExecutor(command);
        getCommand("wehead").setTabCompleter(command);

        sendConsole("&7[WeHead] Commands registered successfully!");
        sendConsole("&7[WeHead] Folia support: " + (foliaLib.isFolia() ? "&aEnabled" : "&eStandard mode"));
    }

    @Override
    public void onDisable() {
        sendConsole("&c╔══════════════════════════════════════╗");
        sendConsole("&c║              &6WeHead Plugin&c           ║");
        sendConsole("&c║                                      ║");
        sendConsole("&c║  &4✗ &fPlugin disabled successfully!   &c║");
        sendConsole("&c║  &7Thank you for using WeHead!        &c║");
        sendConsole("&c╚══════════════════════════════════════╝");
    }

    public FoliaLib getFoliaLib() {
        return foliaLib;
    }

    private void sendConsole(String msg) {
        msg = applyHexColors(msg);
        msg = org.bukkit.ChatColor.translateAlternateColorCodes('&', msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    private String applyHexColors(String message) {
        Pattern hexPattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = hexPattern.matcher(message);
        while (matcher.find()) {
            String hexCode = matcher.group();
            StringBuilder magic = new StringBuilder("§x");
            for (char c : hexCode.substring(1).toCharArray()) {
                magic.append("§").append(c);
            }
            message = message.replace(hexCode, magic.toString());
            matcher = hexPattern.matcher(message);
        }
        return message;
    }
}
