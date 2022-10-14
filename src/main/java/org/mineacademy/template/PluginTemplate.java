package org.mineacademy.template;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class PluginTemplate extends SimplePlugin {

	/**
	 * LOL
	 */
	double apple = 1.50;
	String yo = "Yo";


	/**
	 * Automatically perform login ONCE when the plugin starts.
	 */
	@Override
	protected void onPluginStart() {
		System.out.println("Modulos of 15 % 8: " + (15 % 8));
		System.out.println("Knock, knock!");
		System.out.println("Hello " + (1 + 1) + " YOU");

		// for each loop that kicks all players on server start (for no reason)
		for (Player player : Remain.getOnlinePlayers()) {
			player.kickPlayer("Bye from the loop!");
		}
	}

	/* ------------------------------------------------------------------------------- */
	/* Events */
	/* ------------------------------------------------------------------------------- */

	/**
	 * An example event that checks if the right clicked entity is a cow, and makes an explosion.
	 * You can write your events to your main class without having to register a listener.
	 *
	 * @param event the click entity event, woo
	 */
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent event) {

		boolean isPig = event.getRightClicked().getType() == EntityType.PIG;
		String message = isPig ? "That was a pig!" : "Not a pig!";

		Player player = event.getPlayer();
		player.sendMessage(message);

		if (isPig) {
			event.getRightClicked().setFireTicks(100);
			player.sendMessage(ChatColor.RED + "Setting pig on fire muha!");
		}
	}

	// returns two numbers, multiplied
	int multiply(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}

}
