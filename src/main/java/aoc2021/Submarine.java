package aoc2021;

import java.util.regex.Pattern;

public class Submarine {

    private static final Pattern COMMAND_REGEX = Pattern.compile("(forward|up|down)\\s-?[0-9]+");

    private SubmarinePosition currentPosition = new SubmarinePosition(0, 0, 0);

    /**
     * Moves the submarine by the given command. A command consists of a direction and amount. The direction can be
     *
     * <ul>
     *     <li>forward</li>
     *     <li>down</li>
     *     <li>up</li>
     * </ul>
     *
     * The amount must be an integer.
     *
     * @param command the move command
     */
    public void move(String command) {
        if(!COMMAND_REGEX.asPredicate().test(command)) {
            throw new IllegalArgumentException("Invalid command: %s".formatted(command));
        }

        var parts = command.split(" ");
        var amount = Integer.parseInt(parts[1]);
        this.currentPosition = switch (parts[0]) {
            case "forward" -> new SubmarinePosition(currentPosition.depth() + currentPosition.aim()*amount,
                    currentPosition.horizontalPosition() + amount,
                    currentPosition.aim());
            case "up" -> new SubmarinePosition(currentPosition.depth(),
                    currentPosition.horizontalPosition(),
                    currentPosition.aim() - amount);
            case "down" -> new SubmarinePosition(currentPosition.depth(),
                    currentPosition.horizontalPosition(),
                    currentPosition.aim() + amount);
            default -> throw new IllegalStateException("Unknown direction: %s".formatted(parts[0]));
        };
    }

    public SubmarinePosition getCurrentPosition() {
        return currentPosition;
    }
}
