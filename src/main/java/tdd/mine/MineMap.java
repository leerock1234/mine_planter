package tdd.mine;

import java.util.HashSet;
import java.util.Set;
/**
 * Algorithm explain: 
 * When there is any cell around the planting position which is a critical position, then the plant should not be plant there.
 * For the planting mine would make that critical position to be totally surrounded by mine or border.
 * Critical position means the position there is only one cell left is not a mine or border.
 */
public class MineMap {

    int height;

    int width;

    Set<Position> mines = new HashSet<>();

    public MineMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void plant(Position position) {
        if (this.positionIsNotValid(position)) {
            throw new MineNotAllowOutOfMap();
        }
        if (hasCriticalPositionAtArround(position) || isTrivialMineMap()){
        	return;
        }
        mines.add(position);
    }

    private boolean isTrivialMineMap() {
    	return this.width==1 && this.height==1;
	}

	private boolean hasCriticalPositionAtArround(Position position) {
    	for(Position relativePosition:this.getRelativePositions(position)){
    		if (isCriticalPosition(relativePosition)){
    			return true;
    		}
    	}
		return false;
	}

	public boolean hasMine(Position position) {
        return mines.contains(position);
    }

    public int getMineCount(Position position) {
        Set<Position> relativePositions = getRelativePositions(position);
        return countThatHavingMine(relativePositions);
    }

    private int countThatHavingMine(Set<Position> relativePositions) {
    	int count=0;
    	for(Position position : relativePositions){
    		if (hasMine(position)) count++;
    	}
        return count;
    }

    Set<Position> getRelativePositions(Position position) {
        Set<Position> result = new HashSet<>();
        for(Position arroundPosition : position.getArround()){
			putPositionToResult(result, arroundPosition);
        }
        return result;
    }

    private void putPositionToResult(Set<Position> result, Position position) {
        if (positionIsNotValid(position)){
            return;
        }
        result.add(position);
    }

	private boolean positionIsNotValid(Position position) {
		return position.width<0 || position.height<0 || position.width>=width || position.height>=height;
	}

	public boolean isCriticalPosition(Position position) {
		int noMineCount=0;
		for(Position relativePosition : this.getRelativePositions(position)){
			if (!this.hasMine(relativePosition)) noMineCount++;
		}
		return noMineCount==1;
	}
}
