package Servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by Artem Klimenko on 22 Jan 2017.
 */
public class ClientThread extends Thread{
/*
        private Socket socket;
        AlertStaff c;

        public ClientThread(Socket socket) {
            this.socket = socket;
            this.start();
        }

        public void run() {
            try {
                //Создаем потоки ввода-вывода для работы с сокетом
                final ObjectInputStream inputStream   = new ObjectInputStream(this.socket.getInputStream());
                final ObjectOutputStream outputStream = new ObjectOutputStream(this.socket.getOutputStream());

                //Читаем Message из потока
                this.c = (AlertStaff) inputStream.readObject();

                //Читаем логин отправителя


                //Что же нам прислали?
                if (!this.c.desc.equals("Establishing connection")) { //Если это не регистрационное сообщение
                    System.out.println("[" + this.c.getFirstName() + "]: " + this.c.getDesc());
                    getChatHistory().addMessage(this.c); //То добавляем его к истории чата
                } else {
                    outputStream.writeObject(getChatHistory()); //Иначе, отправляем новичку историю чата
                }
                //Добавляем к списку пользователей - нового
                getUserList().addUser(login, socket, outputStream, inputStream);

                //Для ответа, указываем список доступных пользователей
                this.c.setOnlineUsers(getUserList().getUsers());

                //Передаем всем сообщение пользователя
                this.broadcast(getUserList().getClientsList(), this.c);



            } catch (SocketException e) {

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    private void broadcast(ArrayList<Client> clientsArrayList, AlertStaff alert) {
        try {
            for (Client client : clientsArrayList) {
                client.getThisObjectOutputStream().writeObject(alert);
            }
        } catch (SocketException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
