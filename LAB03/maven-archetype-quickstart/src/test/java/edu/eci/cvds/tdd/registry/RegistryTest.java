package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Gabriela Silva",1192793544,19,Gender.FEMALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void DuplicatedRegistryResult() {
        Person person1 = new Person("Gabriela Silva",1192793544,19,Gender.FEMALE,true);
        Person person = new Person("Andrés Pico",1192793544,19,Gender.UNIDENTIFIED,true);
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void DeadRegistryResult() {

        Person person = new Person("Alejandra Romero",1115545465,90,Gender.FEMALE,false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void InvalidRegistryResult() {

        Person person = new Person("Daniel Galindo",1456842354,-17,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void UnderAgeRegistryResult() {

        Person person = new Person("David Agudelo",325656581,15,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }    
    
}