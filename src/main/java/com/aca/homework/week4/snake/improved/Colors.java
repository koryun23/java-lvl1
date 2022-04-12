package com.aca.homework.week4.snake.improved;

public enum Colors {
    RED{
        public String toString(){
            return "\033[1;31m";
        }
    },
    ORANGE{
        public String toString(){
            return "\033[1;34m";
        }
    },
    YELLOW{
        public String toString(){
            return "\033[1;33m";
        }
    },
    WHITE{
        public String toString(){
            return "\033[1;37m";
        }
    },
    RESET{
        public String toString(){
            return "\033[0m";
        }
    }
}
