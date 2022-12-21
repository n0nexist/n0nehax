package n0nehax.nonehax;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public final class Nonehax extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new CmdHan());
        System.out.println("[N0NEHAX] PLUGIN ABILITATO");
    }

    @Override
    public void onDisable() {
        System.out.println("[N0NEHAX] PLUGIN DISABILITATO");
    }

}
