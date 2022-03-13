import file.PhotoAlbumFileReader;
import file.PhotoAlbumFileWriter;
import photo.Photo;
import photo.PhotoAlbum;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String filename = "src/main/resources/photos.cvs";
    private static PhotoAlbumFileWriter photoAlbumFileWriter;
    private static PhotoAlbumFileReader photoAlbumFileReader;
    private static PhotoAlbum photoAlbum;

    public static void main(String[] args) throws IOException {
        photoAlbumFileWriter = new PhotoAlbumFileWriter(filename);
        photoAlbumFileReader = new PhotoAlbumFileReader(filename);
        photoAlbum = new PhotoAlbum(photoAlbumFileReader.readPhotosFile());

        getMenuOption();
        writePhotosToDisk();
    }

    private static int startMenu(){
        System.out.println("<<<<< Hello! Welcome to Photo Album >>>>>");
        System.out.println("Press: \n" +
                "1: View all photos in the album\n" +
                "2: Add photos to the album\n" +
                "3: Rename a photo in the album\n" +
                "4: Delete a photo from the album\n" +
                "5: Search a photo");
        System.out.print("Write your choice: ");
        return scanner.nextInt();
    }
    private static void getMenuOption() throws IOException {
        int optionSelected = startMenu();
        boolean validOption = false;
        while (!validOption){
            switch (optionSelected){
                case 1:
                    showAllPhotos();
                    validOption = true;
                    break;
                case 2:
                    addPhoto();
                    validOption = true;
                    break;
                case 3:
                    renamePhoto();
                    validOption = true;
                    break;
                case 4:
                    deletePhoto();
                    validOption = true;
                    break;
                case 5:
                    searchPhoto();
                    validOption = true;
                    break;
                default:
                    optionSelected = startMenu();
                    startMenu();
                    break;
            }
        }
    }
    private static void showAllPhotos() {
        System.out.println("\n\n");
        System.out.println("NAME"+ " | " + "TYPE" + " | " + "SIZE" + " | " + "PATH" + " \r");
        photoAlbum.getAllPhotos().forEach(photo -> {
            System.out.println(photo.getName() + "." + photo.getType()
                    + "  " + photo.getSize() + "MB" + "   " + photo.getPath());
        });

        pressAnyKeyToContinue();

    }
    private static void addPhoto() throws IOException {
        Photo photo = new Photo();

        System.out.print("Enter the photo name: ");
        String name = scanner.next();
        photo.setName(name);
        scanner.nextLine();

        System.out.print("Enter photo type: ");
        String type = scanner.next();
        photo.setType(type);

        photo.setPath("/school-project/"+ name + ".jpg");
        photo.setSize(12F);

        photoAlbum.addPhoto(photo);

        System.out.println("Photo Added");

        writePhotosToDisk();
        pressAnyKeyToContinue();
    }
    private static void renamePhoto() throws IOException {
        System.out.print("Enter the photo name: ");
        String photoName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the new photo name: ");
        String photoNewName = scanner.next();
        if (!photoAlbum.checkPhotoInList(photoName)){
            System.out.println("Photo not found");
           pressAnyKeyToContinue();
        }else{
            photoAlbum.renamePhoto(photoName, photoNewName);
            System.out.println("Photo renamed successfully");
            writePhotosToDisk();
            pressAnyKeyToContinue();
        }
    }
    private static void deletePhoto() throws IOException {
        System.out.print("Enter the name of the photo you want to delete: ");
        String photoName = scanner.next();
        scanner.nextLine();
        if (!photoAlbum.checkPhotoInList(photoName)){
            System.out.println("Photo not found in the album");
            pressAnyKeyToContinue();
        }else{
            photoAlbum.deletePhoto(photoName);
            System.out.println("Photo successfully deleted");
            writePhotosToDisk();
            pressAnyKeyToContinue();
        }
    }
    private static void searchPhoto(){
        System.out.print("Enter photo name: ");
        String photoName = scanner.next();
        if (photoAlbum.checkPhotoInList(photoName)){
            System.out.println("Photo exists.....");
            Photo searchPhoto = photoAlbum.getPhoto(photoName);
            System.out.println(searchPhoto.getName() + "." +
                    searchPhoto.getType() + " " +
                    searchPhoto.getSize() + "mb "  +
                    searchPhoto.getPath());

        }else{
            System.out.println("Photo does not exist");
        }
        pressAnyKeyToContinue();
    }
    private static void writePhotosToDisk() throws IOException {
        photoAlbumFileWriter.writePhotos(photoAlbum.getAllPhotos());
    }
    private static void pressAnyKeyToContinue(){
        System.out.println("Press the Enter key to go to menu...");
        try{
            System.in.read();
            System.out.print("\033\143");
            getMenuOption();
        }catch(Exception e){

        }
    }

}
