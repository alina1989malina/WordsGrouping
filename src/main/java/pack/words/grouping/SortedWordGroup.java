package pack.words.grouping;

import java.util.*;
import java.util.stream.Collectors;

import static pack.words.grouping.SortingUtils.sortWordsList;

public class SortedWordGroup {
    private Map<Character, List<String>> groups = new TreeMap<>();

    public SortedWordGroup(String data){
        parse(data);
    }

    private void parse(String data){
        List<String> words = Arrays.asList(Optional.ofNullable(data).orElse("").toLowerCase().replaceAll("\n", "").
                split(" +")).stream().filter(s -> s.length() > 0).collect(Collectors.toList());

        words.forEach(word -> {
            Character firstLetter = word.charAt(0);
            if (!groups.containsKey(firstLetter)) {
                groups.put(firstLetter, new ArrayList<>(Arrays.asList(word)));
            }
            else {
                groups.get(firstLetter).add(word);
            }
        });
        removeGroupsWithOneElement();
        sortGroups();
    }

    private void removeGroupsWithOneElement(){
        groups.entrySet().removeIf(entry -> entry.getValue().size() <= 1);
    }

    private void sortGroups(){
        groups.forEach((k,v) -> sortWordsList(v));
    }

    @Override
    public String toString(){
        return groups.toString();
    }

}


