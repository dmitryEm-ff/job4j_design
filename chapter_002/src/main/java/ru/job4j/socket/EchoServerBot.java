package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerBot {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "null";
                    if (str != null && !str.isEmpty()) {
                        if (str.contains("Exit")) {
                            System.out.println(str);
                            server.close();
                        }
                        if (str.contains("Hello")) {
                            System.out.println(str);
                            answer = "Hello.";
                        } else {
                            System.out.println(str);
                            answer = "What.";
                        }
                    }
                    out.write(("HTTP/1.1 200 OK\r\n\r\n").getBytes());
                    out.write(answer.getBytes());
                    out.flush();
                }
            }
        }
    }
}