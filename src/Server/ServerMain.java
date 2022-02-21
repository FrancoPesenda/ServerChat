package Server;

import GeneralThings.GeneralFrame;

import java.awt.*;
import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        GeneralFrame generalFrame = new GeneralFrame();
        ServerChat serverChat = new ServerChat();

        generalFrame.setSize(new Dimension(generalFrame.getWidth() + 1 , generalFrame.getHeight()));
        generalFrame.setLocation(generalFrame.getX() + 300 , generalFrame.getY());

        generalFrame.add(serverChat);

    }

}
