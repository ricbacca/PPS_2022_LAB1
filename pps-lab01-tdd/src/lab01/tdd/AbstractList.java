package lab01.tdd;

import java.util.ArrayList;
import java.util.Optional;

public abstract class AbstractList implements List {

    protected final ArrayList<Integer> array;
    protected int actualPosition;

    public AbstractList() {
        reset();
        this.array = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.array.add(element);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public abstract int next();

    @Override
    public abstract int previous();

    @Override
    public abstract void reset();

    @Override
    public abstract Optional<Integer> next(SelectStrategy strategy);
}
