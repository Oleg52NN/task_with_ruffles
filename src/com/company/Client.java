package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(in.readLine());
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            //out.println("Netology");
            out.println(name);
            System.out.println(in.readLine());
            String age = scanner.nextLine();
            out.println(age);
            //out.println("yes");
            System.out.println(in.readLine());
        }

    }

}