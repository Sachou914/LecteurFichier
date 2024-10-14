package fileReader.myFileReader;

import java.io.FileInputStream;
import java.util.ArrayList;

public interface ActionFileReader {

    public void openFile();

    public void closeFile();


    public FileInputStream getFile();


    public String getPath();
    public void compareLinesDiff(ArrayList<String> buffer1, ArrayList<String> buffer2, boolean showDiff);
}
