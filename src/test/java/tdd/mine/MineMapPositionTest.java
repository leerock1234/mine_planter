package tdd.mine;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class MineMapPositionTest {

    @Test
    public void should_get_relative_positions_in_middle_place(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(1,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,0));
        expected.add(new Position(1,0));
        expected.add(new Position(2,0));
        expected.add(new Position(0,1));
        expected.add(new Position(2,1));
        expected.add(new Position(0,2));
        expected.add(new Position(1,2));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_get_relative_positions_in_left_place(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(0,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,0));
        expected.add(new Position(1,0));
        expected.add(new Position(1,1));
        expected.add(new Position(0,2));
        expected.add(new Position(1,2));
        assertEquals(expected, positions);


    }

    @Test
    public void should_get_relative_positions_in_top_place(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(1,0));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,0));
        expected.add(new Position(2,0));
        expected.add(new Position(1,1));
        expected.add(new Position(2,1));
        expected.add(new Position(0,1));
        assertEquals(expected, positions);
    }

    @Test
    public void should_get_relative_positions_in_right_place(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(2,1));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(2,0));
        expected.add(new Position(1,0));
        expected.add(new Position(1,1));
        expected.add(new Position(1,2));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_get_relative_positions_in_bottom_place(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(1,2));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(0,1));
        expected.add(new Position(1,1));
        expected.add(new Position(2,1));
        expected.add(new Position(0,2));
        expected.add(new Position(2,2));
        assertEquals(expected, positions);
    }

    @Test
    public void should_get_relative_positions_in_bottom_right_corner(){
        MineMap mineMap = new MineMap(3,3);

        Set<Position> positions = mineMap.getRelativePositions(new Position(2,2));

        Set<Position> expected = new HashSet<>();
        expected.add(new Position(1,1));
        expected.add(new Position(2,1));
        expected.add(new Position(1,2));
        assertEquals(expected, positions);
    }
}
