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
	public void should_loss_when_click_on_2x2_with_1_mine(){
		MineMap mineMap = new MineMap(2,2);
		mineMap.plant(new Position(0,0));
		
		mineMap.sweep(new Position(1,0));
		
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertFalse(mineMap.isLoss());
		assertFalse(mineMap.isWin());
		
		assertEquals(1, mineMap.getMineCount(new Position(1,0)));
	}
	
	@Test
	public void should_loss_when_click_on_2x2_with_2_mine(){
		MineMap mineMap = new MineMap(2,2);
		mineMap.plant(new Position(0,0));
		mineMap.plant(new Position(0,1));
		
		mineMap.sweep(new Position(1,0));
		
		assertTrue(mineMap.isOpen(new Position(1,0)));
		assertFalse(mineMap.isLoss());
		assertFalse(mineMap.isWin());
		
		assertEquals(2, mineMap.getMineCount(new Position(1,0)));
	}
	
	@Test
	public void should_loss_when_two_click_on_2x2_with_2_mine(){
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
}
