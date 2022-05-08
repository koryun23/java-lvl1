package com.aca.classwork.week15.univeristy.facade;

import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.facade.*;
import com.aca.classwork.week15.university.service.core.CreateUserParams;
import com.aca.classwork.week15.university.service.core.DiplomaService;
import com.aca.classwork.week15.university.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UniversityFacadeImplTest {

    private UniversityFacade testSubject;

    @Mock
    private UserService userService;

    @Mock
    private DiplomaService diplomaService;

    @BeforeEach
    public void init() {
        testSubject = new UniversityFacadeImpl(userService, diplomaService, new UserMapperImpl());
    }

    @Test
    public void testAdmit() {

        /*Mockito.when(userService.create(new CreateUserParams("Armen_Grigoryan", "Armen", "Grigoryan")))
                .thenReturn(new User("Armen_Grigoryan", "Armen", "Grigoryan"));
        UserAdmissionResponseDto admit = testSubject.admit(
                new UserAdmissionRequestDto("Armen",
                        "Grigoryan")
        );
        Assertions.assertThat(admit.getUsername()).isEqualTo("Armen_Grigoryan");
        Assertions.assertThat(admit.getFirstName()).isEqualTo("Armen");*/
    }
}