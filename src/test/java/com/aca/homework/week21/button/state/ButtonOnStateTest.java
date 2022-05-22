package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButtonOnStateTest {

    private ButtonState testSubject;

    @BeforeEach
    public void init() {
        testSubject = new ButtonOnState(ColorType.GREEN);
    }

    @Test
    public void testGetColor() {
        Assertions.assertThat(testSubject.getColor()).isEqualTo(ColorType.GREEN);
    }

    @Test
    public void testIsEnabled() {
        Assertions.assertThat(testSubject.isEnabled()).isEqualTo(true);
    }

    @Test
    public void testNextState() {
        Assertions.assertThat(testSubject.nextState()).isEqualTo(new ButtonOffState(ColorType.GRAY));
    }
}