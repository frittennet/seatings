package ch.toothwit.seatings.main;

import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Stairs;
import org.bukkit.util.Vector;

public class Seat {
	Location initialPos;
	Arrow arrow;
	Player seater;
	
	public Seat(Block clicked, Player player){
		initialPos = clicked.getLocation().add(new Vector(0.5, 0, 0.5));
		seater = player;
		
		for(Entry<String, Seat> entry : Seatings.get().seats.entrySet()){
			if(entry.getValue().initialPos.equals(initialPos)){
				return;
			}
		}
		
		arrow = seater.getWorld().spawnArrow(initialPos, new Vector(0,-1,0), 0, 0);
		
		Location playerLoc = player.getLocation();
		switch (((Stairs)clicked.getState().getData()).getDescendingDirection()) {
		case NORTH:
			playerLoc.setYaw(180);
			break;
		case SOUTH:
			playerLoc.setYaw(0);
			break;
		case EAST:
			playerLoc.setYaw(270);
			break;
		case WEST:
			playerLoc.setYaw(90);
			break;
		default:
			break;
		}
		
		arrow.setPassenger(player);
		Seatings.get().addSeat(player.getUniqueId().toString(), this); 
	}
}
