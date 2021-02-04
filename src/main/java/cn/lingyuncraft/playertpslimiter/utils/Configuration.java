package cn.lingyuncraft.playertpslimiter.utils;

import cn.lingyuncraft.playertpslimiter.PlayerTPSLimiter;
import lombok.NonNull;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.config.PConfig;
import org.serverct.parrot.parrotx.data.autoload.PAutoload;
import org.serverct.parrot.parrotx.data.autoload.PAutoloadGroup;

import java.io.File;

@PAutoloadGroup
public class Configuration extends PConfig {

    @PAutoload("LimitTPS")
    public static double LIMITTPS;
    @PAutoload("TPSCheckMode")
    public static int TPSCHECKMODE;

    public Configuration() {
        super(ParrotXAPI.getPlugin(PlayerTPSLimiter.class), "config", "主配置文件");
    }

    @Override
    public void load(@NonNull File file) {
        if (TPSCHECKMODE != 0 && TPSCHECKMODE != 1 && TPSCHECKMODE != 2) {
            plugin.getLang().log.error("初始化", "TPS检查模式", "模式必须设置为0,1,2之一");
            TPSCHECKMODE = 2;
        }
    }
}
