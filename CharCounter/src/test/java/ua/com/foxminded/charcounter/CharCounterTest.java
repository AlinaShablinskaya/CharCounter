package ua.com.foxminded.charcounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import ua.com.foxminded.charcounter.provider.CounterProvider;
import ua.com.foxminded.charcounter.provider.CounterViewProvider;
import ua.com.foxminded.charcounter.validator.CounterValidator;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CharCounterTest {
    
    @Mock
    private CounterProvider counterProvider;
    
    @Mock
    private CounterViewProvider counterViewProvider;
    
    @Mock
    private CounterValidator counterValidator;
    
    @InjectMocks 
    private CharCounter charCounter;
    
    @Test
    void uniqueCharactersCounterShouldReturnResultIfSentenceContainsOneWord() {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        charCount.put('H', 1);
        charCount.put('e', 1);
        charCount.put('l', 2);
        charCount.put('o', 1);
        
        String expected = "\"H\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 2\n" +
                "\"o\" - 1\n";
        
        when(counterProvider.countCharacters("Hello")).thenReturn(charCount);
        when(counterViewProvider.provideView(charCount)).thenReturn(expected);
        
        String actual = charCounter.uniqueCharactersCounter("Hello");
        assertThat(expected, is(equalTo(actual)));   
    }
    
    @Test
    void uniqueCharactersCounterShouldReturnResultIfSentenceContainsTwoWord() {
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
        
        when(counterProvider.countCharacters("Hello World")).thenReturn(charCount);
        when(counterViewProvider.provideView(charCount)).thenReturn(expected);
        
        String actual = charCounter.uniqueCharactersCounter("Hello World");
        assertThat(expected, is(equalTo(actual)));   
    }
    
    @Test
    void uniqueCharactersCounterShouldReturnResultIfSentenceContainsLettersAndNotLetters() {
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
        
        when(counterProvider.countCharacters("Hello11235")).thenReturn(charCount);
        when(counterViewProvider.provideView(charCount)).thenReturn(expected);
        
        String actual = charCounter.uniqueCharactersCounter("Hello11235");
        assertThat(expected, is(equalTo(actual)));   
    }
    
    @Test
    void uniqueCharactersCounterShouldReturnIllegalArgumentExceptionIfSentenceIsNull() {
        
        String expected = "sentence is null";
        doThrow(new IllegalArgumentException(expected)).when(counterValidator).validateSentence(null);
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> charCounter.uniqueCharactersCounter(null));
        String actual = exeption.getMessage();
        
        assertThat(expected, is(equalTo(actual)));  
    }
    
    @Test
    void uniqueCharactersCounterShouldReturnIllegalArgumentExceptionIfSentenceIsEmpty() {
        
        String expected = "sentence is empty or blank";
        doThrow(new IllegalArgumentException(expected)).when(counterValidator).validateSentence("");
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> charCounter.uniqueCharactersCounter(""));
        String actual = exeption.getMessage();
        
        assertThat(expected, is(equalTo(actual)));  
    }
}
