package com.aca.homework.week21.button.state;

public class Button {
    private ButtonState buttonState;

    public Button(ButtonState buttonState) {
        this.buttonState = buttonState;
    }

    public ButtonState click() {
        setState(buttonState.nextState());
        return buttonState;
    }

    public void setState(ButtonState buttonState) {
        this.buttonState = buttonState;
    }

    public ButtonState getState() {
        return buttonState;
    }
}
