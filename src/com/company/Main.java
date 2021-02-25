package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket server
                    = new ServerSocket(5500);
            System.out.println("Server is active and is listening");

            while (true) {
                Socket client = server.accept();
                System.out.println("connection received, now it's the thread's job");
                System.out.println();
                Thread Serverino = new Thread(new ServerMultithread(client));
                Serverino.start();

            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

