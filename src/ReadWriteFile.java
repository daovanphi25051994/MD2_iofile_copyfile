import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {
    public void copyFileText(String baseFilePath, String copyFilePath) {
        try {
            File baseFile = new File(baseFilePath);
            FileWriter copyFile = new FileWriter(copyFilePath);
            if (!baseFile.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(baseFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                copyFile.write(line);
            }
            bufferedReader.close();
            copyFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("file khong ton tai !!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap path of base file : ");
        String baseFilePath = scanner.nextLine();
        System.out.println("nhap path of copy file : ");
        String copyFilePath = scanner.nextLine();
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.copyFileText(baseFilePath, copyFilePath);
    }
}
