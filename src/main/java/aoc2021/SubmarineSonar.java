package aoc2021;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubmarineSonar {

    /**
     * Applies a sliding window on the depth collection, by summing each consecutive element in the sliding window
     * size.
     *
     * @param depths list of depth measurements
     * @param slidingWindowSize number of elements to summarise
     * @return new list of depths
     */
    public List<Integer> applySlidingWindow(List<Integer> depths, int slidingWindowSize) {
        if(slidingWindowSize <= 0) {
            throw new IllegalArgumentException("slidingWindowSize must be > 0");
        }
        if(depths.isEmpty() || depths.size() < slidingWindowSize) {
            return List.of();
        }

        var sum = depths.subList(0, slidingWindowSize)
                .stream()
                .mapToInt(i -> i)
                .sum();
        return Stream.of(List.of(sum), applySlidingWindow(depths.subList(1, depths.size()), slidingWindowSize))
                .flatMap(List::stream)
                .toList();
    }


    /**
     * Takes a list of depth measurements and counts the number of times a measurement increased to the one directly
     * before.
     *
     * @param depths list of depth measurements
     * @return # of increases
     */
    public int countIncreases(List<Integer> depths) {
        if(depths.isEmpty()) {
            return 0;
        }

        return countIncreasesRecursive(depths.get(0), depths.subList(1, depths.size()));
    }

    private int countIncreasesRecursive(int last, List<Integer> remainingDepths) {
        if(remainingDepths.isEmpty()) {
            return 0;
        }

        var current = remainingDepths.get(0);
        var rst = remainingDepths.stream().skip(1).toList();
        return ((current > last)? 1 : 0) + countIncreasesRecursive(current, rst);
    }

}
