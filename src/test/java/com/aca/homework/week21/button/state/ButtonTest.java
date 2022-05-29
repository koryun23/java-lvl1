package com.aca.homework.week21.button.state;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonTest {
    private Button button;

    @BeforeEach
    public void init() {
        button = new Button(new ButtonOnState(ColorType.GREEN));
    }

    @Test
    public void testClick() {
        button.click();
        Assertions.assertThat(button.getState()).isEqualTo(new ButtonOffState(ColorType.GRAY));
    }
}