package me.wethink.weHeads.utils;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import me.wethink.weHeads.WeHeadPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class HeadUtils {
    
    public static void giveCustomHead(Player player, String base64Texture, WeHeadPlugin plugin) {
        try {
            ItemStack head = createCustomHead(base64Texture);
            
            if (player.getInventory().firstEmpty() == -1) {
                player.sendMessage("§cYour inventory is full! Head dropped on ground.");
                player.getWorld().dropItem(player.getLocation(), head);
            } else {
                player.getInventory().addItem(head);
            }
            
            player.sendMessage("§aGiven custom head!");
            
        } catch (Exception e) {
            plugin.getLogger().warning("Error creating custom head: " + e.getMessage());
            player.sendMessage("§cError creating custom head. Please check the texture value.");
        }
    }
    
    private static ItemStack createCustomHead(String base64Texture) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        
        if (meta != null) {
            PlayerProfile profile = Bukkit.createProfile(UUID.randomUUID(), "CustomHead");
            
            ProfileProperty textureProperty = new ProfileProperty("textures", base64Texture);
            profile.getProperties().add(textureProperty);
            
            meta.setPlayerProfile(profile);
            meta.displayName(Component.text("§6Custom Head"));
            
            head.setItemMeta(meta);
        }
        
        return head;
    }
}
