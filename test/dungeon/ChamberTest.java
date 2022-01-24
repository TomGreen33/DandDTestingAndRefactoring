package dungeon;

import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.DnDElement;
import dnd.models.Monster;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.models.Treasure;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tgreen.*;
import static org.junit.Assert.*;

public class ChamberTest {
    ChamberShape theShape;
    ChamberContents theContents;
    Monster myMonster;

    @Before
    public void setup(){
      theShape = new ChamberShape();
      theShape.setNumExits();
      theShape.setShape();
      theContents = new ChamberContents();
    }


    /**
     * Test the setShape method, from Chamber Class
     */
    @Test
    public void testSetShape() {

        System.out.println("Testing setShape");

        int expectedNumExits;
        int numExits;

        Chamber chamber = new Chamber();

        theShape.setNumExits(0);

        chamber.setShape(theShape);

        numExits = chamber.getDoors().size();

        expectedNumExits = theShape.getNumExits();

        if (expectedNumExits == 0) {
          expectedNumExits++;
        }

        assertEquals(expectedNumExits, numExits);
    }


    /**
     * Test the setShape method, from Chamber Class
     */
    @Test
    public void testGetDoors() {

        System.out.println("Testing getDoors");

        int expectedNumDoors;
        int numDoors;
        ChamberContents chamberContents = new ChamberContents();
        ChamberShape chamberShape = new ChamberShape();

        Chamber chamber = new Chamber(chamberShape, chamberContents);

        expectedNumDoors = chamberShape.getNumExits();

        theShape.setNumExits();

        chamber.setShape(theShape);

        numDoors = chamber.getDoors().size();

        //Set values to both
        expectedNumDoors = theShape.getNumExits();
        if (expectedNumDoors == 0) {
            expectedNumDoors++;
        }

        assertEquals(expectedNumDoors, numDoors);

    }


    /**
     * Test the getMonster method, from Chamber Class
     */
    @Test
    public void testGetMonster() {

        System.out.println("Testing getMonsters");

        int numMonsters;
        int expectedNumMonsters;
        int numAddedMonsters;
        ArrayList<Monster> monsters;
        Monster monster = new Monster();

        Chamber chamber = new Chamber();

        //Get initial number of monsters
        expectedNumMonsters = chamber.getMonsters().size();

        for (numAddedMonsters = 1; numAddedMonsters <= 5; numAddedMonsters++) {

            if (numAddedMonsters == 5) {
                chamber.addMonster(monster);
            } else {
                chamber.addMonster(new Monster());
            }
        }

        expectedNumMonsters += numAddedMonsters;

        monsters = chamber.getMonsters();

        if (monsters.size() < expectedNumMonsters) {
            assertEquals(monster, monsters.get(0));
        } else {
            assertEquals(expectedNumMonsters, monsters.size());
        }

    }


    /**
     * Test the addTreasure method, from Chamber Class
     */
    @Test
    public void testAddTreasure() {

        System.out.println("Testing addTreasure");

        Chamber chamber = new Chamber();
        int expectedNumTreasure;
        int numAddedTreasure;
        int numTreasure;

        //Get initial number of treasure
        expectedNumTreasure = chamber.getTreasureList().size();

        //Add 5 treasures to the list
        for (numAddedTreasure = 1; numAddedTreasure <= 5; numAddedTreasure++) {
            chamber.addTreasure(new Treasure());
        }
        expectedNumTreasure += numAddedTreasure;

        numTreasure = chamber.getTreasureList().size();

        assertEquals(expectedNumTreasure, numTreasure);



    }


    /**
     * Test the getTreasureList method, from Chamber Class
     */
    @Test
    public void testGetTreasureList() {

        System.out.println("Testing getTreasureList");

        Chamber chamber = new Chamber();
        ArrayList<Treasure> treasures;
        int expectedNumTreasures;
        int numTreasures;

        expectedNumTreasures = chamber.getTreasureList().size();
        chamber.addTreasure(new Treasure());
        expectedNumTreasures += 1;

        treasures = chamber.getTreasureList();
        numTreasures = treasures.size();

        assertEquals(expectedNumTreasures, numTreasures);

    }


    /**
     * Test the getDescription method, from Chamber Class
     */
    @Test
    public void testGetDescription() {

        System.out.println("Testing getDescription");

        Chamber chamber = new Chamber(theShape, theContents);
        String description;

        description = chamber.getDescription();

        assertTrue(chamber.getDescription().contains(theContents.getDescription()));
    }


    /**
     * Test the setDoor method, from Chamber Class
     */
    @Test
    public void testSetDoor() {

        System.out.println("Testing setDoor");

        Chamber chamber = new Chamber(theShape, theContents);
        Door door = new Door();
        String spaceDescription;

        chamber.setDoor(door);

        spaceDescription = door.getSpaces().get(0).getDescription();

        assertTrue(spaceDescription.contains(theContents.getDescription()));

    }
}
