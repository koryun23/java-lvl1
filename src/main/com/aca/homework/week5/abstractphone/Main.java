package com.aca.homework.week5.abstractphone;

public class Main {
    public static void main(String[] args) {
        PhoneService phoneService = new PhoneService();
        Phone phone = phoneService.create("351978946541895", Model.SAMSUNG);
        Phone phone1 = phoneService.create("45678974132187", Model.IPHONE);
        Phone phone2 = phoneService.create("04894100487866", Model.IPHONE);
        Phone phone3 = phoneService.create("99987741084444", Model.NOKIA);

        Phone searchedPhone = phoneService.getByImei("04894100487866");
        System.out.println(searchedPhone);
    }

}
