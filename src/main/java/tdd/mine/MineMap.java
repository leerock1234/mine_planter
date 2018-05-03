package tdd.mine;

import java.util.HashSet;
import java.util.Set;

public class MineMap {

    int height;

    int width;

    Set mines = new HashSet();

    public MineMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void plant(Position position) {
        if (position.getWidth() >= width
                || position.getHeight() >= height ) {
            throw new MineNotAllowOutOfMap();
        }
        if(width==1&&height==1){
            throw new MineNotAllowHere();
        }
        mines.add(position);
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
}
