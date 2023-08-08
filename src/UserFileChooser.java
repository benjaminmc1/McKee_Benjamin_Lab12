import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class UserFileChooser {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int chrCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        Scanner inFile = null;
        File selectedFile = null;
        JFileChooser chooser = new JFileChooser();

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            inFile = new Scanner(selectedFile);
        }

        while(inFile.hasNext()) {
            String tmpStr = inFile.nextLine();
            if(!tmpStr.equalsIgnoreCase("")) {
                String replaceAll = tmpStr.replaceAll("\\s+", "");
                chrCount += replaceAll.length();
                wordCount += tmpStr.split(" ").length;
            }
            ++lineCount;
        }

        System.out.println("This is a summary of the file you chose: ");
        System.out.println("The name of the file you chose is: " + selectedFile.getName());
        System.out.println("The amount of lines in the file: " + lineCount);
        System.out.println("The number of words in the file: " + wordCount);
        System.out.println("The number of characters in the file: " + chrCount);
        
        inFile.close();
    }
}