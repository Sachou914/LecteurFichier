package fileReader;

import fileReader.fileType.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String baseDir = System.getProperty("user.dir") + "/src/fileReader/doc/";


        TextFile fileText = new TextFile(baseDir + "texte1.txt");
        TextFile fileTextCompare = new TextFile(baseDir + "texte2.txt");
        TextFile fileTextIdentical = new TextFile(baseDir + "texte2.txt");


        CsvFile fileCsv = new CsvFile(baseDir + "texte1.csv");
        CsvFile fileCsvCompare = new CsvFile(baseDir + "texte2.csv");
        CsvFile fileCsvIdentical = new CsvFile(baseDir + "texte1.csv");


        System.out.println("\n Contenu du document .txt");
        fileText.Lecture();

        System.out.println("\n Contenu inversé du document .txt");
        fileText.LectureInverse();

        System.out.println("\n Contenu palindrome du document .txt");
        fileText.LecturePalindrome();

        System.out.println("\n Comparaison du contenu des documents .txt");
        fileText.FichierCompare(fileTextCompare);
        System.out.println();


        System.out.println("\n Contenu du document .csv");
        fileCsv.Lecture();

        System.out.println("\n Contenu inversé du document .csv");
        fileCsv.LectureInverse();

        System.out.println("\n Contenu palindrome du document .csv");
        fileCsv.LecturePalindrome();

        System.out.println("\n Comparaison du contenu des documents .csv");
        fileCsv.FichierCompare(fileCsvCompare);
        System.out.println();
    }
}