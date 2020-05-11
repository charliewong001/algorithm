package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map m = new HashMap();
        m.put("a", "a");
        Map m2 = new HashMap();
        m2.put("a", "a");
        System.out.println(m.equals(m2));
    }
}
