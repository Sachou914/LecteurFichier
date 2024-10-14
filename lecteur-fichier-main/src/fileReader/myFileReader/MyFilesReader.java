package fileReader.myFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public abstract class MyFilesReader implements ActionFileReader {
    private final String path;
    private FileInputStream file;
    public abstract void Lecture();
    public abstract void LectureInverse();
    public abstract void LecturePalindrome();

    public MyFilesReader(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Vide");
        } else {
            this.path = path;
        }
    }


    @Override
    public void openFile() {
        File file = new File(path);
        try {
            this.file = new FileInputStream(file);
        } catch (Exception e){
            e.getStackTrace();
        }
    }


    @Override
    public void closeFile() {
        if (this.file != null) {
            try {
                this.file.close();
            } catch (Exception e){
                e.getStackTrace();
            }
        }
    }


    @Override
    public FileInputStream getFile() {
        return this.file;
    }


    @Override
    public String getPath() {
        return path;
    }


    @Override
    public void compareLinesDiff(ArrayList<String> fichier1, ArrayList<String> fichier2, boolean showDiff) {
        boolean egalite = true;
        int differences = 0;

        for (int i = 0; i < fichier1.size(); i++) {
            String ligne1 = fichier1.get(i);
            String ligne2 = fichier2.get(i);

            if (!ligne1.equals(ligne2)) {
                egalite = false;
                differences++;

                if (showDiff) {
                    System.out.println("Comparaison ligne " + (i + 1) + ":");
                    System.out.println("Fichier 1: " + ligne1);
                    System.out.println("Fichier 2: " + ligne2);
                    System.out.println();
                }
            }
        }

        if (egalite) {
            System.out.println("Les fichiers sont identiques.");
        } else {
            System.out.println("Les documents ont " + differences +" différence(s)");
        }
    }




}
