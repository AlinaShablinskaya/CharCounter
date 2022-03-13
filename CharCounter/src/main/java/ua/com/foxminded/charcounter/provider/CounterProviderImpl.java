package ua.com.foxminded.charcounter.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class CounterProviderImpl implements CounterProvider{

    @Override
    public Map<Character, Integer> countCharacters(String sentence) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        sentence.chars().forEach(element -> result.merge((char) element, 1, Integer::sum));
        return result;
    } 
}
