package dk.cphbusiness.mal2;

import dk.cphbusiness.mal.utils.FileUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting implements Algorithms{
    @Override
    public List<String> selection() {
        String[] strings = new String[0];
        String path1 = "E:\\software-udvikling-anden-semester\\selection-insertion-MAL\\data\\shakespeare-complete-works.txt";
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

    public static void main(String[] args) {
        Sorting sort = new Sorting();
        List<String> sort2 = sort.selection();
        for (int i = 0; i < sort2.size(); i++) {
            System.out.println(sort2.size());
            System.out.println(sort2.get(i));
        }
    }
}
