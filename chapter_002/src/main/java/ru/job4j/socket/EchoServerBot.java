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
            boolean flag = true;
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "null";
                    while ((str = in.readLine()) != null && !str.isEmpty()) {
                        if (str.contains("Exit")) {
                            System.out.println(str);
                            flag = false;
                            break;
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
                }
            }
        }
    }
}
