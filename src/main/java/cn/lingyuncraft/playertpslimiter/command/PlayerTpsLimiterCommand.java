package cn.lingyuncraft.playertpslimiter.command;

import lombok.NonNull;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.command.CommandHandler;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;

public class PlayerTpsLimiterCommand extends CommandHandler {

    public PlayerTpsLimiterCommand(@NonNull PPlugin plugin) {
        super(plugin);
        registerSubCommand("reload", new ReloadCommand("PlayerTPSLimiter.admin"));
        registerSubCommand("help", new HelpCommand("PlayerTPSLimiter.admin"));
    }
}
