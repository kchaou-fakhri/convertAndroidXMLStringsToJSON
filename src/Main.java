import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{

            Scanner scanner = new Scanner(System.in);
            System.out.println("Salem !\nWhat is the file (name without .xml): ");
            String inputFilename = scanner.next();
            System.out.println("\nWhat do you want the file name to be : ");
            String outputFilename = scanner.next();

            Reader.readFile("input/"+inputFilename+".xml", outputFilename);

            System.out.println("Done");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
