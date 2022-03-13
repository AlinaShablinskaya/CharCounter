package ua.com.foxminded.charcounter.validator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CounterValidatorTest {
    
    private final CounterValidator counterValidator = new CounterValidatorImpl();

    @Test
    void validateSentenceShouldReturnIllegalArgumentExceptionIfSentenceIsNull() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> counterValidator.validateSentence(null));
        
        String expected = "sentence is null";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateSentenceShouldReturnIllegalArgumentExceptionIfSentenceIsEmpty() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, 
                () -> counterValidator.validateSentence(""));
        
        String expected = "sentence is empty or blank";
        String actual = exeption.getMessage();
        
        assertThat(actual, is(equalTo(expected)));
    }
    
    @Test
    void validateSentenceShouldNotReturnException() {
        
        assertDoesNotThrow(() -> counterValidator.validateSentence("Hello World"));
    }
}
