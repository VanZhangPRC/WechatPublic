import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestNothing {

    @Test
    public void testNormalMap() {
        HashMap<String, String> map1 = new HashMap<>();
        System.out.println("---------- HashMap -----------");
        System.out.println(map1.putIfAbsent("key", "value"));
        System.out.println(map1.putIfAbsent("key", "value2"));
        System.out.println(map1.putIfAbsent("key", "value3"));

        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
        System.out.println("---------- ConcurrentHashMap -----------");
        System.out.println(map2.putIfAbsent("key", "value"));
        System.out.println(map2.putIfAbsent("key", "value2"));
        System.out.println(map2.putIfAbsent("key", "value3"));

    }

}
