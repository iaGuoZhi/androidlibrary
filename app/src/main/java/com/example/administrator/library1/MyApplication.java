package com.example.administrator.library1;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Enumeration;

public class MyApplication extends Application{
    public String lib_ip ="10.162.221.23";
    public int lib_object = 4567;

    String SendMessageToServer(String msg) {
        String revMsg = "";
        if (lib_ip.equals(""))
            return "Not set Server IP";
        try {
            Socket clientsocket = new Socket(lib_ip, lib_object);
            OutputStream outputStream = clientsocket.getOutputStream();
            byte writeData[] = msg.getBytes(Charset.forName("UTF-8"));
            outputStream.write(writeData, 0, writeData.length);
            outputStream.flush();
            Toast.makeText(this,"success1",Toast.LENGTH_SHORT).show();

            InputStream inputStream = clientsocket.getInputStream();
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            byte readData[] = new byte[count];
            inputStream.read(readData, 0, readData.length);
            revMsg = new String(readData, Charset.forName("UTF-8"));
            outputStream.close();
            inputStream.close();
            clientsocket.shutdownInput();
            clientsocket.shutdownOutput();
            clientsocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return revMsg;
    }
}
