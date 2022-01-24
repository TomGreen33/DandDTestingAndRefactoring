package dungeon;

import dnd.models.Exit;
import dnd.models.Monster;
import org.junit.Test;
import static org.junit.Assert.*;
import tgreen.*;


public class PassageSectionTest {

    /* set up similar to the sample in PassageTest.java */

    /**
     * Test of getDoor method, of class Passage.
     */
    @Test
    public void testGetDoor() {

        System.out.println("Teststing getDoor");

        String description;
        PassageSection passageSection;
        Door door;
        boolean isNumSpaces;

        description = "passage ends in Door to a Chamber";
        passageSection = new PassageSection(description);
        door = passageSection.getDoor();

        if (door != null) {
            isNumSpaces = (door.getSpaces().size() >= 0);
            assertTrue(isNumSpaces);
        }
        else {
            fail("There is no door attached to this passage section.");
        }

    }


    /**
     * Test of getMonsterOne method, of class Passage.
     */
    @Test
    public void testGetMonsterOne() {

        System.out.println("Teststing getMonster (monster)");

        String description;
        PassageSection passageSection;
        Monster monster;
        boolean isMonster;

        description = "Wandering Monster (passage continues straight for 10 ft)";
        passageSection = new PassageSection(description);
        monster = passageSection.getMonster();
        isMonster = (monster != null); //should evaluate to false given Description

        assertTrue(isMonster);
    }


    /**
     * Test of getMonsterTwo method, of class Passage.
     */
    @Test
    public void testGetMonsterTwo() {

        System.out.println("Teststing getMonster (no monster)");

        String description;
        PassageSection passageSection;
        Monster monster;
        boolean isMonster;

        description = "passage goes straight for 10 ft";
        passageSection = new PassageSection(description);
        monster = passageSection.getMonster();
        isMonster = (monster != null); //should evaluate to false given Description

        assertTrue(!isMonster);

    }


    /**
     * Test of getDescription method, of class Passage.
     */
    @Test
    public void testGetDescription() {

        System.out.println("Teststing getDescription");

        PassageSection passageSection;
        String description;
        String expectedDescription;

        description = "passage goes straight for 10 ft";
        passageSection = new PassageSection(description);

        expectedDescription = "straight";

        assertTrue(passageSection.getDescription().contains(expectedDescription));

    }
}
