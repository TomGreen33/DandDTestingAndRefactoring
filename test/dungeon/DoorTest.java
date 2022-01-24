package dungeon;

import dnd.models.Trap;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import tgreen.*;



public class DoorTest {

    public DoorTest() {


    }

    /**
     * Test the setTrappedOne method, from Door Class.
     * isTrapped is set to true, no roll is provided.
     */
    @Test
    public void testSetTrappedOne() {

        System.out.println("Testing setTrapped (true, no roll)");

        boolean isTrapped = true;
        Door door = new Door();

        door.setArchway(false);
        door.setTrapped(isTrapped);
        assertEquals(true, door.isTrapped());

    }


    /**
     * Test the setTrappedTwo method, from Door Class.
     * isTrapped is set to true, roll is provided.
     */
    @Test
    public void testSetTrappedTwo() {

        System.out.println("Testing setTrapped (true, roll)");

        boolean isTrapped = true;
        Door door = new Door();
        String expectedDescription;
        String description;

        door.setArchway(false);
        door.setTrapped(true,6);

        expectedDescription = " Pit, 10' deep, 3 in 6 to fall in.";
        description = door.getTrapDescription();

        assertEquals(true, door.isTrapped());
        assertEquals(expectedDescription, description);
    }


    /**
     * Test the setTrappedTwo method, from Door Class.
     * isTrapped is set to false, no roll is provided.
     */
    @Test
    public void testSetTrappedThree() {

        System.out.println("Testing setTrapped (false, no roll)");

        boolean isTrapped = false;
        Door door = new Door();

        door.setArchway(false);
        door.setTrapped(isTrapped);
        assertEquals(false, door.isTrapped());
    }


    /**
     * Test the setOpenOne method, from Door Class.
     */
    @Test
    public void testSetOpenOne() {

        System.out.println("Testing setOpen (is an archway)");

        Door door = new Door();
        boolean expectedIsOpen;
        boolean isOpen;

        door.setArchway(true);
        door.setOpen(false);

        expectedIsOpen = true;
        isOpen = door.isOpen();

        assertEquals(expectedIsOpen, isOpen);
    }


    /**
     * Test the setOpenThree method, from Door Class.
     */
    @Test
    public void testSetOpenTwo() {

        System.out.println("Testing setOpen (in not an archway)");

        Door door = new Door();
        boolean expectedIsOpen;
        boolean isOpen;

        door.setArchway(false);
        door.setOpen(false);

        expectedIsOpen = false;
        isOpen = door.isOpen();

        assertEquals(expectedIsOpen, isOpen);
    }


    /**
     * Test the setArchway method, from Door Class.
     */
    @Test
    public void testSetArchway() {

        System.out.println("Testing setArchway");

        Door door = new Door();
        boolean isArchway;
        boolean expectedIsArchway;

        expectedIsArchway = true;

        door.setArchway(expectedIsArchway);
        isArchway = door.isArchway();

        assertEquals(expectedIsArchway, isArchway);
    }


    /**
     * Test the isTrappedOne method, from Door Class.
     * Door is set to be trapped.
     */
    @Test
    public void testIsTrappedOne() {

        System.out.println("Testing isTrapped (trapped)");

        Door door = new Door();
        boolean isTrapped;
        boolean expectedIsTrapped;

        expectedIsTrapped = true;

        door.setArchway(false);
        door.setTrapped(expectedIsTrapped);

        isTrapped = door.isTrapped();

        assertEquals(expectedIsTrapped, isTrapped);
    }


    /**
     * Test the isTrappedTwo method, from Door Class.
     * Door is set to not be trapped.
     */
    @Test
    public void testIsTrappedTwo() {

        System.out.println("Testing isTrapped (not trapped)");

        Door door = new Door();
        boolean isTrapped;
        boolean expectedIsTrapped;

        expectedIsTrapped = false;

        door.setArchway(false);
        door.setTrapped(expectedIsTrapped);

        isTrapped = door.isTrapped();

        assertEquals(expectedIsTrapped, isTrapped);
    }


