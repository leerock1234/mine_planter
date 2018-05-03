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
        return 0;
    }

    Set<Position> getRelativePositions(Position position) {
        int x = position.width;
        int y = position.height;
        Set<Position> result = new HashSet<>();
        putPositionToResult(result, x-1, y-1);
        putPositionToResult(result, x, y-1);
        putPositionToResult(result, x+1, y-1);
        putPositionToResult(result, x-1, y);
        putPositionToResult(result, x+1, y);
        putPositionToResult(result, x-1, y+1);
        putPositionToResult(result, x, y+1);
        putPositionToResult(result, x+1, y+1);
        return result;
    }

    private void putPositionToResult(Set<Position> result, int x, int y) {
        if (x<0){
            return;
        }
        if (y<0){
            return;
        }
        if (x>=width){
            return;
        }
        result.add(new Position(x, y));
    }
}
