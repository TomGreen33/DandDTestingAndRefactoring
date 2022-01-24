package dungeon;

import dnd.models.Exit;
import dnd.models.Monster;
import dnd.models.Stairs;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import tgreen.*;


public class PassageTest {
    //you don't have to use instance variables but it is easier
    // in many cases to have them and use them in each test
    private Passage testerOne;
    private Passage testerTwo;
    private PassageSection sectionOne;
    private PassageSection sectionTwo;

    public PassageTest() {
    }

    @Before
    public void setup(){
        //set up any instance variables here so that they have fresh values for every test

    }


    /**
     * Test of getDoors method, of class Passage.
     */
    @Test
    public void testGetDoors() {

        System.out.println("Teststing testGetDoors");

        Passage passage = new Passage();
        PassageSection passageSectionOne = new PassageSection();
        PassageSection passageSectionTwo = new PassageSection();
        Door doorOne = new Door();
        Door doorTwo = new Door();
        Door doorThree = new Door();
        int expectedNumDoors;
        int numDoors;

    }

    /**
     * Test of getDoor method, of class Passage.
     */
    @Test
    public void testGetDoor() {

        System.out.println("Teststing getDoor");

        Passage passage = new Passage();
        PassageSection passageSectionOne = new PassageSection();
        PassageSection passageSectionTwo = new PassageSection();
        PassageSection passageSectionThree = new PassageSection();
        Door doorOne = new Door();
        Door doorTwo = new Door();
        Door doorThree = new Door();
        int expectedNumDoors;
        int numDoors;


        passage.addPassageSection(passageSectionOne);
        passage.setDoor(doorOne);
        passage.addPassageSection(passageSectionTwo);
        passage.setDoor(doorTwo);
        passage.addPassageSection(passageSectionThree);
        passage.setDoor(doorThree);

        numDoors = passage.getDoors().size();
        expectedNumDoors = 3;

        assertEquals(expectedNumDoors, numDoors);

    }


    /**
     * Test of addMonster method, of class Passage.
     */
    @Test
    public void testAddMonster() {

        System.out.println("Teststing addMonster");

        Passage passage = new Passage();
        PassageSection passageSection = new PassageSection();
        Monster monster = new Monster();
        Monster passageMonster;
        Monster passageSectionMonster;
        int sectionNum = 0;
        Boolean areMonstersEqualOne;
        Boolean areMonstersEqualTwo;

        passage.addPassageSection(passageSection);
        passage.addMonster(monster, sectionNum);

        passageMonster = passage.getMonster(sectionNum);
        passageSectionMonster = passageSection.getMonster();

        areMonstersEqualOne = (monster.equals(passageMonster));
        areMonstersEqualTwo = (monster.equals(passageSectionMonster));

        assertTrue(areMonstersEqualOne);
        assertTrue(areMonstersEqualTwo);


    }


    /**
     * Test of getMonster method, of class Passage.
     */
    @Test
    public void testGetMonster() {

        System.out.println("Teststing getMonster");

        Passage passage = new Passage();
        PassageSection passageSectionOne = new PassageSection();
        PassageSection passageSectionTwo = new PassageSection();
        Monster monster = new Monster();
        Monster passageMonster;
        Monster passageSectionMonster;
        int sectionNum = 1;
        Boolean areMonstersEqualOne;
        Boolean areMonstersEqualTwo;

        passage.addPassageSection(passageSectionOne);
        passage.addPassageSection(passageSectionTwo);

        passage.addMonster(monster, sectionNum);
        passageMonster = passage.getMonster(sectionNum);
        passageSectionMonster = passageSectionTwo.getMonster();


        areMonstersEqualOne = (monster.equals(passageMonster));
        areMonstersEqualTwo = (monster.equals(passageSectionMonster));

        assertTrue(areMonstersEqualOne);
        assertTrue(areMonstersEqualTwo);
    }



    /**
     * Test of addPassageSection method, of class Passage.
     */
    @Test
    public void testAddPassageSection() {

        System.out.println("Teststing addPassageSection");

        Passage passage = new Passage();
        PassageSection passageSection = new PassageSection("Definition");

        passage.addPassageSection(passageSection);

        assertTrue(passage.getDescription().contains("Definition"));
    }



    /**
     * Test of setDoor method, of class Passage.
     */
    @Test
    public void testSetDoor() {

        System.out.println("Teststing setDoor");

        Passage passage = new Passage();
        Door doorOne = new Door();
        Door doorTwo = new Door();

        passage.setDoor(doorOne);
        doorTwo = passage.getDoor(0);
        assertEquals(doorOne, doorTwo);
    }


    /**
     * Test of getDescription method, of class Passage.
     */
    @Test
    public void testGetDescription() {

        System.out.println("Teststing getDescription");

        Passage passage = new Passage();
        Monster monster = new Monster();
        String description;
        int sectionNum = 0;

        passage.addPassageSection(new PassageSection("Definition"));
        passage.addMonster(monster, sectionNum);

        description = passage.getDescription();

        assertTrue(description.contains(monster.getDescription()) && description.contains("Description"));
    }
}
