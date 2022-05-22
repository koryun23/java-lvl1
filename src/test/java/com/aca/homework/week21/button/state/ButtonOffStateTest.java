package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonOffStateTest {
    private ButtonState testSubject;

    @BeforeEach
    public void init() {
        testSubject = new ButtonOffState(ColorType.GRAY);
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertThat(testSubject.isEnabled()).isEqualTo(false);
    }

    @Test
    public void testNextState() {
        Assertions.assertThat(testSubject.nextState()).isEqualTo(new ButtonOnState(ColorType.GREEN));
    }

    @Test
    public void testGetColor() {
        Assertions.assertThat(testSubject.getColor()).isEqualTo(ColorType.GRAY);
    }
}