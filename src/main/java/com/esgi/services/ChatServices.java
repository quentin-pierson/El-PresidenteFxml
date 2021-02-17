package com.esgi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServices {

    public void Listen(Socket clientSocket, ServerSocket serverSocket) {

        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc=new Scanner(System.in);

        try {

            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            Thread send = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        msg = sc.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            send.start();

            Thread receive= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();

                        while(msg!=null){
                            System.out.println("Client : "+msg);
                            msg = in.readLine();
                        }

                        System.out.println("Client déconecté");

                        out.close();
                        clientSocket.close();
                        if(serverSocket == null){
                            serverSocket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}