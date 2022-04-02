package com.aca.additional.design.patterns.prototype.example3;

public class UserImpl implements UserPrototype, User {
    private final String username;
    private final String firstName;
    private final String password;

    public UserImpl(String username, String firstName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.password = password;
    }

    // copy constructor
    public UserImpl(UserImpl userImpl) {
        username = userImpl.getUsername();
        firstName = userImpl.getFirstName();
        password = userImpl.getPassword();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserImpl clone() {
        return new UserImpl(this);
    }

    @Override
    public String toString() {
        return String.format("USER[username = %s, first name = %s]", username, firstName);
    }

    public static class Builder {
        private String username;
        private String firstName;
        private String password;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build(){
            return new UserImpl(username, firstName, password);
        }
    }
}
