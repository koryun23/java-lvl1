package com.aca.homework.week11.stopwatch;

public enum DisplayType {
    SECONDS_AND_MILLIS {
        @Override
        public FormatTimeStrategy getFormatTimeStrategy() {
            return new FormatSecondsAndMillis();
        }

        @Override
        public PrintTimeStrategy getPrintTimeStrategy() {
            return new PrintSecondsAndMillis();
        }
    },
    SECONDS {
        @Override
        public FormatTimeStrategy getFormatTimeStrategy() {
            return new FormatSeconds();
        }

        @Override
        public PrintTimeStrategy getPrintTimeStrategy() {
            return new PrintSeconds();
        }
    };

    public abstract FormatTimeStrategy getFormatTimeStrategy();

    public abstract PrintTimeStrategy getPrintTimeStrategy();
}
