package cn.lingyuncraft.playertpslimiter.listener;

import cn.lingyuncraft.playertpslimiter.PlayerTPSLimiter;
import cn.lingyuncraft.playertpslimiter.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.utils.I18n;

public class PlayerJoiner implements Listener {

    PPlugin plugin = PlayerTPSLimiter.getInstance();

    @EventHandler
    public void onPlayerConnect(AsyncPlayerPreLoginEvent e) {
        if (Bukkit.getTPS()[Configuration.TPSCHECKMODE] <= Configuration.LIMITTPS) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, plugin.lang.get(plugin.localeKey, I18n.Type.INFO, "Lang", "KickMessage")
                    .replace("{0}", String.valueOf(Configuration.LIMITTPS)));
            plugin.lang.log("玩家"+e.getName()+"由于尝试在TPS过低时加入服务器而被断开连接", I18n.Type.INFO,true);
        }
    }
}