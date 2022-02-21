package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadReciveClientInfo extends Thread{

    public ThreadReciveClientInfo() throws IOException {

        userConected = new ArrayList<>();

    }

    @Override
    public void run() {

        try {

            ServerSocket serverSocket = new ServerSocket(9090);

            while (true){

                Socket socket = serverSocket.accept();

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                InetAddress inetAddress = socket.getInetAddress();

                String s = dataInputStream.readUTF() ;

                userConected.add(new ClientInfo(s, inetAddress.getHostAddress()));

                System.out.println(s + " se conecto");

                sendConectedUsers();

                dataInputStream.close();

                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void sendConectedUsers() throws IOException {

        for (ClientInfo ci : userConected){

            Socket socket = new Socket(ci.getIp(),9000);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF(ci.getIp()+"&"+ci.getNickName());

            dataOutputStream.close();

            socket.close();

        }

    }

    private ArrayList<ClientInfo> userConected ;

}
