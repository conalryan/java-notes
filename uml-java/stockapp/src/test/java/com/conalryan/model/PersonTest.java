package com.conalryan.model;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonTest {

    private int id;
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private Person person;

    @Before
    public void setUp() throws Exception {
        id = 22;
        firstName = "Conal";
        lastName = "Ryan";
        birthDate = new DateTime(1980,12,25,0,0,0,0);
        person = new Person(firstName,lastName, birthDate);
        person.setId(id);
    }

    @Test
    public void testPerson() throws Exception { assertNotNull("Person created correctly", person);}

    @Test
    public void testGetId() throws Exception { assertEquals("ID is correct", id, person.getId()); }

    @Test
    public void testSetId() throws Exception {
        person.setId(1);
        assertEquals("ID set correctly", 1, person.getId()); }

    @Test
    public void testGetFirstName() throws Exception { assertEquals("Name is correct", firstName, person.getFirstName()); }

    @Test
    public void testSetFirstName() throws Exception {
        person.setFirstName("Bob");
        assertEquals("FirstName set", "Bob", person.getFirstName()); }

    @Test
    public void testGetLastName() throws Exception { assertEquals("Last name is correct", lastName, person.getLastName()); }

    @Test
    public void testSetLastName() throws Exception {
        person.setLastName("Smith");
        assertEquals("LastName set correctly", "Smith", person.getLastName()); }

    @Test
    public void testGetBirthDate() throws Exception { assertEquals("Birthdate is correct", birthDate, person.getBirthDate()); }

    @Test
    public void testSetBirthDate() throws Exception {
        DateTime birthDate2 = new DateTime(2015,02,28,0,1,2,3);
        person.setBirthDate(birthDate2);
        assertEquals("BirthDate set correctly", birthDate2, person.getBirthDate()); }

    @Test
    public void testEquals() throws Exception {
        Person person2 = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        person2.setId(id);
        assertEquals("Equals is correct", person, person2); }

    @Test
    public void testHashCode() throws Exception {
        Person person2 = new Person("Conal", "Ryan", new DateTime(1980,12,25,0,0,0,0));
        person2.setId(id);
        assertEquals("Hashcode correct", person.hashCode(), person2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertNotNull("String is correct", person.toString());
    }
}