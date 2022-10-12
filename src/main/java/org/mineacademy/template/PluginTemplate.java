package org.mineacademy.template;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.mineacademy.fo.plugin.SimplePlugin;

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
		// hello
		System.out.println(1);
		/*
		 * hello
		 * hello
		 */


		System.out.println("Knock, knock!");
		System.out.println("Hello " + (1 + 1) + " YOU");
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

		event.getRightClicked().setFireTicks(100);

		/*if (event.getRightClicked().getType() == EntityType.PIG)
			event.getRightClicked().getWorld().createExplosion(event.getRightClicked().getLocation(), 5);*/
	}

	// returns two numbers, multiplied
	int multiply(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}

}
