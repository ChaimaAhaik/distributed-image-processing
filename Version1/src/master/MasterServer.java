package master;

import java.net.ServerSocket;
import java.net.Socket;

public class MasterServer {

    private static MasterServer instance;
    private int userPort;
    private ServerSocket serverSocket;

    private MasterServer(int userPort) {
        this.userPort = userPort;
    }

    public static MasterServer getInstance(int userPort) {
        if (instance == null) {
            instance = new MasterServer(userPort);
        }
        return instance;
    }

    public void start() throws Exception {

        serverSocket = new ServerSocket(userPort);

        System.out.println("Master running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }
    }

    public static void main(String[] args) throws Exception {

        int port = Integer.parseInt(args[0]);

        MasterServer server = MasterServer.getInstance(port);

        server.start();
    }
}