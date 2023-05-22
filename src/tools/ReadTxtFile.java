package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadTxtFile {

    public static ArrayList<String> read(String path) {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            if (!file.createNewFile()) {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }

                bufferedReader.close();
                fileReader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

}
