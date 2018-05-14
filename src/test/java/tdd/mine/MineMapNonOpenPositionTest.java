package tdd.mine;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class MineMapNonOpenPositionTest {

    @Test
    public void should_be_all_around_in_the_middle_of_3x3(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getNonOpenPositions(new Position(1,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,0));
        expected.add(new Position(0,1));
        expected.add(new Position(0,2));
        expected.add(new Position(1,0));
        expected.add(new Position(1,2));
        expected.add(new Position(2,0));
        expected.add(new Position(2,1));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_not_be_affected_even_has_mine(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(0,0));

        Set<Position> positions = mineMap.getNonOpenPositions(new Position(1,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,0));
        expected.add(new Position(0,1));
        expected.add(new Position(0,2));
        expected.add(new Position(1,0));
        expected.add(new Position(1,2));
        expected.add(new Position(2,0));
        expected.add(new Position(2,1));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_be_affected_if_one_field_is_open(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(0,1));
        mineMap.sweep(new Position(0,0));

        Set<Position> positions = mineMap.getNonOpenPositions(new Position(1,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,1));
        expected.add(new Position(0,2));
        expected.add(new Position(1,0));
        expected.add(new Position(1,2));
        expected.add(new Position(2,0));
        expected.add(new Position(2,1));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_non_include_boarder(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(0,1));
        mineMap.sweep(new Position(0,0));

        Set<Position> positions = mineMap.getNonOpenPositions(new Position(1,0));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,1));
        expected.add(new Position(1,1));
        expected.add(new Position(2,0));
        expected.add(new Position(2,1));
        assertEquals(expected, positions);
    }
}
