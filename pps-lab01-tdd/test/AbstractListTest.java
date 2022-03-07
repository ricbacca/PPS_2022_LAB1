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

    protected List makeExpectedArray(final int[] elements){
        List expected = (List) new ArrayList<Optional<Integer>>();
        stream(elements).forEach(expected::add);
        return expected;
    }

    protected List makeNextCalls(final int number){
        List result = (List) new ArrayList<Optional<Integer>>();
        for(int i=0; i<number; i++){
            result.add(list.next());
        }
        return result;
    }

    protected List makePreviousCalls(final int number){
        List result = (List) new ArrayList<Optional<Integer>>();
        for(int i=0; i<number; i++){
            result.add(list.previous());
        }
        return result;
    }
}
