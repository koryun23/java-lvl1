package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class FileSourceUserRepositoryTest {
    private CrudRepository<User, String> userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = FileSourceUserRepository.of();
    }

    @Test
    public void testByIdWhenIdIsNotFound() throws FileNotFoundException {
        Assertions.assertNull(userRepository.findById("somerandomidthatdoesnotexist"));
    }

    @Test
    public void testByIdWhenIdIsFound() throws FileNotFoundException {
        Assertions.assertNotNull(userRepository.findById("barracudaassign"));
    }

    @Test
    public void testGetInstance() {
        Assertions.assertEquals(FileSourceUserRepository.of(), FileSourceUserRepository.of());
    }

    @Test
    public void testFindAll() throws FileNotFoundException {
        Assertions.assertEquals(
                List.of(
                        new User("dairyfootball", "Ally", "Baca"),
                        new User("impossibleimmediate", "Kara", "Ayaan"),
                        new User("blessingforeign", "Dalton", "Russell"),
                        new User("burberryspectral", "Parsa", "Miller"),
                        new User("lardbear", "Carolina", "Lara"),
                        new User("shawlinspire", "Janea", "Dawson"),
                        new User("meantfirethorn", "Alexa", "Grohs"),
                        new User("barracudaassign", "Kaiya", "Dunlap")
                ), userRepository.findAll()
        );
    }
}