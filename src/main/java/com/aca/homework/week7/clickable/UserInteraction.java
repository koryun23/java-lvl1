package com.aca.homework.week7.clickable;

import java.util.Scanner;

public class UserInteraction {
    private final Clickable[] clickables = new Clickable[5];

    public void interactWithUser() {
        getClickables();
        clickClickable();
    }

    public void getClickables() {
        for (int i = 0; i < 5; i++) {
            Clickable clickable = getSingleClickable();
            System.out.println("The " + clickable.toString() + " object created having name " + clickable.name());
            clickables[i] = clickable;
        }
    }

    public Clickable getSingleClickable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type a clickable object name.");
        String clickableName = scanner.nextLine();
        Action actionOfClickingObject = new Action() {
            @Override
            public void doAction(Clickable clickable) {
                System.out.println("The click method invoked on the " + clickable + " object having a name " + clickable.name());
            }
        };
        if (clickableName.startsWith("image")) {
            return new Image(clickableName, actionOfClickingObject);
        }
        return new Button(clickableName, actionOfClickingObject);
    }

    public void clickClickable() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a clickable name to invoke the click method.");
        String clickableName = scanner.nextLine();
        Clickable clickableToClick = findClickableByName(clickableName);
        clickableToClick.click();
    }

    public Clickable findClickableByName(String name) {
        for (Clickable clickable : clickables) {
            if (clickable.name().equals(name)) {
                return clickable;
            }
        }
        return null;
    }
}
