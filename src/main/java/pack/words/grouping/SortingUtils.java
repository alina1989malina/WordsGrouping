package pack.words.grouping;

import java.util.Collections;
import java.util.List;

public class SortingUtils {
    public static void sortWordsList(List<String> words){
        Collections.sort(words, (a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            else
                return b.length() - a.length();
        });
    }
}
