package com.captain.demo.socket.client;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Captain Wang
 * @time2020/6/20
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8088);
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        socketOut.println("888888");
        socketOut.flush();
        socketOut.close();
        socket.close();
    }
}
