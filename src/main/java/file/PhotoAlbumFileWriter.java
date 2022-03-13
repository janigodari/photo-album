package file;
import photo.Photo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PhotoAlbumFileWriter {
    private static final char DEFAULT_SEPARATOR = ',';
    private String csvFile;

    public PhotoAlbumFileWriter(String csvFile) throws IOException {
        this.csvFile = csvFile;
    }

    public void writePhotos(List<Photo> photos) throws IOException {
        FileWriter writer = new FileWriter(csvFile);

        StringBuilder sb = new StringBuilder();
        for (Photo photo : photos) {
            sb.append(photo.getName())
                    .append(DEFAULT_SEPARATOR)
                    .append(photo.getType())
                    .append(DEFAULT_SEPARATOR)
                    .append(photo.getSize())
                    .append(DEFAULT_SEPARATOR)
                    .append(photo.getPath())
                    .append("\n");
        }
        writer.append(sb.toString());
        writer.close();
    }
}
