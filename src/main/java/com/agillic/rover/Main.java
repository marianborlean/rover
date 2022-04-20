package com.agillic.rover;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.agillic.rover.Direction.getDirectionFromNameAbbreviation;

/**
 * @author marian.borlean
 * @since 4/20/2022.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        List<String> lines = readInputFile();
        String firstLine = lines.get(0);

        int maxX = getIntFromStringCharAtPosition(firstLine, 0);
        int maxY = getIntFromStringCharAtPosition(firstLine, 2);

        for (int i = 1; i <= lines.size() - 2; i += 2) {
            String positionLine = lines.get(i);
            String commandsLine = lines.get(i + 1);

            Point x = new Point(getIntFromStringCharAtPosition(positionLine, 0), maxX);
            Point y = new Point(getIntFromStringCharAtPosition(positionLine, 2), maxY);

            String directionNameAbbreviation = String.valueOf(positionLine.charAt(4));
            Direction direction = getDirectionFromNameAbbreviation(directionNameAbbreviation);

            Position position = new Position(x, y, direction);

            Rover rover = new Rover(position);
            rover.receiveCommands(commandsLine);
            System.out.println(rover);
        }

    }

    private static int getIntFromStringCharAtPosition(String line, int pos) {
        return Character.getNumericValue(line.charAt(pos));
    }

    private static List<String> readInputFile() throws IOException {
        Path path = Paths.get("C:\\projects\\rover\\src\\main\\resources\\rover.txt");
        return Files.readAllLines(path);
    }
}
