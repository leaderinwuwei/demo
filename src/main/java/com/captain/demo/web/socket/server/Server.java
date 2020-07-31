package com.captain.demo.web.socket.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Captain Wang
 * @time2020/6/20
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(socketIn.readLine());
    }
}
