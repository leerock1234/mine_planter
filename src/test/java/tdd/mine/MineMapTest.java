package tdd.mine;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MineMapTest {
    @Test(expected = MineNotAllowHere.class)
    public void should_not_plant_one_mine_in_1x1_map() {
        MineMap mineMap = new MineMap(1,1);
        Position position = new Position(0,0);
        mineMap.plant(position);
    }

    @Test(expected = MineNotAllowOutOfMap.class)
    public void should_not_plant_mine_out_of_map_width() {
        MineMap mineMap = new MineMap(1,1);
        Position position = new Position(0,1);
        mineMap.plant(position);
    }

    @Test(expected = MineNotAllowOutOfMap.class)
    public void should_not_plant_mine_out_of_map_heigth() {
        MineMap mineMap = new MineMap(1,1);
        Position position = new Position(1,0);
        mineMap.plant(position);
    }

    @Test
    public void should_plant_one_mine() {
        MineMap mineMap = new MineMap(2,2);
        Position position = new Position(0,0);

        mineMap.plant(position);

        assertTrue(mineMap.hasMine(position));
        assertFalse(mineMap.hasMine(new Position(0,1)));
        assertFalse(mineMap.hasMine(new Position(1,0)));
        assertFalse(mineMap.hasMine(new Position(1,1)));
        assertEquals(1,mineMap.getMineCount(new Position(0,1)));
        assertEquals(1,mineMap.getMineCount(new Position(1,0)));
        assertEquals(1,mineMap.getMineCount(new Position(1,1)));
    }

    @Test
    public void should_plant_two_mine() {
        MineMap mineMap = new MineMap(2,2);

        mineMap.plant(new Position(0,0));
        mineMap.plant(new Position(0,1));

        assertTrue(mineMap.hasMine(new Position(0,0)));
        assertTrue(mineMap.hasMine(new Position(0,1)));
        assertFalse(mineMap.hasMine(new Position(1,0)));
        assertFalse(mineMap.hasMine(new Position(1,1)));
//        assertTrue(mineMap.hasMine(new Position(x:)));
        assertEquals(2,mineMap.getMineCount(new Position(1,0)));
        assertEquals(2,mineMap.getMineCount(new Position(1,1)));
    }
}
