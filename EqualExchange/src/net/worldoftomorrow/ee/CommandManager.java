package net.worldoftomorrow.ee;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class CommandManager {
	private EqualExchange plugin;

	public CommandManager(EqualExchange plugin) {
		this.plugin = plugin;
	}

	public void CommandParser(Player player, String command, String[] args) throws SQLException{
		String tempData[];
		short data = 0;
		int id = 0;

		if(args.length > 0){
			/*----------CHECK----------*/
			if(args[1].equalsIgnoreCase("check")){
				long balance;
				//Make sure the sender is not the console by checking player is not null
				if(args[2].isEmpty() && player.hasPermission("ee.check")){
					//Need to do this check here to avoid problems with the else statement
					if(player != null && DatabaseManager.userExists(player)){
						balance = DatabaseManager.getBalance(player);
						player.sendMessage(ChatColor.BLUE + "[EE] Your current EMC balance is: " + balance);
					} else {
						DatabaseManager.CreateUser(player);
						balance = DatabaseManager.getBalance(player);
						player.sendMessage(ChatColor.BLUE + "[EE] Your current EMC balance is: " + balance);
					}
				}
				//If args[2] is not empty than check if that player is online
				//If they are, get the balance
				else if(plugin.getServer().getPlayer(args[2]).isOnline() && player.hasPermission("ee.check.other")){
					player = plugin.getServer().getPlayer(args[2]);
					if(DatabaseManager.userExists(player)){
						balance = DatabaseManager.getBalance(player);
						player.sendMessage(ChatColor.BLUE + "[EE] " + args[2] + "'s current EMC balance is: " + balance);
					} else { player.sendMessage(ChatColor.BLUE + "[EE] " + args[2] + " does not have an account."); }
				} else { player.sendMessage(ChatColor.BLUE + "[EE] User must be online to check balance."); }
			}
			
			/*----------GET----------*/
			else if(args[1].equalsIgnoreCase("get")){
				PlayerInventory inv = player.getInventory();
				
				if(args.length == 2){
					if(args[2].contains(":")){ //If contains data value
						tempData = args[2].split(":", 2); //Split them up
						id = SpawnableItem.lookup(tempData[1]).getID(); //Get and set item ID
						if(MathHelper.canGet(id, 1, player)){ //Check if player can afford
							if(SpawnableItem.usesData(id)){ //Check if the item can use data - no need to check if id is 0, as 0 does not support data!
								data = MathHelper.getData(args[2]); //Get the data 
								DatabaseManager.subtractFromBalance(player, MathHelper.getItemValue(id)); //Subtract from account balance.
								InventoryManager.giveItems(inv, id, data, 1); //Give the items!
							} else { throw new CommandException ("[EE] This item does not support data."); } //Throw CE if the item does not support data values.
						} else { player.sendMessage(ChatColor.BLUE + "[EE] You can not afford this item!"); } //if they can't afford it, tell them :D
					} else { //If does not have data value
						id = SpawnableItem.lookup(args[2]).getID();
						if(MathHelper.canGet(id, 1, player)){
							InventoryManager.giveItems(inv, id, data, 1);
						}
					}
				}
				//If the length is 3, then give them the amount they want
				else if(args.length == 3){
					
					int amount = 0;
					
					try{ amount = Integer.parseInt(args[3]); } //Try to parse the amount.
					catch (NumberFormatException e) { //If the amount can not be parsed, stop and throw a Command Exception.
						throw new CommandException ("[EE] Integer expected, string received.");
					}
					if(amount != 0){
						if(args[2].contains(":")){ //If contains data value
							tempData = args[2].split(":", 2); //Split them up
							id = SpawnableItem.lookup(tempData[1]).getID(); //Get and set item ID
							if(MathHelper.canGet(id, 1, player)){ //Check if player can afford
								if(SpawnableItem.usesData(id)){ //Check if the item can use data - no need to check if id is 0, as 0 does not support data!
									data = MathHelper.getData(args[2]); //Get the data 
									DatabaseManager.subtractFromBalance(player, MathHelper.getItemValue(id) * amount); //Subtract from account balance.
									InventoryManager.giveItems(inv, id, data, amount); //Give the items!
								} else { throw new CommandException ("[EE] This item does not support data."); } //Throw CE if the item does not support data values.
							} else { player.sendMessage(ChatColor.BLUE + "[EE] You can not afford this item!"); } //if they can't afford it, tell them :D
						} else { //If does not have data value
							id = SpawnableItem.lookup(args[2]).getID();
							if(MathHelper.canGet(id, 1, player)){
								InventoryManager.giveItems(inv, id, data, amount);
							}
						}
					} else { player.sendMessage(ChatColor.BLUE + "[EE] Amount must be greater than 0"); }
				}
				else if(args.length > 3){ player.sendMessage(ChatColor.BLUE + "[EE] Syntax Error: Too many variables."); }
					} else { player.sendMessage(ChatColor.BLUE + "[EE] You must specify the item you want."); }
			}
			
			/*----------BURN----------*/
			else if(args[1].equalsIgnoreCase("burn")){
				
			}
			
			/*----------PRICE----------*/
			else if(args[1].equalsIgnoreCase("price")){
				
			}
			
			/*----------VERSION----------*/
			else if(args[1].equalsIgnoreCase("version")){
				
			}
			
			/*----------SET----------*/
			else if(args[1].equalsIgnoreCase("set")){
				
				int i = 0;
				boolean execute = true;
				if(args[3].isEmpty()){
					try{ i = Integer.parseInt(args[2]); }
					catch(NumberFormatException e){
						execute = false; //This makes it so the account is not wiped even after the exception is thrown.
						throw new CommandException("[EE] The amount to set must be numerical and whole.");
					}
					if(execute){ DatabaseManager.setBalance(player, i); }
					//even if there is anything in args[4]+, they are just ignored.
				} else {
					try{ i = Integer.parseInt(args[3]); } //Parse the 3rd argument this time
					catch(NumberFormatException e){
						execute = false; //This makes it so the account is not wiped accidentally after the exception is thrown.
						throw new CommandException("[EE] The amount to set must be numerical and whole.");
					}
					Player target = Bukkit.getPlayer(args[2]);
					if(execute){
						if(DatabaseManager.userExists(target)){ //Check if the target exists first.
							DatabaseManager.setBalance(target, i);
							String t = target.getName();
							player.sendMessage(ChatColor.BLUE + "[EE] " + t + "'s EMC balance has been set to " + i);
						} else { player.sendMessage(ChatColor.BLUE + "[EE] That users account does not exist."); }
					}
				}
			}
			
			/*----------RESET----------*/
			else if(args[1].equalsIgnoreCase("reset")){
				throw new CommandException("[EE] This has not yet been implemented.");
			}
			
			/*----------UPDATECHECK----------*/
			else if(args[1].equalsIgnoreCase("updatecheck")){
				throw new CommandException("[EE] This has not yet been implemented.");
			}
		
			/*----------HELP----------*/
			else if(args[1].equalsIgnoreCase("help")){
				throw new CommandException("[EE] This has not yet been implemented.");
			}
		}
}
