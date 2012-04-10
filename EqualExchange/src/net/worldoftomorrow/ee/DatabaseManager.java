package net.worldoftomorrow.ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;

final class DatabaseManager {

	private static String host = "jdbc:mysql://" + ConfigHelper.dbHost() + ":"
			+ ConfigHelper.dbPort() + "/" + ConfigHelper.dbName();
	private static String username = ConfigHelper.dbUser();
	private static String password = ConfigHelper.dbPass();
	private static PreparedStatement query = null;

	protected static boolean CanDatabaseConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(host, username, password);
		if (conn.isValid(0)) {
			conn.close();
			return true;
		} else {
			conn.close();
			return false;
		}
	}

	protected static void CreateTables() throws SQLException {
		String q = "CREATE TABLE IF NOT EXISTS ee_users ("
				+ "username varchar(25) NOT NULL,"
				+ "emc_balance int(15) NOT NULL," + "PRIMARY KEY (username)"
				+ ")";

		Connection conn = DriverManager.getConnection(host, username, password);
		query = conn.prepareStatement(q);
			query.execute();
			conn.close();
	}

	protected static void CreateUser(Player player) throws SQLException {
		String p = player.getName();
		String d = ConfigHelper.defaultAmount();
		String q = "INSERT users" +
				"(username, emc_balance) VALUES(" + p + ", " + d + ");";

		Connection conn = DriverManager.getConnection(host, username, password);
		query = conn.prepareStatement(q);
			query.execute();
			conn.close();
	}
	
	protected static long getBalance(Player player) throws SQLException{
			String p = player.getName();
			String q = "SELECT emc_balance FROM ee_users WHERE username = " + p + ";";
			Connection conn = DriverManager.getConnection(host, username, password);
			query = conn.prepareStatement(q);
			ResultSet rs = query.executeQuery();
			conn.close();
			return rs.getInt("emc_balance");
	}
	
	protected static void setBalance(Player player, long b) throws SQLException{
		String p = player.getName();
		String q = "UPDATE ee_users SET emc_balance = " + b + " WHERE username = " + p + ";";
		if(userExists(player)){
			Connection conn = DriverManager.getConnection(host, username, password);
			query = conn.prepareStatement(q);
			query.executeUpdate();
			conn.close();
		} else {
			CreateUser(player);
			setBalance(player, b);
			}
	}
	
	protected static boolean userExists(Player player) throws SQLException {
		String p = player.getName();
		String q = "SELECT username FROM ee_users WHERE username = " + p + ";";
		Connection conn = DriverManager.getConnection(host, username, password);
		query = conn.prepareStatement(q);
		ResultSet rs = query.executeQuery();
		conn.close();
		if(rs.first()){ return true; }
		else { return false; }
	}
	
	protected static void subtractFromBalance(Player player, long b) throws SQLException{
		if(userExists(player)){
			long current = getBalance(player);
			setBalance(player, current - b);
		} else { throw new CommandException("[EE] Account does not exist."); }
	}
}
