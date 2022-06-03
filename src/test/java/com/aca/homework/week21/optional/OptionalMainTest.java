package com.aca.homework.week21.optional;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalMainTest {

    private OptionalMain optionalMain;

    private ArgumentConsumer argumentConsumer;

    @BeforeEach
    public void init() {
        argumentConsumer = new ArgumentConsumerImpl();
        optionalMain = new OptionalMain(argumentConsumer);
    }

    @Test
    public void testWhenOptionalIsEmpty() {
        optionalMain.printFirstSymbol(Optional.empty());
        Assertions.assertThat(argumentConsumer.getLastArgument()).isEqualTo("");
    }

    @Test
    public void testWhenStringIsEmpty() {
        optionalMain.printFirstSymbol(Optional.of(""));
        Assertions.assertThat(argumentConsumer.getLastArgument()).isEqualTo("");
    }

    @Test
    public void testWhenStringHas1Symbol() {
        optionalMain.printFirstSymbol(Optional.of("c"));
        Assertions.assertThat(argumentConsumer.getLastArgument()).isEqualTo("");
    }

    @Test
    public void testWhenStringHas2Symbols() {
        optionalMain.printFirstSymbol(Optional.of("ab"));
        Assertions.assertThat(argumentConsumer.getLastArgument()).isEqualTo("b");
    }
}