package aoc2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Day1Test {

    private SubmarineSonar sonar;
    private List<Integer> depths;

    @BeforeEach
    void setup() throws IOException {
        sonar = new SubmarineSonar();
        var file = getClass().getResource("/inputs/day-1-ch-1.txt").getFile();
        depths = Files.readAllLines(Paths.get(file))
                .stream()
                .map(Integer::parseInt).toList();
    }

    @Test
    void countIncreases() {
        // Act
        var increases = sonar.countIncreases(depths);

        // Assert
        Assertions.assertTrue(increases >= 0, "Counted increases must be zero or positive.");
        System.out.printf("The depth increased %d times.%n", increases);
    }

    @Test
    void countIncreasesWithSlidingWindow() {
        // Act
        var depthSlidingWindows = sonar.applySlidingWindow(depths, 3);
        var increases = sonar.countIncreases(depthSlidingWindows);

        // Assert
        Assertions.assertTrue(increases >= 0, "Counted increases must be zero or positive.");
        System.out.printf("The depth increased %d times.%n", increases);
    }

}
