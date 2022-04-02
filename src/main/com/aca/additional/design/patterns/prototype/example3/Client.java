package com.aca.additional.design.patterns.prototype.example3;

public class Client {
    private final UserPrototype prototype;
    private UserImpl userImpl;

    public Client(UserPrototype prototype) {
        this.prototype = prototype;
    }

    public UserImpl createCopyOfPrototype() {
        userImpl = prototype.clone();
        return userImpl;
    }
}
