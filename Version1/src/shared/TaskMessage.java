package shared;

import java.io.Serializable;

public class TaskMessage implements Serializable {

    private String jarName;
    private byte[] jarContent;

    private String options;

    private String fileName;
    private byte[] fileContent;

    private byte[] resultFile;

    public TaskMessage(String jarName, byte[] jarContent,
            String options,
            String fileName, byte[] fileContent) {

        this.jarName = jarName;
        this.jarContent = jarContent;
        this.options = options;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getJarName() {
        return jarName;
    }

    public byte[] getJarContent() {
        return jarContent;
    }

    public String getOptions() {
        return options;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public byte[] getResultFile() {
        return resultFile;
    }

    public void setResultFile(byte[] resultFile) {
        this.resultFile = resultFile;
    }
}