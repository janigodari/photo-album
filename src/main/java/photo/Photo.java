package photo;

public class Photo {
    private String name;
    private String type;
    private Float size;
    private String path;

    public Photo() {
    }

    public Photo(String name, String type, Float size, String path) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public Float getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "photo.Photo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                '}';
    }
}
