package OpenInv;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.CommandExecutor;

import cn.nukkit.Player;

import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityEnderChest;

public class OpenInv extends PluginBase {

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
		Player player = (Player) sender;
		player.addWindow(player.getEnderChestInventory());
		return true;
            default:
		return false;
	}
    }
}
