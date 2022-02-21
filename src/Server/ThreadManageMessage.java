package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadManageMessage extends Thread{
    public ThreadManageMessage(){
        message = "" ;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while(true){

                Socket socket = serverSocket.accept();

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

                message = dataInputStream.readUTF();

                sendToUser();

                dataInputStream.close();

                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToUser() throws IOException {

        String[] info = message.split("&");

        Socket socket = new Socket(info[1],8000);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(info[0]+"&"+info[2]);

        dataOutputStream.close();

        socket.close();

    }

    private String message ;

}
