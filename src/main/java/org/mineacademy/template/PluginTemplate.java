package org.mineacademy.template;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.mineacademy.fo.model.LimitedQueue;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.remain.Remain;

import java.util.*;

/**
 * PluginTemplate is a simple template you can use every time you make
 * a new plugin. This will save you time because you no longer have to
 * recreate the same skeleton and features each time.
 * <p>
 * It uses Foundation for fast and efficient development process.
 */
public final class PluginTemplate extends SimplePlugin {

	private final List<Material> rewards = new ArrayList<>(Arrays.asList(
			Material.DIAMOND,
			Material.IRON_INGOT,
			Material.CARROT,
			Material.BONE)
	);

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

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();


		Collections.shuffle(this.rewards);

		inventory.addItem(new ItemStack(this.rewards.get(0)));

		/*ItemStack[] contents = inventory.getContents();

		for (int index = 0; index < contents.length; index++) {
			ItemStack item = contents[index];
			boolean isDiamond = item != null && item.getType() == Material.DIAMOND;

			if (item == null || isDiamond) {
				int diamondAmount = isDiamond ? item.getAmount() : 0;
				contents[index] = new ItemStack(Material.DIAMOND, diamondAmount + 1);

				player.sendMessage("You've been given 1x Diamond to your " + index + " slot.");

				break;
			}
		}

		inventory.setContents(contents);*/
	}

	Queue<String> messages = new LimitedQueue<>(3);

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		messages.add(event.getMessage());

		System.out.println("Last 3 messages from all players in the chat: " + this.messages);

	}
}
