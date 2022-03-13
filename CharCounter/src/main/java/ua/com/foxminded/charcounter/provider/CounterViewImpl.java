package ua.com.foxminded.charcounter.provider;

import java.util.Map;

public class CounterViewImpl implements CounterViewProvider{

    @Override
    public String provideView(Map<Character, Integer> result) {
        StringBuilder builder = new StringBuilder();
        result.forEach((key, value) -> builder.append(String.format("\"%s\" - %d%n", key, value)));
        return builder.toString();
    }
}
