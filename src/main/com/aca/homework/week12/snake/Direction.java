package com.aca.homework.week12.snake;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public enum Direction {
    UP("W") {
        public int[] getDeltaRowAndCol(){
            return new int[]{-1, 0};
        }
    },
    DOWN("S") {
        public int[] getDeltaRowAndCol(){
            return new int[]{1, 0};
        }
    },
    LEFT("A") {
        public int[] getDeltaRowAndCol(){
            return new int[]{0, -1};
        }
    },
    RIGHT("D") {
        public int[] getDeltaRowAndCol(){
            return new int[]{0, 1};
        }
    };

    private String move;
    private static final Map<String, Direction> map = Map.of(
            "w", Direction.UP,
            "s", Direction.DOWN,
            "a", Direction.LEFT,
            "d", Direction.RIGHT
    );

    Direction(String move) {
        this.move = move;
    }

    public abstract int[] getDeltaRowAndCol();

    public static boolean isValidMove(String move){
        return map.containsKey(move);
    }

    public static Direction of(String move) {
        return map.get(move);
    }
}
