package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    // tag::functions[]
    Consumer<Person> changePasswordToSecret = person -> person.setPassword("secret");

    Consumer<Person> verifyAge = person -> assertTrue(person.getAge() > 4);

    Consumer<Person> verifyPassword = person -> assertEquals("secret", person.getPassword());
    // end::functions[]

    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        personList.forEach(changePasswordToSecret);

        personList.forEach(changePasswordToSecret
                .andThen(verifyAge)
                .andThen(verifyPassword));
    }
}
