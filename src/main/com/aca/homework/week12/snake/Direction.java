package com.aca.homework.week12.snake;

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

    Direction(String move) {
        this.move = move;
    }

    public abstract int[] getDeltaRowAndCol();
}
