package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMultithread implements Runnable{


        private Socket clientSocket;

        public ServerMultithread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            System.out.println("Serverino started, " +
                    "address: " + clientSocket.getInetAddress());
            try {

                PrintWriter toClient
                        = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String richiesta = ""; //stringa in ingresso dal client, se il client inserisce exit esce

                while (!richiesta.equals("exit")) {
                    System.out.println("serverino is listening");
                    richiesta = fromClient.readLine();
                    System.out.println("String from client: " + richiesta);  //stampa frase dal server
                    int x = richiesta.length();
                    toClient.println("n.carachters: "+x);
                }

                fromClient.close();
                clientSocket.close();

                System.out.println("chiusura connessione effettuata");

            } catch (IOException ex) {
                Logger.getLogger(ServerMultithread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }



