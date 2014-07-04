package io.github.mosadie.summonstack;

import java.util.logging.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.*;

public class SummonStack extends JavaPlugin {
	public static final Logger log = Logger.getLogger("Minecraft");
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		
		if (label.equalsIgnoreCase("summonstack")) {
			if (sender instanceof Player) {
				//Get Player
				Player me = (Player) sender;
				//Get Coords of Player
				Location spot = me.getLocation();
				//Get current world
				World world = me.getWorld();
				
				//Spawn a cow on a chicken (Testing the riding feature)
				Location spawnSpot = new Location(world,
						spot.getX() + (Math.random() * 5),
						spot.getY(),
						spot.getZ() + (Math.random() * 5));
				Chicken chicken = world.spawn(spawnSpot, Chicken.class);
				Cow cow = world.spawn(spawnSpot, Cow.class);
				chicken.setPassenger(cow);
				
				return true;
			}
		}
		return false;
	}
}