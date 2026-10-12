package user;

import shared.TaskMessage;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class UserClient {

    public static void main(String[] args) throws Exception {

        String masterIp = args[0];
        int masterPort = Integer.parseInt(args[1]);

        Socket socket = new Socket(masterIp, masterPort);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Jar path: ");
        String jarPath = scanner.nextLine();

        System.out.print("Option: ");
        String option = scanner.nextLine();

        System.out.print("File path: ");
        String filePath = scanner.nextLine();

        File jarFile = new File(jarPath);
        File inputFile = new File(filePath);

        TaskMessage msg = new TaskMessage(
                jarFile.getName(),
                Files.readAllBytes(jarFile.toPath()),
                option,
                inputFile.getName(),
                Files.readAllBytes(inputFile.toPath()));

        out.writeObject(msg);

        TaskMessage response = (TaskMessage) in.readObject();

        Files.write(
                new File("Result_Output").toPath(),
                response.getResultFile());

        socket.close();
        scanner.close();
    }
}