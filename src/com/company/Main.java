package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New connection accepted. Port: " + clientSocket.getPort());
                out.println(("Write your name"));
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d. Are you child? (yes/no)", name, clientSocket.getPort()));
                final String age = in.readLine();
                if (age.equals("yes")) {
                    out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                } else if (age.equals("no")) {
                    out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                } else {
                    out.println(String.format("Don't be shy about your age, %s!", name));
                }
            }
        }
    }
}
