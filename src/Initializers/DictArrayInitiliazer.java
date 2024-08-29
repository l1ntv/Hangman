package Initializers;

import Constants.AppConstants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictArrayInitiliazer {

    private DictArrayInitiliazer() {
    }

    public static ArrayList<String> initilizeDictArrayList(ArrayList<String> dict) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(AppConstants.DICT_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            dict.add(line.trim().toLowerCase());
        }
        return dict;
    }
}
