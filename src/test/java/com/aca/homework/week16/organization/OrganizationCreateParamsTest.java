package com.aca.homework.week16.organization;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganizationCreateParamsTest {

    @Test
    public void testCreateParamsWithNullName() {
        Assertions.assertThatThrownBy(() -> new OrganizationCreateParams(null, "address"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCreateParamsWithNullFullAddress() {
        Assertions.assertThatThrownBy(() -> new OrganizationCreateParams("name", null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}