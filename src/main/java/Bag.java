/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    
    private String color;

    private int numberOfContents;

    private int capacity;

    private String[] contents;

    /**
     * Create a {@link Bag} with the specified color and capacity
     * @param color {@link String} color for this {@link Bag}
     * @param capacity capacity of this {@link Bag}
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        numberOfContents = 0;
        contents = new String[capacity];
    }

    /**
     * 
     * @return {@link String} color of this {@link Bag}
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @return capacity of this {@link Bag} as an int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 
     * @return number of contents of this {@link Bag} as an int
     */
    public int getNumberOfContents() {
        return numberOfContents;
    }

    /**
     * Sets the color of this {@link Bag} to the specified color
     * @param color {@link String} representation of the color to assign
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Tries to add an item to this {@link Bag}.
     * 
     * Adds the item as long as the {@link Bag} has capacity to hold it.
     * 
     * @param item {@link String} item to add
     * @return whether the item was added
     */
    public boolean addItem(String item) {
        if (numberOfContents < capacity) {
            contents[numberOfContents] = item;
            numberOfContents++;
            return true;
        }
        return false;
    }

    /**
     * Removes the last item from this {@link Bag}
     * @return the removed {@link String} item, or null if this {@link Bag} is empty
     */
    public String popItem() {
        if (numberOfContents > 0) {
            String lastItem = contents[numberOfContents - 1];
            contents[numberOfContents - 1] = null;
            numberOfContents--;
            return lastItem;
        }
        return null;
    }

    /**
     * Increase this {@link Bag}'s capacity by n.
     *
     * @param n the amount to increase this {@link Bag}'s capacity by
     */
    public void increaseCapacity(int n) {
        capacity += n;
        String[] newContents = new String[capacity];
        for (int i = 0; i < contents.length; i++) {
            newContents[i] = contents[i];
        }
        contents = newContents;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}