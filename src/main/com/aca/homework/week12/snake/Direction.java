package com.aca.homework.week12.snake;

public enum Direction {
    UP("w") {
        public int[] getDeltaRowAndCol() {
            return new int[]{-1, 0};
        }
    },
    DOWN("s") {
        public int[] getDeltaRowAndCol() {
            return new int[]{1, 0};
        }
    },
    LEFT("a") {
        public int[] getDeltaRowAndCol() {
            return new int[]{0, -1};
        }
    },
    RIGHT("d") {
        public int[] getDeltaRowAndCol() {
            return new int[]{0, 1};
        }
    };

    private final String move;

    Direction(String move) {
        this.move = move;
    }

    public static boolean isValidMove(String move) {
        for (Direction value : Direction.values()) {
            if (value.getMove().equals(move)) {
                return true;
            }
        }
        return false;
    }

    public static Direction of(String move) {
        for (Direction value : Direction.values()) {
            if (value.getMove().equals(move)) {
                return value;
            }
        }
        return null;
    }

    public String getMove(){
        return move;
    }
    public abstract int[] getDeltaRowAndCol();
}
