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
        ServerSocket ss;
        System.out.println("Running...");
        Socket tempS;
        BufferedReader tempRead;
        PrintWriter tempWrite;
        try {
            ss = new ServerSocket(port);
            tempS = ss.accept();
            System.out.println("A new client is connected : " + tempS);

            tempRead = new BufferedReader(new InputStreamReader(tempS.getInputStream()));
            tempWrite = new PrintWriter(tempS.getOutputStream(), true);

        } catch (Exception e) {
            e.printStackTrace();
            tempS = null;
            tempRead = null;
            tempWrite = null;
        }
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
                System.out.println(received);

                if (received.equals("mea")) {
                    System.out.println("DANGER");
                    //Controller.danger_show();
                    write.println("true");
                    Controller controller = MainApp.loader.getController();
                    controller.danger_show();
                }
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
                System.out.println("this part");
                break;
            }
        }
        System.out.println("stuff");
        Thread.currentThread().interrupt();
    }
}
