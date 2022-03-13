package ua.com.foxminded.charcounter.provider;

import java.util.Map;

public interface CounterProvider {
    Map<Character, Integer> countCharacters(String sentence);
}
