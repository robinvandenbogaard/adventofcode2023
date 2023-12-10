package nl.roka.adventofcode.aoc2023.day10;

public record Step(Pipe fromPipe, Direction leavingFrom, Direction enteringAt, Pipe toPipe) {}
