package me.ethereal.HLogin;

import java.util.logging.Logger;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HLogin extends JavaPlugin{
	private final HLoginListener listener = new HLoginListener(this);
	String pluginname = "HLogin";
	Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onDisable() {
		log.info("[" + pluginname + "] " + pluginname + " has been disabled.");
		
	}

	@Override
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	log.info("[" + pluginname + "] " + pluginname + " has been enabled.");
	log.info("[" + pluginname + "] Created by Ethereal");
	pm.registerEvent(Type.PLAYER_JOIN, listener, Priority.Normal, this);
		
	}
}
