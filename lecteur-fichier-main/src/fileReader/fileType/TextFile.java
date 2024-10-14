package fileReader.fileType;

import fileReader.myFileReader.MyFilesReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextFile extends MyFilesReader {
    public TextFile(String path) {
        super(path);
    }

    @Override
    public void Lecture() {
        this.openFile();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        this.closeFile();
    }


    @Override
    public void LectureInverse() {
        this.openFile();

        ArrayList<String> fichier = new ArrayList<String>();
        ArrayList<String> fichierInverse = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                fichier.add(line);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (int i = fichier.size() - 1; i >= 0; i--) {
            fichierInverse.add(fichier.get(i));
        }

        for (String bufferedLine : fichierInverse) {
            System.out.println(bufferedLine);
        }

        this.closeFile();
    }


    @Override
    public void LecturePalindrome() {
        this.openFile();

        ArrayList<String> fichier = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();

                fichier.add(reversedLine);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        for (String bufferedLine : fichier) {
            System.out.println(bufferedLine);
        }

        this.closeFile();
    }

    public void FichierCompare(TextFile file) {
        FichierCompare(file, true);
    }

    public void FichierCompare(TextFile file, boolean showDiff) {
        this.openFile();
        file.openFile();
        ArrayList<String> fichier1 = new ArrayList<>();
        ArrayList<String> fichier2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String ligne1, ligne2;

            while ((ligne1 = br1.readLine()) != null && (ligne2 = br2.readLine()) != null) {
                fichier1.add(ligne1);
                fichier2.add(ligne2);
            }

            this.compareLinesDiff(fichier1, fichier2, showDiff);

        } catch (Exception e) {
            e.getStackTrace();
        }
        this.closeFile();
        file.closeFile();
    }
}
