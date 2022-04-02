package com.aca.additional.design.patterns.prototype.example3;

public class UserImpl implements UserPrototype {
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

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public UserPrototype clone() {
        return new UserImpl(this);
    }

    @Override
    public String toString() {
        return String.format("USER[username = %s, first name = %s]", username, firstName);
    }

    public String defaultUsername() {
        return username;
    }

    public String defaultFirstName() {
        return firstName;
    }

    public String defaultPassword() {
        return password;
    }

    public class Builder {
        private String username = defaultUsername();
        private String firstName = defaultFirstName();
        private String password = defaultPassword();

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

        public UserPrototype build(){
            return new UserImpl(username, firstName, password);
        }
    }
}
