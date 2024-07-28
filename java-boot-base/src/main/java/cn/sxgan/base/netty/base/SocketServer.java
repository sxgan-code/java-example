package cn.sxgan.base.netty.base;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Socket服务
 * @Author: sxgan
 * @Date: 2024-07-28 13:09
 * @Version: 1.0
 **/
@Slf4j
public class SocketServer {
    /**
     * 存放当前连接的客户端
     */
    final static Map<String, Socket> CLIENT_MAP = new ConcurrentHashMap<>();
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("服务端启动");
            while (true) {
                Socket accept = serverSocket.accept();
                String hostAddress = serverSocket.getInetAddress().getHostAddress();
                int port = accept.getPort();
                log.info("客户端已连接，当前连接IP：{}:{},", hostAddress, port);
                // 保存当前连接
                String key = hostAddress + port;
                CLIENT_MAP.put(key, accept);
                new Thread(() -> {
                    while (true) {
                        try {
                            InputStream inputStream = accept.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String readLine = bufferedReader.readLine();
                            log.info("server-->client,收到客户端消息：{}", readLine);
                            CLIENT_MAP.forEach((k, v) -> {
                                OutputStream outputStream = null;
                                try {
                                    outputStream = v.getOutputStream();
                                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                    printWriter.println(accept.getInetAddress() + ":" + accept.getPort() + "-->" + readLine);
                                    printWriter.write("\n我已写入完毕");
                                    printWriter.flush();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
