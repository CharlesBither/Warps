package tech.secretgarden.warps;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class Warps extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Warps: hello world!");

//        EventListener eventListener = new EventListener();
//        Bukkit.getPluginManager().registerEvents(eventListener, this);

        this.getServer().getMessenger().registerIncomingPluginChannel(this, "secret:garden", this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("secret:garden")) {
            System.out.println("not Secret!");
            return;
        }
        System.out.println("Recieved!");


        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subChannel = in.readUTF();
        if (subChannel.equals("send")) {
            // Use the code sample in the 'Response' sections below to read
            // the data.


            String data1 = in.readUTF();
            String data2 = in.readUTF();
            System.out.println(data1);
            System.out.println(data2);

//            short len = in.readShort();
//            byte[] msgbytes = new byte[len];
//            in.readFully(msgbytes);
//
//            DataInputStream msgin = new DataInputStream(new ByteArrayInputStream(msgbytes));
//            try {
//                String somedata = msgin.readUTF(); // Read the data in the same way you wrote it
//                System.out.println(somedata);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
