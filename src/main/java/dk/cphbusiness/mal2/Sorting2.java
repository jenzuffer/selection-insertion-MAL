package dk.cphbusiness.mal2;

import dk.cphbusiness.mal.utils.Stopwatch;
import kotlin.NotImplementedError;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Sorting2 implements Algorithms {

    String path1 = "C:\\Users\\Tiba\\Desktop\\math algo\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
    private String path = "E:\\software-udvikling-anden-semester\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
    private String delimiterPattern = "[^A-Za-z']+";


    @Override
    public List<String> selection() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(inputStream, "UTF-8");
        List<String> stringList = new ArrayList<>();
        try (Stopwatch sw = new Stopwatch()) {
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                final String[] split = line.split(delimiterPattern);
                List<String> localStrings = new ArrayList<>();
                for (String strSplit : split) {
                    String s = strSplit.toLowerCase();
                    s = s.replaceAll("\\p{Punct}", "");
                    s = s.trim();
                    if (s != null && !s.isEmpty()) {
                        localStrings.add(s);
                    }
                }
                for (int i = 0; i < localStrings.size() - 1; i++) {
                    int index = i;
                    for (int j = i + 1; j < localStrings.size(); j++) {
                        String s = localStrings.get(j);
                        String s1 = localStrings.get(index);
                        if (s.compareTo(s1) < 0) {
                            index = j;
                        }
                    }
                    String string = localStrings.get(index);
                    localStrings.set(index, localStrings.get(i));
                    localStrings.set(i, string);
                }
                for (int i = 0; i < localStrings.size(); i++) {
                    stringList.add(localStrings.get(i));
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
            System.out.println("finished with sw time: ");
        }
        return stringList;
    }

    @Override
    public List<String> selectionTakingAList(List<String> list) {
        throw new NotImplementedError();
    }


    public static void main(String[] args) {
        Sorting2 sorting2 = new Sorting2();
        List<String> selection = sorting2.selection();
        System.out.println("selection size: " + selection.size());
        System.out.println(selection);
        /*for (String str : selection) {
            System.out.println(str);
        } */
    }
}
