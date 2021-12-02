package aoc2021;

public record SubmarinePosition(int depth, int horizontalPosition, int aim) {

    public int multiply() {
        return depth * horizontalPosition;
    }

}
