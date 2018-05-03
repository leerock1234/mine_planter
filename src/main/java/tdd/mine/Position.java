package tdd.mine;

import java.util.Objects;
import java.util.Set;

public class Position {

    int height;

    int width;

    public Set getNearbyPositions() {
        return nearbyPositions;
    }

    public void setNearbyPositions(Set nearbyPositions) {
        this.nearbyPositions = nearbyPositions;
    }

    Set nearbyPositions;

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
        this.height = x;
        this.width = y;
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
}
