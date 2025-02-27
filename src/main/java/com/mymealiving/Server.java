package com.mymealiving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server extends Thread {
    final BufferedReader read;
    final PrintWriter write;
    final Socket s;

    // Constructor
    public Server(int port) {
        //Defines main variables
        ServerSocket ss;
        Socket tempS;
        BufferedReader tempRead;
        PrintWriter tempWrite;

        try {
            //Starts server at port (port)
            ss = new ServerSocket(port);
            //Connects to a client
            tempS = ss.accept();

            //Sets up reader and writer channels
            tempRead = new BufferedReader(new InputStreamReader(tempS.getInputStream()));
            tempWrite = new PrintWriter(tempS.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
            tempS = null;
            tempRead = null;
            tempWrite = null;
        }

        //Sets instance variables to constructor variables
        this.s = tempS;
        this.read = tempRead;
        this.write = tempWrite;
    }

    @Override
    public void run() {
        String received;

        while (true) {
            try {
                received = read.readLine();

                if (received.equals("mea")) {
                    write.println("true");
                    Controller controller = MainApp.loader.getController();
                    controller.danger_show();
                }
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
                break;
            }
        }

        Thread.currentThread().interrupt();
    }
}
