package ua.com.foxminded.charcounter.provider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CounterViewTest {
    
    private final CounterViewProvider counterViewProvider = new CounterViewImpl();

    @Test
    void countCharactersShouldReturnResultIfSentenceContainsOneWord() {
        
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        charCount.put('H', 1);
        charCount.put('e', 1);
        charCount.put('l', 2);
        charCount.put('o', 1);
        
        String expected = "\"H\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 2\n" +
                "\"o\" - 1\n";
        
        String actual = counterViewProvider.provideView(charCount);
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void countCharactersShouldReturnResultIfSentenceContainsTwoWord() {
        
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        charCount.put('H', 1);
        charCount.put('e', 1);
        charCount.put('l', 3);
        charCount.put('o', 2);
        charCount.put(' ', 1);
        charCount.put('W', 1);
        charCount.put('r', 1);
        charCount.put('d', 1);
        
        String expected = "\"H\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 3\n" +
                "\"o\" - 2\n" +
                "\" \" - 1\n" +
                "\"W\" - 1\n" +
                "\"r\" - 1\n" +
                "\"d\" - 1\n";
        
        String actual = counterViewProvider.provideView(charCount);
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void countCharactersShouldReturnResultIfSentenceContainsLettersAndNotLetters() {
        
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        charCount.put('H', 1);
        charCount.put('e', 1);
        charCount.put('l', 2);
        charCount.put('o', 1);
        charCount.put('1', 2);
        charCount.put('2', 1);
        charCount.put('3', 1);
        charCount.put('5', 1);
        
        String expected = "\"H\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 2\n" +
                "\"o\" - 1\n" +
                "\"1\" - 2\n" +
                "\"2\" - 1\n" +
                "\"3\" - 1\n" +
                "\"5\" - 1\n";
        
        String actual = counterViewProvider.provideView(charCount);
        assertThat(actual, is(equalTo(expected)));
    }
}
