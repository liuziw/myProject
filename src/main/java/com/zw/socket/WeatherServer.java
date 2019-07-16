package com.zw.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/28 12:10
 */
public class WeatherServer {
    public static void main(String[] args) throws IOException {
             int port = 8081;
             if (args != null && args.length > 0) {

                     try {
                         port = Integer.valueOf(args[0]);
                         } catch (NumberFormatException e) {
                         // 采用默认值
                         }

                 }
             ServerSocket server = null;
             try {
                     server = new ServerSocket(port);
                     System.out.println("The time server is start in port : " + port);
                     Socket socket = null;
                     while (true) {
                         socket = server.accept();
                         System.out.println(socket.getInetAddress()+",,,"+socket.getPort());
                         new Thread(new TimeServerHandler(socket)).start();
                         }
                 } finally {
                     if (server != null) {
                         System.out.println("The time server close");
                         server.close();
                         server = null;
                         }
                 }
             }
}
