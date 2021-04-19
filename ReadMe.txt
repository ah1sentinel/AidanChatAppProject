Chat App
This contains the code for my realtime chat app. The entire project receives messages in realtime without having the client instances poll the server for new messages. When the client's first file is ran, LoginFrame.java, the while loop that is found in the Server.java file accepts the socket connecting to the server. It then creates a new instance of the ServerClientHandler class using the values of the client's socket, DataInputStream, DataOutputStream and a generic naming scheme for each new LoginFrame instance socket connection that the Server.java file accepts. The ServerClientHandler instance is saved in a double ConcurrentHashMap with an incremented int value as the first ConcurrentHashMap (clientName) key value, with the generic name as the value saved at the index of the key value.

The generic name is used to link to the key of the second ConcurrentHashMap (clientActive), with the key value being the same generic name. As soon as a client successfully performs a successful login, the previously false isLoggedIn value of the ServerClientHandler instance for that specific socket is set to true. This specific instance of ServerClientHandler is then saved at a new position in the ConcurrentHashMap with the generic name being replaced with the logged-in client's username, and the ServerClientHandler instance with its isLoggedIn value being true saved to the value position.

This also triggers the server to run a method that checks which clients in the ConcurrentHashMaps have a true or false value for isLoggedIn, and sends that value on the DataOutputStream for each of the ServerClientHandler instances that have a true isLoggedIn value. This is sent together with a keyword notifying the CentralGui client frame to refresh the JList object containing the list of online and offline users of the server. All the usernames are saved to MongoDB on the server device upon using the CreateAccountFrame. This is used to determine if a client has the correct login credentials (username and password) and send a reply allowing or denying access based on input provided by the LoginFrame client instance.

The messages sent can only be received while the recipient user is marked as online, so users can only start a new chat and/or continue chatting with other users while both are marked as online. The messages sent to the server are first used to check if the recipient is online, if not the message is not attemped to be sent to the recipient client (since it is offline) or the original sender. The messages that are successfully sent to and received by online client instances are saved to the MongoDB of the client devices. This means that the messages are stored locally by the client device as well as by the server.

To send message as well as show previously sent and received chats, click on the JList component on the rightmost side of the CentralGui frame, the name that is selected will trigger the response displaying the previously saved chats on the leftmost side of the CentralGui frame. Adding text to the textfield located underneath the displayed chat messages and pressing send, sends the text typed to the selected user. This user will either receive the message if he/she is online, or the message will just be sent to the server and not sent back to the sender or receiver. Sending a message to an offline user will have the effect of making it seem as if no message was sent.

Project Development
This project was created using Apache Netbeans 12.3, Windows 10 and MongoDB Enterprise Edition.

Prerequisites
- Java JDK on the device that will be acting as the server as well as the client device that will be used
- IP Address of the device that will be acting as the server
- MongoDB (at least Community Edition or Enterprise Edition) installed on the server device and client devices

Running the client program (LoginFrame.java) for the first time on any client device:
1. Go to the LoginFrame.java file in the clientPackage subpackage
2. Open the LoginFrame.java file in any compatible IDE
3. Edit the ipAddress variable to contain the server device ip address