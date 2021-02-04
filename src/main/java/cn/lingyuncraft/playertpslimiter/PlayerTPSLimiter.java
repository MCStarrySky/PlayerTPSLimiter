package cn.lingyuncraft.playertpslimiter;

import cn.lingyuncraft.playertpslimiter.utils.Configuration;
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
        pConfig = new Configuration();
    }

    @Override
    public void load() {
        getLogger().info("正在加载PlayerTPSLimiter，版本" + getDescription().getVersion());
        getLogger().info("正使用TPS检查模式"+Configuration.TPSCHECKMODE+",TPS限制至"+Configuration.LIMITTPS);
    }

}
