package ua.com.foxminded.charcounter.provider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CounterProviderTest {
    
    private final CounterProvider counterProvider = new CounterProviderImpl();
    
    @Test
    void countCharactersShouldReturnResultIfSentenceContainsOneWord() {
        
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);
        
        Map<Character, Integer> actual = counterProvider.countCharacters("Hello");
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    void countCharactersShouldReturnResultIfSentenceContainsTwoWord() {
        
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('W', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        
        Map<Character, Integer> actual = counterProvider.countCharacters("Hello World");
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void countCharactersShouldReturnResultIfSentenceContainsLettersAndNotLetters() {
        
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);
        expected.put('1', 2);
        expected.put('2', 1);
        expected.put('3', 1);
        expected.put('5', 1);
        
        Map<Character, Integer> actual = counterProvider.countCharacters("Hello11235");
        assertThat(actual, is(equalTo(expected)));
    }
}
