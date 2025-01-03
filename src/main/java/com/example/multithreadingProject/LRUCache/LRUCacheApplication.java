package com.example.multithreadingProject.LRUCache;

public class LRUCacheApplication {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(4);

        cache.put(1, "Value 1");
        cache.put(2, "Value 2");
        cache.put(3, "Value 3");
        cache.put(4, "Value 4");

        System.out.println(cache.get(1));
        cache.put(5, "Value 5");

        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
