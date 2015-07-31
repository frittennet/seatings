package ch.toothwit.seatings.main;

import ch.toothwit.seatings.events.PlayerEventListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import org.bukkit.Bukkit;

public class Seatings extends JavaPlugin {
	
	public HashMap<String, Seat> seats = new HashMap<String, Seat>();
	public Seat getSeat(String uuid){
		return seats.get(uuid);
	}
	
	public void addSeat(String uuid, Seat seat){
		seats.put(uuid, seat);
	}
	
	public void removeSeat(String uuid){ 
		seats.get(uuid).arrow.remove(); 
		seats.remove(uuid);
	}
	
	private static Seatings instance;
	private int runnableId;

	public Seatings() {
		instance = this;
	}

	public static Seatings get() {
		return instance;
	}

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerEventListener(), this);
		getLogger().info("Seatings has been enabled");
		
		
	}

	@Override
	public void onDisable() {
		Bukkit.getServer().getScheduler().cancelTask(this.runnableId);
		
		getLogger().info("Seatings has been disabled"); 
	}
	
	
	

}
