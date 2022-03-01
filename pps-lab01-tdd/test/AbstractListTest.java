import lab01.tdd.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractListTest {

    protected List list;

    @BeforeEach
    public abstract void beforeEach();

    @Test
    public void testInitiallyEmpty(){
        assertTrue(this.list.isEmpty());
    }

    @Test
    public abstract void testCanGetNextElement();

    @Test
    public abstract void testCanGetPreviousElement();

    @Test
    public abstract void testCanGetElementWithFilter();

    @Test
    public void testCanAddElement(){
        addTestElements(0,1);
        assertEquals(1, list.size());
    }


    protected void addTestElements(final int start, final int stop) {
        for(int i=start; i<stop; i++){
            list.add(i);
        }
    }

    protected ArrayList<Optional<Integer>> makeExpectedArray(final int[] elements){
        ArrayList<Optional<Integer>> expected = new ArrayList<>();
        stream(elements).forEach(x -> expected.add(Optional.of(x)));
        return expected;
    }

    protected ArrayList<Optional<Integer>> makeNextCalls(final int number){
        ArrayList<Optional<Integer>> result = new ArrayList<>();
        for(int i=0; i<number; i++){
            result.add(list.next());
        }
        return result;
    }

    protected ArrayList<Optional<Integer>> makePreviousCalls(final int number){
        ArrayList<Optional<Integer>> result = new ArrayList<>();
        for(int i=0; i<number; i++){
            result.add(list.previous());
        }
        return result;
    }
}
