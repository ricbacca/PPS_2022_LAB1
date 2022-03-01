import lab01.tdd.CircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CircularListTest extends AbstractListTest {

    @Override
    @BeforeEach
    public void beforeEach(){
        this.list = new CircularList();
    }

    @Override
    @Test
    public void testCanGetNextElement(){
        addTestElements(1,5);
        assertEquals(makeExpectedArray(new int[]{1,2}), makeNextCalls(2));
    }

    @Override
    @Test
    public void testCanGetPreviousElement(){
        addTestElements(1,5);
        assertEquals(makeExpectedArray(new int[]{4,3}), makePreviousCalls(2));
    }

    /**
     * Inserting into list values: [1,2,3,4]
     * Making 2 moves forward and 4 backwards
     */
    @Test
    public void testCanMoveAcrossList(){
        addTestElements(1,5);
        assertEquals(makeExpectedArray(new int[]{1,2,1,4,3,2}), Stream.of(makeNextCalls(2), makePreviousCalls(4))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    /**
     * Moving 2 step forward and reset position counter
     */
    @Test
    public void testCanReturnHome(){
        addTestElements(1,5);
        makeNextCalls(2);
        list.reset();
        assertEquals(makeExpectedArray(new int[]{1,4}), Stream.of(makeNextCalls(1), makePreviousCalls(1))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

    }

    /**
     * The selected filter choose "even" elements
     */
    @Override
    @Test
    public void testCanGetElementWithFilter(){
        ArrayList<Optional<Integer>> result = new ArrayList<>();
        addTestElements(1,5);
        for(int i=0; i<4; i++){
            result.add(list.next(element -> element % 2 == 0));
        }
        assertEquals(makeExpectedArray(new int[]{2,4,2,4}), result);
    }


}
