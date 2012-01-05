package me.sirtyler.VaultSlots;

import java.util.Random;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEx implements CommandExecutor{
	public static VaultSlots plugin;
	private static Deck deck;
	private static Permission perm;
	Random rand = new Random();
	public CommandEx(VaultSlots instance) {
		plugin = instance;
		deck = instance.deck;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		perm = plugin.permission;
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 1){
                String cmd = args[0].toString();
                if(cmd.equalsIgnoreCase("help")) {
                		player.sendMessage(ChatColor.BLUE + "[VaultSlot Help Guide] #Page 1#");
                		player.sendMessage(ChatColor.GOLD + "Originaly Created for The Vault RP Server!");
                		player.sendMessage(ChatColor.GREEN + "/slots or /vs");
                		player.sendMessage(ChatColor.GREEN + "/slots help page# - Displays this and other help pages.");
                		player.sendMessage(ChatColor.GREEN + "/slots test - Check if [Slots] is working.");
                		player.sendMessage(ChatColor.GREEN + "/slots roll - Roll random number between 1-4.");
                		player.sendMessage(ChatColor.GREEN + "/slots card - Pull random card from deck.");
                		return true;
                } else if(cmd.equalsIgnoreCase("test")){
                	if(perm.playerHas(player, "vaultslots.test")) {
                		sender.sendMessage(ChatColor.GOLD + "[VaultSlots] is Working!");
                		return true;
                	} else {
            			sender.sendMessage(ChatColor.RED + "[VaultSlots]: You Do Not Have Permission for That");
            			return true;
            		}
                } else if(cmd.equalsIgnoreCase("roll")){
                	 if(perm.playerHas(player, "vaultslots.roll")) {
                		int pickedNumber = rand.nextInt(4) + 1;
                		sender.sendMessage(ChatColor.GREEN + "" + pickedNumber);
                		return true;
                	} else {
            			sender.sendMessage(ChatColor.RED + "[VaultSlots]: You Do Not Have Permission for That");
            			return true;
                	}
                } else if(cmd.equalsIgnoreCase("card")) {
                	if(perm.playerHas(player, "vaultslots.card")) {
                		player.sendMessage(deck.drawCard());
                		return true;
                	}
                }
			} else if(args.length == 2) {
				String cmd = args[0].toString();
				String arg = args[1].toString();
				if(cmd.equalsIgnoreCase("help")) {
					if(arg.equalsIgnoreCase("1")) {
						player.sendMessage(ChatColor.BLUE + "[VaultSlot Help Guide] #Page 1#");
						player.sendMessage(ChatColor.GOLD + "Originaly Created for The Vault RP Server!");
						player.sendMessage(ChatColor.GREEN + "/slots or /vs");
						player.sendMessage(ChatColor.GREEN + "/slots help page# - Displays this and other help pages.");
						player.sendMessage(ChatColor.GREEN + "/slots test - Check if [Slots] is working.");
						player.sendMessage(ChatColor.GREEN + "/slots roll - Roll random number between 1-4.");
						player.sendMessage(ChatColor.GREEN + "/slots card - Pull random card from deck.");
						return true;
					} else if(arg.equalsIgnoreCase("2")) {
						player.sendMessage(ChatColor.BLUE + "[VaultSlot Help Guide] #Page 2#");
						player.sendMessage(ChatColor.GOLD + "Originaly Created for The Vault RP Server!");
						player.sendMessage(ChatColor.GREEN + "Slot Machine Format:");
						player.sendMessage(ChatColor.GREEN + "- Line1: [Slots]");
						player.sendMessage(ChatColor.GREEN + "- Line2: Type");
						player.sendMessage(ChatColor.GREEN + "Blackjack Seat Format:");
						player.sendMessage(ChatColor.GREEN + "- Line1: [Blackjack]");
						player.sendMessage(ChatColor.GREEN + "- Line2: Seat Data");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "Sorry, no Help page Avaiable.");
						return true;
					}
				}
				return false;
			} else {
				sender.sendMessage(ChatColor.RED + "[VaultSlots] expected a command");
				sender.sendMessage(ChatColor.RED + "[VaultSlots] Use /slots help to see Commands and Sign Format.");
				return true;
			}
		}
		return false;
	}
}