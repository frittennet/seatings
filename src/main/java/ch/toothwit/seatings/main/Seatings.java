package ch.toothwit.seatings.main;

import ch.toothwit.seatings.events.PlayerEventListener; 
import org.bukkit.plugin.java.JavaPlugin; 
import org.bukkit.event.HandlerList; 
import org.bukkit.entity.Player; 
import org.bukkit.Location; 
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.Bukkit;

public class Seatings extends JavaPlugin { 
        
    @Override
    public void onEnable(){
    	Bukkit.getPluginManager().registerEvents(new PlayerEventListener(), this); 
        getLogger().info("Seatings has been enabled"); 
    }
    
    @Override
    public void onDisable(){
        getLogger().info("Prophunt has been disabled"); 
    }
} 

