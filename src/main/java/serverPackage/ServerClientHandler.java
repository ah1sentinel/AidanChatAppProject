/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverPackage;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.bson.Document;

/**
 *
 * @author Aidan
 */
public class ServerClientHandler implements Runnable {

    Scanner scan = new Scanner(System.in);
    final DataInputStream dis;
    final DataOutputStream dos;
    Socket s;
    boolean isloggedin;

    String username;
    String password;
    String firstName;
    String surname;
    String receivingUser;

    public String newReceivingUser = " ";
 
    public ServerClientHandler(Socket s, String receivingUser, DataInputStream dis, DataOutputStream dos) {
        this.receivingUser = receivingUser;
        this.dis = dis;
        this.dos = dos;
        this.s = s;
        this.isloggedin = false;
    }

    @Override
    public void run() {
        String received;
        while (true) {

            try {
//                receive the string
                received = dis.readUTF();

                if (received.equals("logout")) {
                    this.isloggedin = false;
                    this.s.close();

                    cycleActiveUsers();

                    break;
                }
                StringTokenizer stUser = new StringTokenizer(received, "#");
                String userAction = stUser.nextToken();

                if (isloggedin == false && userAction.equals("isAlreadyLoggedIn")) {

                    newReceivingUser = stUser.nextToken();

                    Server.clientActive.put(newReceivingUser, this);
                    Server.clientName.replace(Integer.valueOf(receivingUser.substring(7)), newReceivingUser);

                    isloggedin = true;
                    cycleActiveUsers();

                    if (Server.clientName.containsValue(newReceivingUser) && Server.clientActive.get(newReceivingUser).isloggedin) {

                    }

                } else if (isloggedin == false && userAction.equals("testUsername")) {
                    String usernameInput = stUser.nextToken();

                    sendUsernameAvailability((String) checkUsernameAvailability(usernameInput));

                } else if (isloggedin == false && userAction.equals("checkUsernameAndPassword")) {

                    String usernameInput = stUser.nextToken();
                    password = stUser.nextToken();

                    checkUsernameAndPassword(usernameInput, password);

                } else if (isloggedin == false && userAction.equals("createNewUser")) {
                    username = stUser.nextToken();
                    password = stUser.nextToken();
                    firstName = stUser.nextToken();
                    surname = stUser.nextToken();

                    addNewUser(username, password, firstName, surname);

                } else if (isloggedin && userAction.equals("sendMessage")) {

                    String sender = stUser.nextToken();
                    String msgToSend = stUser.nextToken();
                    String recipient = stUser.nextToken();
                    sendMessage(sender, msgToSend, recipient);

                    if (Server.clientName.contains(recipient) && Server.clientActive.get(recipient).isloggedin) {

                        Server.clientActive.get(recipient).dos.writeUTF("receiveMessage#"
                                + sender + "#" + msgToSend + "#" + recipient);

                        dos.writeUTF("receiveMessage#"
                                + sender + "#" + msgToSend + "#" + recipient);

                    }
                }
            } catch (EOFException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void sendMessage(String sender, String message, String recipient) {
        MongoClient mongoClient = new MongoClient("localhost");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("serverDB");

        boolean colExits = false;
        MongoCollection<Document> collection = null;
        for (String name : mongoDatabase.listCollectionNames()) {

            if (name.equals("messages")) {
                colExits = true;
                break;
            }
        }
        if (colExits) {
            collection = mongoDatabase.getCollection("messages");

        } else {

            mongoDatabase.createCollection("messages");
            collection = mongoDatabase.getCollection("messages");
        }

        Document doc = new Document("Sender", sender).append("Recipient", recipient).append("Message", message);

        collection.insertOne(doc);
        mongoClient.close();
    }

    public static String checkUsernameAvailability(String username) {
        MongoClient mongoClient = new MongoClient("localhost");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("serverDB");

        boolean colExits = false;
        MongoCollection<Document> collection = null;
        for (String name : mongoDatabase.listCollectionNames()) {

            if (name.equals("appMembers")) {
                colExits = true;
                break;
            }
        }
        if (colExits) {
            collection = mongoDatabase.getCollection("appMembers");

        } else {

            mongoDatabase.createCollection("appMembers");
            collection = mongoDatabase.getCollection("appMembers");
        }

        BasicDBObject query = new BasicDBObject("Username", username);
        FindIterable<Document> cursor = collection.find(query);
        for (Document doc : cursor) {
            if ((doc.get("Username", String.class)).equals(username)) {
                return "false";
            }
        }
        return "true";
    }

    public void sendUsernameAvailability(String answer) throws IOException {
        try {
            dos.writeUTF(answer);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewUser(String username, String password, String firstName, String surname) {
        MongoClient mongoClient = new MongoClient("localhost");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("serverDB");

        boolean colExits = false;
        MongoCollection<Document> collection = null;
        for (String name : mongoDatabase.listCollectionNames()) {

            if (name.equals("appMembers")) {
                colExits = true;
                break;
            }
        }
        if (colExits) {
            collection = mongoDatabase.getCollection("appMembers");

        } else {

            mongoDatabase.createCollection("appMembers");
            collection = mongoDatabase.getCollection("appMembers");
        }

        Document document = new Document("Username", username).append("Password", password)
                .append("First Name", firstName).append("Surname", surname);

        collection.insertOne(document);

    }

    private String checkPassword(String password) {
        MongoClient mongoClient = new MongoClient("localhost");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("serverDB");

        boolean colExits = false;
        MongoCollection<Document> collection = null;
        for (String name : mongoDatabase.listCollectionNames()) {

            if (name.equals("appMembers")) {
                colExits = true;
                break;
            }
        }
        if (colExits) {
            collection = mongoDatabase.getCollection("appMembers");

        } else {

            mongoDatabase.createCollection("appMembers");
            collection = mongoDatabase.getCollection("appMembers");
        }

        BasicDBObject query = new BasicDBObject("Password", password);
        FindIterable<Document> cursor = collection.find(query);
        for (Document doc : cursor) {
            if ((doc.get("Password", String.class)).equals(password)) {
                return "false";
            }
        }
        return "true";
    }

    private void checkUsernameAndPassword(String username, String password) {
        boolean usernameFound = !Boolean.valueOf(checkUsernameAvailability(username));
        boolean passwordFound = !Boolean.valueOf(checkPassword(password));
        try {
            dos.writeUTF("checkUsernameAndPassword#" + usernameFound + "#" + passwordFound);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendUpdatedList(ServerClientHandler cl) {

        String str = "";

        MongoClient mongoClient = new MongoClient("localhost");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("serverDB");
        boolean colExits = false;
        MongoCollection<Document> collection = null;
        for (String name : mongoDatabase.listCollectionNames()) {

            if (name.equals("appMembers")) {
                colExits = true;
                break;
            }
        }
        if (colExits) {
            collection = mongoDatabase.getCollection("appMembers");

        } else {

            mongoDatabase.createCollection("appMembers");
            collection = mongoDatabase.getCollection("appMembers");
        }

        FindIterable<Document> cursor = collection.find();
        for (Document doc : cursor) {
            if (Server.clientActive.containsKey(doc.get("Username", String.class))
                    && Server.clientActive.get(doc.get("Username", String.class)).isloggedin) {
                str += doc.get("Username", String.class) + "#" + "Online#";
            } else {
                str += doc.get("Username", String.class) + "#" + "Offline#";
            }
        }
        try {
            cl.dos.writeUTF("populateList#" + str + "endOfList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cycleActiveUsers() {

        for (ServerClientHandler cli : Server.clientActive.values()) {
            if (cli.isloggedin) {
                sendUpdatedList(cli);
            }
        }
    }

}
