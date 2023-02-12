import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTest {
    User sut;
    User sut2;
    User sut3;
    User[] array = new User[]{sut, sut2, sut3};

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");

        sut = new User("Pavel", "123456", "pavel@mail.ru", 13);
        sut2 = new User("Petya", "985740", "petya@mail.ru", 18);
        sut3 = new User("Kolya", "qwerty", "kolya@mail.ru", 96);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
        sut = null;
    }

    @Test
    public void getUsersTests() {
        assertThat(array, not(emptyArray()));

        assertThat(array, arrayWithSize(3));
    }

    @Test
    public void getUserByLoginAndPasswordTest() {
        assertThat(sut.getLogin(), not(sut2.getLogin()));
        assertThat(sut.getLogin(), not(sut3.getLogin()));
        assertThat(sut3.getLogin(), not(sut2.getLogin()));
    }

    @Test
    public void validateUserTest() {
        assertThat(sut.getAge(), notNullValue());
        assertThat(sut2.getAge(), notNullValue());
        assertThat(sut3.getAge(), notNullValue());
    }

    @Test
    public void userWhenToString_thenReturnsParametrs() {
        assertThat(sut.getPassword(), hasToString("123456"));
        assertThat(sut2.getPassword(), hasToString("985740"));
        assertThat(sut3.getPassword(), hasToString("qwerty"));
    }
}



