package Server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ServerChat extends JPanel{

    public ServerChat() throws IOException {
        jTextArea = new JTextArea();
        threadReciveClientInfo = new ThreadReciveClientInfo();
        threadReciveClientInfo.start();
        threadManageMessage = new ThreadManageMessage();
        threadManageMessage.start();

        setLayout(new BorderLayout());

        add(jTextArea,BorderLayout.CENTER);

    }

    private JTextArea jTextArea ;
    private ThreadReciveClientInfo threadReciveClientInfo ;
    private ThreadManageMessage threadManageMessage ;

}
