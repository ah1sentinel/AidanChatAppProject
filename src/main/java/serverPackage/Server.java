/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Aidan
 */
public class Server {
    static ConcurrentHashMap<Integer, String> clientName
            = new ConcurrentHashMap<Integer, String>(); //index is the key, index in active concurrenthashmap is the name
    static ConcurrentHashMap<String, ServerClientHandler> clientActive
            = new ConcurrentHashMap<String, ServerClientHandler>();
//    counter for clients
    static int i = 0;

    public static void main(String[] args) throws IOException {
//        server is listening on port 2345
        ServerSocket ss = new ServerSocket(2345);

        Socket s;

//            running infinite loop for getting client request
        while (true) {
//            accept the incoming request
            s = ss.accept();

//            System.out.println("New client request received : " + s);

//            obtaining input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

//            System.out.println("Creating new handler for this client...");

//            create new handler object for handling this request
            ServerClientHandler mtch = new ServerClientHandler(s, "client " + i, dis, dos); //terug na OORSPRONKLIKE CODE
//            create a new thread with this object
            Thread t = new Thread(mtch);

//            System.out.println("Adding this client to active client list");

//            add this client to active client list
            clientName.put(i, mtch.receivingUser);
            clientActive.put(mtch.receivingUser, mtch);

//            start the thread
            t.start();

//            increment i for new client 
            i++;
        }
    }
}
