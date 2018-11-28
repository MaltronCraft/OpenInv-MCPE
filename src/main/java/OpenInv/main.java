package OpenInv;

import cn.nukkit.block.Block;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.*;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import cn.nukkit.tile.Chest;
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
    
    public void sendEnderChestInventory(Player player){
	    int block = Block.get(54);
	    player.getLevel().setBlock(new Vector3(player.x, player.y - 2, player.z), block, true, true);
	    nbt = new CompoundTag("",) [
		    new ListTag("Items", []),
		    new StringTag("id", BlockEntity.ENDER_CHEST),
		    new IntTag("x", floor(player.x)),
		    new IntTag("y", floor(player.y) - 2),
		    new IntTag("z", floor(player.z))
	    ];
	    nbt.Items.setTagType(NBTIO.TAG_Compound);
	    int tile = BlockEntity.createBlockEntity("Ender Chest", player.getLevel().getChunk(player.getX() >> 4, player.getZ() >> 4), nbt);
	    player.addWindow(tile.getInventory());
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      switch (command.getName()) {
	case "addwindow":
          sender.sendMessage("Added chest window!");
          this.sendEnderChestInventory(sender);
        break;
      }
    }
  }
}
