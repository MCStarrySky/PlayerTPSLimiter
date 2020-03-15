package cn.lingyuncraft.playertpslimiter;

import cn.lingyuncraft.playertpslimiter.command.PlayerTpsLimiterCommand;
import cn.lingyuncraft.playertpslimiter.listener.PlayerJoiner;
import cn.lingyuncraft.playertpslimiter.utils.Configuration;
import org.bukkit.Bukkit;
import org.serverct.parrot.parrotx.PPlugin;

/**
 * @author shaokeyibb
 */
public final class PlayerTPSLimiter extends PPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("插件已卸载");
    }

    @Override
    protected void preload() {
        pConfig = new Configuration(this);
        pConfig.init();
    }

    @Override
    protected void registerListener() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoiner(), this);
    }

    @Override
    public void load() {
        getLogger().info("正在加载PlayerTPSLimiter，版本" + getDescription().getVersion());
        super.registerCommand("playertpslimiter", new PlayerTpsLimiterCommand(this));
    }

}
