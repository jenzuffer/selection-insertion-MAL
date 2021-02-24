package dk.cphbusiness.mal2;

import kotlin.NotImplementedError;

import java.util.Arrays;
import java.util.List;

public class InsertSorting implements Algorithms {

    @Override
    public List<String> selection() {
        throw new NotImplementedError();
    }

    @Override
    public List<String> selectionTakingAList(List<String> stringList ) {

        if(stringList.size() <=1) return stringList;

        int i, j ;
        String temp;
        for (i = 1; i < stringList.size(); i++) {
            j = i-1;
            temp = stringList.get(i);
            while(j>=0 && stringList.get(j).compareTo(temp) > 0){
                stringList.set(j+1, stringList.get(j));
                j--;
            }
                stringList.set(j+1,temp);
            }
        return stringList;
        }

    }

