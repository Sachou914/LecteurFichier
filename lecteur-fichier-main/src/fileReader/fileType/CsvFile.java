package fileReader.fileType;

import fileReader.myFileReader.MyFilesReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvFile extends MyFilesReader {
    private String espace = ";";
    private String espaceCsv = " | ";

    public CsvFile(String path) {
        super(path);
    }
    public CsvFile(String path, String espace, String separatorForDisplay) {
        super(path);
        this.espace = espace;
        this.espaceCsv = espaceCsv;
    }

    public CsvFile(String path, String separator) {
        super(path);
        this.espace = espace;
    }


    public String getSeparator() {
        return espace;
    }


    public String getSeparatorForDisplay() {
        return espaceCsv;
    }


    public void setSeparator(String separator) {
        this.espace =  separator;
    }


    public void setSeparatorForDisplay(String separatorForDisplay) {
        this.espaceCsv = espaceCsv;
    }

    public String replaceSeparator(String stringToReplace) {
        return stringToReplace.replace(this.getSeparator(), this.getSeparatorForDisplay());
    }

    @Override
    public void Lecture() {
        this.openFile();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = replaceSeparator(line);

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
                fichier.add(replaceSeparator(line));
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
                line = replaceSeparator(line);

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

    public void FichierCompare(CsvFile file) {
        FichierCompare(file, true);
    }

    public void FichierCompare(CsvFile file, boolean showDiff) {
        this.openFile();
        file.openFile();

        ArrayList<String> fichier1 = new ArrayList<>();
        ArrayList<String> fichier2 = new ArrayList<>();

        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(this.getFile()));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(file.getFile()))) {

            String ligne1, ligne2;

            while ((ligne1 = br1.readLine()) != null && (ligne2 = br2.readLine()) != null) {
                fichier1.add(replaceSeparator(ligne1));
                fichier2.add(replaceSeparator(ligne2));
            }


            this.compareLinesDiff(fichier1, fichier2, showDiff);

        } catch (Exception e) {
            e.getStackTrace();
        }


        this.closeFile();
        file.closeFile();
    }
}
