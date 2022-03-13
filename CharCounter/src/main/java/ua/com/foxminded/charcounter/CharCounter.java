package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

import ua.com.foxminded.charcounter.provider.CounterProvider;
import ua.com.foxminded.charcounter.provider.CounterViewProvider;
import ua.com.foxminded.charcounter.validator.CounterValidator;

public class CharCounter {
    private final CounterProvider counterProvider;
    private final CounterViewProvider counterViewProvider;
    private final CounterValidator counterValidator;
    
    public CharCounter(CounterProvider counterProvider, CounterViewProvider counterViewProvider,
            CounterValidator counterValidator) {
        this.counterProvider = counterProvider;
        this.counterViewProvider = counterViewProvider;
        this.counterValidator = counterValidator;
    }

    public String uniqueCharactersCounter(String sentence) {
        
        Map<String, String> cache = new HashMap<>();
        counterValidator.validateSentence(sentence);
        
        if(cache.containsKey(sentence)) {
            return cache.get(sentence);
        }
        
        Map<Character, Integer> countUniqueCharacters = counterProvider.countCharacters(sentence);
        String result = counterViewProvider.provideView(countUniqueCharacters);
        cache.put(sentence, result);
        return result;
        }
    }
