package com.github.taermi;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	private static final MiniMessage MM = MiniMessage.miniMessage();
	private static final String[] ANSWERS = {
		"Yes.",
		"Neither.",
		"No.",
		"Maybe someday.",
		"Try asking again.",
		"Nothing.",
		"I don't think so."
	};

	public void onEnable() {
		getCommand("ms").setExecutor(this);
	}

	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ms")) {
			if (args.length == 0) {
				p.sendMessage(MM.deserialize("<red>Ask the Magic Shell a question!"));
				return false;
			}

			String question = String.join(" ", args);
			String answer = ANSWERS[(int) (Math.random() * ANSWERS.length)];

			Component prefix = MM.deserialize("<dark_gray>-----[<gold>MagicShell<dark_gray>]-----");
			Bukkit.broadcast(prefix);
			Bukkit.broadcast(p.displayName().color(NamedTextColor.GOLD).append(MM.deserialize("<green> asks: " + question)));
			Bukkit.broadcast(MM.deserialize("<green>The<gold> Magic Shell <green>has spoken: " + answer));
		}
		return false;
	}

}
