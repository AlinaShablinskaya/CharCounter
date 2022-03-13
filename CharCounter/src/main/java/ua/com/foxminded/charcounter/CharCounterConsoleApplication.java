package ua.com.foxminded.charcounter;

import ua.com.foxminded.charcounter.provider.CounterProvider;
import ua.com.foxminded.charcounter.provider.CounterProviderImpl;
import ua.com.foxminded.charcounter.provider.CounterViewImpl;
import ua.com.foxminded.charcounter.provider.CounterViewProvider;
import ua.com.foxminded.charcounter.validator.CounterValidator;
import ua.com.foxminded.charcounter.validator.CounterValidatorImpl;

public class CharCounterConsoleApplication {
    
    public static void main( String[] args ) {
        
       CounterProvider counterProvider = new CounterProviderImpl();
       CounterViewProvider counterViewProvider = new CounterViewImpl();
       CounterValidator counterValidator = new CounterValidatorImpl();
       CharCounter charCounter = new CharCounter(counterProvider, counterViewProvider, counterValidator);
       
       System.out.println(charCounter.uniqueCharactersCounter("Hello World"));
    }
}
