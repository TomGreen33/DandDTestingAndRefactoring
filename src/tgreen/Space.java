/* Name:       Thomas Green
    Student ID: 1048389
    Email:        tgreen12@uoguelph.ca */

package tgreen;

public abstract class Space {

    /**
     * Gets the description of this space.
     * @return the space's description.
     */
    public abstract  String getDescription();


    /**
     * Sets a door to this space.
     * @param theDoor the door to set.
     */
    public abstract void setDoor(Door theDoor);

}
