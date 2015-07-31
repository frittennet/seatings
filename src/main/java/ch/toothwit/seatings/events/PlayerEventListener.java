package ch.toothwit.seatings.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import ch.toothwit.seatings.main.Seat;
import ch.toothwit.seatings.main.Seatings;

import org.bukkit.block.Block;



public class PlayerEventListener implements Listener 
{    
	@EventHandler 
	public void onPlayerInteract(PlayerInteractEvent event){ 
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			Block b = event.getClickedBlock();
			if(b.getType() == Material.COBBLESTONE_STAIRS){
				new Seat(event.getClickedBlock(), event.getPlayer()); 
				event.setCancelled(true);
			}
		}
		
	}			
}