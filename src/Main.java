import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String data = "I love Pakistan";

        try {
            FileOutputStream fos = new FileOutputStream("myFile.txt");
            byte[] byteData = data.getBytes();
            fos.write(byteData);
            fos.close();
            System.out.println("Data successfully written to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
