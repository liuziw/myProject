package com.zw.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2018/11/14 18:00
 */
public class WeatherClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8091;

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;0<10;i++){
            Thread.sleep(1000);
            Socket socket = null;
            DataInputStream dataInputStream = null;
            DataOutputStream dataOutputStream = null;
            OutputStream os = null;
            PrintWriter pw = null;
            try {
                socket = new Socket(HOST, PORT);

                //给服务端发送请求
            /*dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String request = null;
            dataOutputStream.writeUTF(request);
            dataInputStream = new DataInputStream(socket.getInputStream());
            String response = dataInputStream.readUTF();
            System.out.println(response);*/
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.write("*HQ,4710089691,V1,075737,V,2248.7709,N,11525.4151,E,000.00,346,110119,FFFFFBFF,460,00,0,0,6#");
//                pw.write("2447100898380943412703192247887106115227797E000047FFFFFBFFFF001F6B0000064201CC0000000000007DA2");
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(dataInputStream != null){
                        dataInputStream.close();
                    }
                    if(dataOutputStream != null){
                        dataOutputStream.close();
                    }
                    if(socket != null){
                        socket.close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                    try {
                        if (os != null) {
                            os.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
