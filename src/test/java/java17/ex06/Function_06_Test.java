package java17.ex06;

import java.util.function.Supplier;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    // tag::formatAge[]
    String formatAge(Supplier<Person> supplier) {
        return "[age=" + supplier.get().getAge() + "]";
    }
    // end::formatAge[]

    @Test
    public void test_supplier_formatAge() throws Exception {
        Supplier<Person> personSupplier = () -> new Person("John", "Doe", 35, "password123");

        String result = formatAge(personSupplier);

        assert result.equals("[age=35]");
    }
}