    /**
     * Test the isOpenOne method, from Door Class
     */
    @Test
    public void testIsOpenOne() {

        System.out.println("Testing isOpen (is not open)");

        Door door = new Door();

        boolean expectedIsOpen;
        boolean isOpen;

        expectedIsOpen = false;

        door.setOpen(true);
        door.setOpen(expectedIsOpen);

        //To test for archway constraint
        if (door.isArchway()) {
            expectedIsOpen = true;
        }

        isOpen = door.isOpen();

        assertEquals(expectedIsOpen, isOpen);
    }


    /**
     * Test the isOpenTwo method, from Door Class
     */
    @Test
    public void testIsOpenTwo() {

        System.out.println("Testing isOpen (is open)");

        Door door = new Door();

        boolean expectedIsOpen;
        boolean isOpen;

        expectedIsOpen = true;

        door.setOpen(expectedIsOpen);

        isOpen = door.isOpen();

        assertEquals(expectedIsOpen, isOpen);

    }


    /**
     * Test the isArchwayOne method, from Door Class
     * Door is set to be an archway.
     */
    @Test
    public void testIsArchwayOne() {

        System.out.println("Testing isArchway (is archway)");

        Door door = new Door();
        boolean isArchway;
        boolean expectedIsArchway;

        expectedIsArchway = true;

        door.setArchway(expectedIsArchway);
        isArchway = door.isArchway();
        assertEquals(expectedIsArchway, isArchway);
    }


    /**
     * Test the isArchwayTwo method, from Door Class
     * Door is not set to be an archway.
     */
    @Test
    public void testIsArchwayTwo() {

        System.out.println("Testing isArchwayTwo (is not archway)");

        Door door = new Door();
        boolean isArchway;
        boolean expectedIsArchway;

        expectedIsArchway = false;

        door.setArchway(expectedIsArchway);
        isArchway = door.isArchway();
        assertEquals(expectedIsArchway, isArchway);
    }


    /**
     * Test the getTrapDescription method, from Door Class
     */
    @Test
    public void testGetTrapDescription() {

        System.out.println("Testing getTrapDescription");

        Door door = new Door();
        String expectedTrapDescription;
        String trapDescription;

        door.setArchway(false);
        door.setTrapped(true, 6);

        expectedTrapDescription = " Pit, 10' deep, 3 in 6 to fall in.";
        trapDescription = door.getTrapDescription();

        assertEquals(expectedTrapDescription, trapDescription);
    }


    /**
     * Test the setSpaces method, from Door Class
     */
    @Test
    public void testSetSpaces() {

        System.out.println("Testing setSpaces");

        Chamber chamberOne = new Chamber();
        Chamber chamberTwo = new Chamber();
        Door door = new Door();
        ArrayList<Space> spaces;
        int expectedNumSpaces;
        int numSpaces;

        door.setSpaces(chamberOne, chamberTwo);
        expectedNumSpaces = 2;

        spaces = door.getSpaces();

        numSpaces = spaces.size();

        assertEquals(expectedNumSpaces, numSpaces);
    }


    /**
     * Test the getSpaces method, from Door Class
     */
    @Test
    public void testGetSpaces() {

        System.out.println("Testing getSpaces");

        Chamber chamberOne = new Chamber();
        Chamber chamberTwo = new Chamber();
        Door door = new Door();
        ArrayList<Space> spaces;
        int expectedNumSpaces;
        int numSpaces;

        door.setSpaces(chamberOne, chamberTwo);
        expectedNumSpaces = 2;

        spaces = door.getSpaces();

        numSpaces = spaces.size();

        assertEquals(expectedNumSpaces, numSpaces);
    }


    /**
     * Test the getDescription method, from Door Class
     */
    @Test
    public void testGetDescription() {

        System.out.println("Testing getDescription");

        Door door = new Door();
        String expectedDescription;
        String description;

        door.setArchway(false);
        door.setTrapped(true, 15);

        expectedDescription = "trap"; //Description Should show that it is not trapped

        description = door.getDescription();

        assertTrue(description.contains(expectedDescription));
    }
}
