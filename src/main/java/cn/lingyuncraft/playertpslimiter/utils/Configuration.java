package cn.lingyuncraft.playertpslimiter.utils;

import lombok.NonNull;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.config.PConfig;

import java.io.File;

public class Configuration extends PConfig {

    public static double LIMITTPS;
    public static int TPSCHECKMODE;

    public Configuration(@NonNull PPlugin plugin) {
        super(plugin, "config", "主配置文件");
    }

    @Override
    public void saveDefault() {
        plugin.saveDefaultConfig();
    }

    @Override
    public void load(@NonNull File file) {
        LIMITTPS = config.getDouble("LimitTPS");
        TPSCHECKMODE = config.getInt("TPSCheckMode");
        if (TPSCHECKMODE != 0 && TPSCHECKMODE != 1 && TPSCHECKMODE != 2) {
            plugin.lang.logError("初始化", "TPS检查模式", "模式必须设置为0,1,2之一");
            TPSCHECKMODE = 2;
        }
    }
}
