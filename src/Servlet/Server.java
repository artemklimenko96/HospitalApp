package Servlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Artem Klimenko on 22 Jan 2017.
 */
public class Server {

        public static void main(String[] args) {
            try {
                //Creating socket listener
                ServerSocket socketListener = new ServerSocket(1234);

                while (true) {
                    Socket client = null;
                    while (client == null) {
                        client = socketListener.accept();
                    }
                    //new ClientThread(client); //Creating new thread for each client
                }
            } catch (SocketException e) {
                System.err.println("Socket exception");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("I/O exception");
                e.printStackTrace();
            }
        }
    }


