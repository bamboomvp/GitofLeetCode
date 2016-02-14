package baodavi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<String, List<String>> bookTable = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if (bookTable.containsKey(key)) {
                bookTable.get(key).add(strs[i]);
            } else {
                List<String> newElem = new ArrayList<String>();
                newElem.add(strs[i]);
                bookTable.put(key, newElem);
            }
        }

        for (List<String> elem : bookTable.values()) {
            if (elem.size() > 1) {
                res.addAll(elem);
            }
        }

        return res;
    }
}
