package ch.toothwit.seatings.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.Material;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Stairs;
import org.bukkit.util.Vector;
import org.bukkit.block.Block;



public class PlayerEventListener implements Listener 
{    
	@EventHandler 
	public void onPlayerInteract(PlayerInteractEvent event){ 
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			Block b = event.getClickedBlock();
			if(b.getType() == Material.COBBLESTONE_STAIRS){
				Location location =  event.getClickedBlock().getLocation().add(0.5, (1 - 0.5), 0.5);
				Item drop = location.getWorld().dropItemNaturally(location, new ItemStack(Material.PUMPKIN_STEM));
				drop.setPickupDelay(Integer.MAX_VALUE);
				drop.teleport(location);
				drop.setVelocity(new Vector(0, 0, 0));
				Location loc = event.getPlayer().getLocation();
				switch (((Stairs)event.getClickedBlock().getState().getData()).getDescendingDirection()) {
				case NORTH:
					loc.setYaw(180);
					break;
				case SOUTH:
					loc.setYaw(0);
					break;
				case EAST:
					loc.setYaw(270);
					break;
				case WEST:
					loc.setYaw(90);
					break;
				default:
					break;
				}
				drop.setPassenger(event.getPlayer());
				drop.setVelocity(new Vector(0, 0, 0));
				event.setCancelled(true);
			}
		}
		
	}
			
}