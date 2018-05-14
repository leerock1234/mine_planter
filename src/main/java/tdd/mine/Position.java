package tdd.mine;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Position {
	private boolean isOpenned;
	
    int height;

    int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Position(int x, int y) {
        this.height = y;
        this.width = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getHeight() == position.getHeight() &&
                getWidth() == position.getWidth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth());
    }

	public Set<Position> getArround() {
		Set<Position> result = new HashSet<>();
        result.add(new Position(width-1, height-1));
        result.add(new Position(width, height-1));
        result.add(new Position(width+1, height-1));
        result.add(new Position(width-1, height));
        result.add(new Position(width+1, height));
        result.add(new Position(width-1, height+1));
        result.add(new Position(width, height+1));
        result.add(new Position(width+1, height+1));
        return result;
	}

	public boolean isOpenned() {
		return isOpenned;
	}

	public void setOpenned(boolean isOpenned) {
		this.isOpenned = isOpenned;
	}
}
