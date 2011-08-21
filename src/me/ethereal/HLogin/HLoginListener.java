package me.ethereal.HLogin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.iConomy.iConomy;

public class HLoginListener extends PlayerListener {

	HLogin plugin;
	SpoutPlayer player;
	Server server;
	
	public HLoginListener(HLogin instance) {
		this.plugin = instance;
		this.server = Bukkit.getServer();
	}
	
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		final SpoutPlayer player = (SpoutPlayer) event.getPlayer();
		final String Money = iConomy.format(player.getDisplayName());
		plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()
		{
			public void run()
			{
				player.sendMessage(ChatColor.YELLOW + "You Have " + Money);
			}
		}, 40L);
		plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()
		{
			public void run()
			{
				if(player.isSpoutCraftEnabled())
				{
					player.sendNotification("Spout", "Spoutcraft is hooked!", Material.BOOK);
					server.broadcastMessage(player.getDisplayName() + " Is using " + ChatColor.BLUE +"Spoutcraft!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You Don't Have Spoutcraft enabled! " + ChatColor.YELLOW + "Get it from " + ChatColor.GRAY + "\"http://minedev.net/BukkitContrib/Spoutcraft.jar\"");
					player.sendMessage(ChatColor.YELLOW + "Playing without spout will disadvantage you!");
				}
			}
		}, 200L);
		
	}

}
