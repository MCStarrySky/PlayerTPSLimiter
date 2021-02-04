package cn.lingyuncraft.playertpslimiter.command;

import cn.lingyuncraft.playertpslimiter.PlayerTPSLimiter;
import org.serverct.parrot.parrotx.api.ParrotXAPI;
import org.serverct.parrot.parrotx.command.CommandHandler;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;
import org.serverct.parrot.parrotx.data.autoload.PAutoload;

@PAutoload
public class PlayerTpsLimiterCommand extends CommandHandler {

    public PlayerTpsLimiterCommand() {
        super(ParrotXAPI.getPlugin(PlayerTPSLimiter.class), "playertpslimiter");
        register(new VersionCommand(plugin));
        register(new HelpCommand(plugin));
        register(new ReloadCommand(plugin, "PlayerTPSLimiter.admin"));
    }
}
