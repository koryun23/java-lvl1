package com.aca.homework.week12.snake;

public enum CellState {
    EMPTY {
        @Override
        public String toString(){
            return Colors.WHITE + "0" + Colors.RESET;
        }
    },
    APPLE {
        @Override
        public String toString(){
            return Colors.YELLOW + "=" + Colors.RESET;
        }
    },
    SNAKE_HEAD {
        @Override
        public String toString(){
            return Colors.RED + "*" + Colors.RESET;
        }
    },
    SNAKE_BODY {
        @Override
        public String toString(){
            return Colors.ORANGE + "*" + Colors.RESET;
        }
    }
}
