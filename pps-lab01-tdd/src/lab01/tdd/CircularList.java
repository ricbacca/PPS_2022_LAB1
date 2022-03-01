package lab01.tdd;

import java.util.Optional;

public class CircularList extends AbstractList {
    private int stepsCounter;

    @Override
    public Optional<Integer> next() {
        if(isEmpty())
            return Optional.empty();
        stepsCounter++;
        if(actualPosition < size()-1) actualPosition++; else actualPosition = 0;
        return Optional.of(array.get(calculatePosition()));
    }

    private int calculatePosition(){
        if(actualPosition == 1 && stepsCounter == 1) actualPosition--;
        return actualPosition;
    }

    @Override
    public Optional<Integer> previous() {
        if(isEmpty())
            return Optional.empty();
        if(actualPosition > 0) actualPosition--; else actualPosition = size()-1;
        return Optional.of(array.get(actualPosition));
    }

    @Override
    public void reset() {
        this.stepsCounter = 0;
        this.actualPosition = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for(int i=0; i<size(); i++){
            Optional<Integer> element = next();
            if(element.isPresent() && strategy.apply(element.get())) return element;
        }
        return Optional.empty();
    }
}
