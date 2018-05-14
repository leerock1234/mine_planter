package tdd.mine;

import static org.junit.Assert.*;

import org.junit.Test;

public class MineSweeperTest {

	@Test
	public void should_win_when_click_on_1x1_without_mine(){
		MineMap mineMap = new MineMap(1,1);
		
		mineMap.sweep(new Position(0,0));
		
		assertTrue(mineMap.isOpen(new Position(0,0)));
		assertTrue(mineMap.isWin());
	}
	
	@Test
	public void should_loss_when_click_on_2x2_and_hit_the_mine(){
		MineMap mineMap = new MineMap(2,2);
		mineMap.plant(new Position(0,0));
		
		mineMap.sweep(new Position(0,0));
		
		assertTrue(mineMap.isOpen(new Position(0,0)));
		assertTrue(mineMap.isLoss());
		assertFalse(mineMap.isWin());
	}
	
	@Test
	public void should_open_a_field_when_click_on_2x2_with_1_mine(){
		MineMap mineMap = new MineMap(2,2);
		mineMap.plant(new Position(0,0));
		
		mineMap.sweep(new Position(1,0));
		
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertFalse(mineMap.isLoss());
		assertFalse(mineMap.isWin());
		
		assertEquals(1, mineMap.getMineCount(new Position(1,0)));
	}
	
	@Test
	public void should_calculate_the_number_of_mine_nearby(){
		MineMap mineMap = new MineMap(2,2);
		mineMap.plant(new Position(0,0));
		mineMap.plant(new Position(0,1));
		
		mineMap.sweep(new Position(1,0));
		mineMap.sweep(new Position(1,1));
		
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertTrue(mineMap.isOpen(new Position(1,1)));
		assertFalse(mineMap.isLoss());
		assertTrue(mineMap.isWin());
		
		assertEquals(2, mineMap.getMineCount(new Position(1,0)));
		assertEquals(2, mineMap.getMineCount(new Position(1,1)));
	}

	/**
	 * 0 0 0
	 * 0 1 1
	 * 0 1 #
	 */
	@Test
	public void should_auto_open_field_with_no_mine_nearby_in_3x3_and_win_directly(){
		MineMap mineMap = new MineMap(3,3);
		mineMap.plant(new Position(2,2));

		mineMap.sweep(new Position(0,0));

		assertTrue(mineMap.isOpen(new Position(0,0)));
		assertTrue(mineMap.isOpen(new Position(0,1)));
		assertTrue(mineMap.isOpen(new Position(0,2)));
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertTrue(mineMap.isOpen(new Position(2,0)));
		assertTrue(mineMap.isOpen(new Position(1,1)));
		assertTrue(mineMap.isOpen(new Position(1,2)));
		assertTrue(mineMap.isOpen(new Position(2,1)));
		assertFalse(mineMap.isOpen(new Position(2,2)));

		assertFalse(mineMap.isLoss());
		assertTrue(mineMap.isWin());
	}

	/**
	 * 0 0 1 -
	 * 0 1 2 #
	 * 0 1 # -
	 */
	@Test
	public void should_auto_open_field_with_no_mine_nearby_in_3x4_and_not_win_directly(){
		MineMap mineMap = new MineMap(3,4);
		mineMap.plant(new Position(2,2));
		mineMap.plant(new Position(1,3));

		mineMap.sweep(new Position(0,0));

		assertTrue(mineMap.isOpen(new Position(0,0)));
		assertTrue(mineMap.isOpen(new Position(0,1)));
		assertTrue(mineMap.isOpen(new Position(0,2)));
		assertFalse(mineMap.isOpen(new Position(0,3)));
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertTrue(mineMap.isOpen(new Position(1,1)));
		assertTrue(mineMap.isOpen(new Position(1,2)));
		assertFalse(mineMap.isOpen(new Position(1,3)));
		assertTrue(mineMap.isOpen(new Position(2,0)));
		assertTrue(mineMap.isOpen(new Position(2,1)));
		assertFalse(mineMap.isOpen(new Position(2,2)));
		assertFalse(mineMap.isOpen(new Position(2,3)));

		assertFalse(mineMap.isLoss());
		assertFalse(mineMap.isWin());
	}
}
