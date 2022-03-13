package photo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotoAlbum {
    private String name = "Catalog";
    private String material = "Plastic";

    private Map<String, Photo> photos = new HashMap<String, Photo>();

    public PhotoAlbum() {
    }
    public PhotoAlbum(Map<String, Photo> photos) {
        this.photos = photos;
    }

    public Photo getPhoto(String name) {
        return photos.get(name);
    }

    public Boolean addPhoto(Photo photo) {
        Photo result = photos.put(photo.getName(), photo);
        if (result != null) {
            return true;
        }
        return false;
    }

    public Boolean checkPhotoInList(String name) {
        return photos.containsKey(name);
    }

    public Boolean deletePhoto(String name) {
        return photos.remove(name) != null;
    }

    public Integer getNoOfPhotos() {
        return photos.size();
    }

    public Boolean renamePhoto(String oldName, String newName) {

        if (photos.containsKey(oldName)) {
            Photo photo = photos.get(oldName);
            photo.setName(newName);
            photo.setPath("/school-project/" + newName + ".jpg");

            photos.remove(oldName);
            photos.put(newName, photo);

            return true;

        } else {
            return false;
        }
    }

    public List<Photo> getAllPhotos() {
        return new ArrayList<Photo>(photos.values());
    }

    public List<String> getAllPhotoNames() {
        return new ArrayList<String>(photos.keySet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
