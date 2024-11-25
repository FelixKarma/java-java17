package java17.ex01;

import java.util.function.Function;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;

/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PART 1 - Integer -> Person *******/

    // tag::intToPerson[]
    private Function<Integer, Person> intToPerson = (Integer i) ->
            new Person("first_" + i, "last_" + i, i, "pass_" + i);
    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        Person result = intToPerson.apply(10);

        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    // Définit la fonction pour transformer un objet Person en Account
    private Function<Person, Account> personToAccount = (Person p) ->
            new Account(p, 1000);
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        Account result = personToAccount.apply(person);
        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }
}
