package com.cherkasov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cache {
    private String test = "test";

    static void test(List<Integer> list){
        System.out.println(list.toArray());

        list.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cache cache = (Cache) o;

        return test != null ? test.equals(cache.test) : cache.test == null;
    }

    @Override
    public int hashCode() {
        return test != null ? test.hashCode() : 0;
    }

    public static void main(String[] args) {
    Test.test(Collections.emptyList());
    }
}
class Test extends Cache{
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new Cache().hashCode());
        }

        Test.test(list);
    }
}