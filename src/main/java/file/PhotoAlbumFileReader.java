package file;
import photo.Photo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhotoAlbumFileReader {
    private String csvFile;
    private static String CSV_SPLIT_BY = ",";

    public PhotoAlbumFileReader(String csvFile) {
        this.csvFile = csvFile;
    }
    public Map<String, Photo> readPhotosFile() {
        Map<String, Photo> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] photoDetails = line.split(CSV_SPLIT_BY);
                Photo photo = new Photo();
                photo.setName(photoDetails[0]);
                photo.setType(photoDetails[1]);
                photo.setSize(Float.valueOf(photoDetails[2]));
                photo.setPath(photoDetails[3]);
                map.put(photo.getName(), photo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
