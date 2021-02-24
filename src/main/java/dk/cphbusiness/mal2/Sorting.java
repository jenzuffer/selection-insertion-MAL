package dk.cphbusiness.mal2;

import dk.cphbusiness.mal.utils.FileUtility;
import dk.cphbusiness.mal.utils.Stopwatch;
import kotlin.NotImplementedError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting implements Algorithms{
    @Override
    public List<String> selection() {
        String[] strings = new String[0];
        //String path1 = "E:\\software-udvikling-anden-semester\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
        String path = "C:\\Users\\Tiba\\Desktop\\math algo\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
        try {
            strings = FileUtility.toStringArray(path, "[^A-Za-z']+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> stringList = Arrays.asList(strings);
        for (int i = 0; i < stringList.size(); i++) {
            String str = stringList.get(i);

            for (int j = i + 1; j < stringList.size(); j++) {
                String strj = stringList.get(j);
                if (str.compareTo(strj) > 0) {
                    stringList.set(i, strj);
                    stringList.set(j, str);
                }

            }

        }
        return stringList;
    }

    @Override
    public List<String> selectionTakingAList(List<String> list) {
        throw new NotImplementedError();
    }


    public static void main(String[] args) {
        InsertSorting sorting2 = new InsertSorting();



        String[] strings = new String[0];
        String path = "C:\\Users\\Tiba\\Desktop\\math algo\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
        try {
            strings = FileUtility.toStringArray(path, "[^A-Za-z']+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> stringList = Arrays.asList(strings);
        List<String> selection = null;
        try (Stopwatch sw = new Stopwatch()) {

        selection = sorting2.selectionTakingAList(stringList);
        }
        System.out.println("selection size: " + selection.size());
        System.out.println(selection);
        /*for (String str : selection) {
            System.out.println(str);
        } */
    }


}
