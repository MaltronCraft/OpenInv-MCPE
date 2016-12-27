package nycuro;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.CommandExecutor;

import cn.nukkit.Player;
import cn.nukkit.block.BlockEnderChest;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.entity.EntityHumanType;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.inventory.PlayerEnderChestInventory;

public class EChest extends PluginBase {

    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "EChest loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "EChest enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "EChest disabled!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getName()) {
            case "echest":
                if (sender instanceof Player) {
			Player player = (Player) sender;
			Inventory eci = player.getBlockEnderChest();
			player.openInventory(eci);
		} else {
			return false;
		}
		default:
			return false;
	}
    }
}
