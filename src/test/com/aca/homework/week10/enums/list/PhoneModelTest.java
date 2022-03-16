package com.aca.homework.week10.enums.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneModelTest {
    @Test
    public void testNokia1100() {
        PhoneModel nokia1100 = PhoneModel.NOKIA_1100;
        Assertions.assertEquals(0, nokia1100.cameras().size());
    }

    @Test
    public void testNokia3110() {
        PhoneModel nokia3110 = PhoneModel.NOKIA_3110;
        Assertions.assertEquals("back camera", nokia3110.cameras().get(0));
    }

    @Test
    public void testGalaxy() {
        PhoneModel galaxy = PhoneModel.GALAXY_S2;
        Assertions.assertEquals("back camera", galaxy.cameras().get(0));
        Assertions.assertEquals("front camera", galaxy.cameras().get(1));
    }
}