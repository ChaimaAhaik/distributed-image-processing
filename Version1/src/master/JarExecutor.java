package master;

import shared.TaskMessage;
import java.io.*;
import java.nio.file.Files;

public class JarExecutor {

    public byte[] execute(TaskMessage msg) throws Exception {

        File jarFile = new File(msg.getJarName());
        File inputFile = new File(msg.getFileName());

        Files.write(jarFile.toPath(), msg.getJarContent());
        Files.write(inputFile.toPath(), msg.getFileContent());

        ProcessBuilder pb = new ProcessBuilder(
                "java", "-jar",
                jarFile.getName(),
                msg.getOptions(),
                inputFile.getName());

        Process process = pb.start();
        process.waitFor();

        File resultFile = new File("Result.jpg");
        return Files.readAllBytes(resultFile.toPath());
    }
}