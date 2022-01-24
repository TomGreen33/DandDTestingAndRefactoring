/* Name:       Thomas Green
    Student ID: 1048389
    Email:        tgreen12@uoguelph.ca */


import tgreen.Chamber;
import tgreen.Door;
import tgreen.Passage;
import java.util.ArrayList;


public class Main {

    /**
     * The main method for this project.
     * @param args command line input.
     */
    public static void main(String[] args) {

        /* Object ArrayLists */
        ArrayList<Passage> mainPassages = new ArrayList<Passage>();
        ArrayList<Door> mainDoors = new ArrayList<Door>();
        ArrayList<Chamber> mainChambers = new ArrayList<Chamber>();
        ArrayList<String> passageDescriptions = new ArrayList<String>();
        ArrayList<String> chamberDescriptions = new ArrayList<String>();

        /* Counters */
        int i;
        int numPaths = 1;
        int pathNum;


        /* Beginning of level */

        mainPassages.add(new Passage());

        mainDoors.add(mainPassages.get(0).generatePassage(true));

        passageDescriptions.add(mainPassages.get(0).getDescription());

        System.out.println("Passage 1:");
        System.out.println(passageDescriptions.get(0));


        /* Main Dungeon Generator Algorithm */

        for (i = 0; i < 5; i++) {

            /* Set current door to current passage and a new dungeon */
            System.out.println(">1\n");

            mainDoors.get(i * 2).setSpaces(mainPassages.get(i), new Chamber());
            System.out.println(">2\n");

            /* Add the new chamber to it's array list */
            mainChambers.add((Chamber) mainDoors.get(i * 2).getSpace(1));
            System.out.println(">3\n");

            /* gives the chamber object the num of current passages */
            mainChambers.get(i).getNumPaths(numPaths);

            /* Store the chamber's description in it's array list */
            chamberDescriptions.add(mainChambers.get(i).getDescription());

            /* Increments number of current passages */
            numPaths += mainChambers.get(i).getNumNewPaths();

            /* Gets the number of the next passage */
            pathNum = mainChambers.get(i).getPathNum();

            System.out.println("Chamber " + (i + 1) + ":");

            System.out.println(chamberDescriptions.get(i));

            /* Add the first chamber door exit that leads to another chamber to it's array list */
            mainDoors.add(mainChambers.get(i).getExitDoor());

            /* Add the passage of the above door to it's array list */
            Passage passage = (Passage) mainDoors.get(i * 2 + 1).getSpace(1);
            mainPassages.add(passage);

            /* Store the passage's description in it's array list */
            passageDescriptions.add(mainPassages.get(i + 1).getDescription());

            /* Print all passages except for the one following the fivth chamber */
            if (i != 4) {
                System.out.println("Passage " + pathNum + ":");
                
                System.out.println(passageDescriptions.get(i + 1));
            }

            /* add the exit door of the passage to it's array list */
            passage = (Passage) mainChambers.get(i).getExitDoor().getSpace(1);
            mainDoors.add(passage.getExitDoor());

        }
    }
}
