package tdd.mine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MineMapCriticalPositionTest {

	@Test
	public void should_not_be_critical_if_is_not_surrounded(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(0,0));
        mineMap.plant(new Position(0,1));
        mineMap.plant(new Position(0,2));
        mineMap.plant(new Position(1,0));
        mineMap.plant(new Position(1,2));
        mineMap.plant(new Position(2,0));

        assertFalse(mineMap.isCriticalPosition(new Position(2,2)));
	}

	@Test
	public void should_be_critical_if_is_nearly_not_surrounded_by_mine(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(0,0));
        mineMap.plant(new Position(0,1));
        mineMap.plant(new Position(0,2));
        mineMap.plant(new Position(1,0));
        mineMap.plant(new Position(1,2));
        mineMap.plant(new Position(2,0));
        mineMap.plant(new Position(2,1));

        assertTrue(mineMap.isCriticalPosition(new Position(2,2)));
	}

	@Test
	public void should_be_critical_if_is_nearly_not_surrounded_by_mine_or_border(){
        MineMap mineMap = new MineMap(3,3);
        mineMap.plant(new Position(1,0));
        mineMap.plant(new Position(1,1));

        assertTrue(mineMap.isCriticalPosition(new Position(0,0)));
	}
}
