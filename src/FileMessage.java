/**
 * Created by mat on 02/12/16.
 */
public class FileMessage extends PathMessage {
    private String filePath;

    public FileMessage(String destination, String source, int timestamp, String contentDescription, String filePath) {
        super(destination, source, timestamp, contentDescription);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
