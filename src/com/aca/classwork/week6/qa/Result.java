package com.aca.classwork.week6.qa;

public enum Result {
    FAIL{
        public String toString(){
            return "\033[0;31m" + this.name() + "\033[0m";
        }
    },
    PASS{
        public String toString(){
            return "\033[0;32m" + this.name() + "\033[0m";
        }
    };
}
