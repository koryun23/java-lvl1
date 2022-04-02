package com.aca.additional.design.patterns.prototype.example3;

public class Main {
    public static void main(String[] args) {
        UserPrototype prototype = new UserImpl("username", "firstName", "password");
        Client client = new Client(prototype);
        User prototypeCopy1 = client.createCopyOfPrototype();
        User prototypeCopy2 = client.createCopyOfPrototype();
        User prototypeCopy3 = client.createCopyOfPrototype();
        System.out.println(prototypeCopy1);
        System.out.println(prototypeCopy2);
        System.out.println(prototypeCopy3);
        prototypeCopy1 = new UserImpl.Builder().
                username("koryun23").
                firstName("Koryun").
                password("ete-10-ropeic-ste-chexav-qezem-tanum-qachal").
                build();
        prototypeCopy2 = new UserImpl.Builder().
                username("i4ceu2lose").
                firstName("FirstName").
                password("somepassword").
                build();
        prototypeCopy3 = new UserImpl.Builder().
                username("notagmbruh").
                firstName("firstname").
                password("password").
                build();
        System.out.println(prototypeCopy1);
        System.out.println(prototypeCopy2);
        System.out.println(prototypeCopy3);

    }
}
