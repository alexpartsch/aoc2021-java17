package aoc2021;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Day2Test {

    @Test
    void moveSubmarine() throws IOException {
        // Arrange
        var submarine = new Submarine();
        var moves = Files.readAllLines(Paths.get(getClass().getResource("/inputs/day-2-ch-1.txt").getFile()));

        // Act
        moves.forEach(submarine::move);

        // Assert
        var position = submarine.getCurrentPosition();
        System.out.printf("The current position of the Submarine is at %s (mult: %d).%n", position, position.multiply());
    }

}
