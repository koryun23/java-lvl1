package com.aca.additional.design.patterns.prototype.example3;

public class Main {
    public static void main(String[] args) {
        UserPrototype prototype = new UserImpl("username", "firstName", "password");
        Client client = new Client(prototype);
        UserImpl prototypeCopy1 = client.createCopyOfPrototype();
        UserImpl prototypeCopy2 = client.createCopyOfPrototype();
        UserImpl prototypeCopy3 = client.createCopyOfPrototype();
        System.out.println(prototypeCopy1);
        System.out.println(prototypeCopy2);
        System.out.println(prototypeCopy3);
        prototypeCopy1 = (UserImpl) prototypeCopy1.new Builder().
                username("koryun23").
                firstName("Koryun").
                password("ete-10-ropeic-ste-chexav-qezem-tanum-qachal").
                build();
        prototypeCopy2 = (UserImpl) prototypeCopy2.new Builder().
                username("i4ceu2lose").
                password("somepassword").
                build();
        prototypeCopy3 = (UserImpl) prototypeCopy3.new Builder().
                username("notagmbruh").
                firstName("firstname").
                password("password").
                build();
        System.out.println(prototypeCopy1);
        System.out.println(prototypeCopy2);
        System.out.println(prototypeCopy3);

    }
}
