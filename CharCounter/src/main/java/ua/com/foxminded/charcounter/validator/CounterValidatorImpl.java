package ua.com.foxminded.charcounter.validator;

public class CounterValidatorImpl implements CounterValidator{

    @Override
    public String validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("sentence is empty or blank");
        }
        return sentence;
    }
}
