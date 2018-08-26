package com.github.taermi;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements CommandExecutor {
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String prefix = ChatColor.DARK_GRAY + "-----[" + ChatColor.GOLD + "MagicShell" + ChatColor.DARK_GRAY + "]-----";
		if(cmd.getName().equalsIgnoreCase("ms")) {
			int r = (int) Math.ceil(Math.random() * 3);
					
			String message = "";
            for(int i = 0; i != args.length; i++)
            message += args[i] + " ";
          
            Bukkit.broadcastMessage(prefix);
            Bukkit.broadcastMessage(ChatColor.GOLD + p.getDisplayName() + ChatColor.GREEN + " asks: " + message);
            if(r == 1) {
            	Bukkit.broadcastMessage(ChatColor.GREEN + "And the" + ChatColor.GOLD + " Magic Shell " + ChatColor.GREEN + "says: Yes!");
            }
            if(r == 2) {
            	Bukkit.broadcastMessage(ChatColor.GREEN + "And the" + ChatColor.GOLD + " Magic Shell " + ChatColor.GREEN + "says: Maybe.");
            }
            if(r == 3) {
            	Bukkit.broadcastMessage(ChatColor.GREEN + "And the" + ChatColor.GOLD + " Magic Shell " + ChatColor.GREEN + "says: No!");
            }
            
			
		}
		return false;
	}

}
