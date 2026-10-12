package master;

import shared.TaskMessage;
import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            TaskMessage msg = (TaskMessage) in.readObject();

            JarExecutor executor = new JarExecutor();

            byte[] result = executor.execute(msg);

            msg.setResultFile(result);

            out.writeObject(msg);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}