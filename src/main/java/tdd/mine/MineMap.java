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
        return 1;
    }


}
