package cn.lingyuncraft.playertpslimiter.listener;

import cn.lingyuncraft.playertpslimiter.PlayerTPSLimiter;
import cn.lingyuncraft.playertpslimiter.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.data.autoload.PAutoload;

@PAutoload
public class PlayerJoiner implements Listener {

    PPlugin plugin = ParrotXAPI.getPlugin(PlayerTPSLimiter.class);

    @EventHandler
    public void onPlayerConnect(AsyncPlayerPreLoginEvent e) {
        if (Bukkit.getTPS()[Configuration.TPSCHECKMODE] <= Configuration.LIMITTPS) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL,
                    plugin.getLang().data.getInfo("Lang", "KickMessage", Configuration.LIMITTPS));
            plugin.getLang().log.info("玩家"+e.getName()+"由于尝试在TPS过低时加入服务器而被断开连接");
        }
    }
}