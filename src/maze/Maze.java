package maze;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Pete Wilcox on 2/27/2016.
 * petercwilcox@gmail.com
 */
public class Maze
{
    /* This class creates a maze of N*M size by randomly knocking down connecting walls until all rooms are connected
        to each other.
     */

    // Basic info for the maze
    private int             width;
    private int             height;
    private int             size;

    // The array of rooms
    private Room[][]        rooms;

    // The list of walls
    private ArrayList<Wall> walls;

    // References to the start and finish
    private Room            start;
    private Room            finish;

    // Helper stuff
    private Random          random;
    private int             roomId;

    // The maze is an array of Room objects
    private class Room
    {
        // Root of the tree
        Room root;

        // References to the walls, it's ok for these to be null
        Wall up;
        Wall down;
        Wall right;
        Wall left;

        // Coordinates of the room
        int width;
        int height;

        // Size of the tree
        int size;

        // Each room has a unique ID to make checking for roots easy
        int id;

        public String toString()
        {
            return "[" + width + "," + height + "]";
        }

        boolean equals(Room p)
        {
            return p.id == this.id;
        }
    }

    // Not much to this class, it just holds references to the adjoining rooms and makes other methods easier to use
    private class Wall
    {
        Room up;
        Room down;
        Room left;
        Room right;
    }

    // Everything is done as part of the constructor
    public Maze(int h, int w)
    {
        // Set the initial values of the maze
        this.width = h;
        this.height = w;
        size = this.width * this.height;
        rooms = new Room[this.width][this.height];
        walls = new ArrayList<>();

        // Initial value
        roomId = 0;

        System.out.println("Creating a " + this.width + "x" + this.height + " maze with " + size + " rooms.");

        // Go through each room and record its height/width, set its walls to true
        for (int i = 0; i < this.width; ++i)
        {
            for (int j = 0; j < this.height; ++j)
            {
                // Create the room
                rooms[i][j] = new Room();
                Room r = rooms[i][j];
                r.root = r;
                r.width = i;
                r.height = j;
                r.id = roomId++;

                // Set its tree size to 0
                r.size = 1;

                // Assign references to walls, creating them if necessary
                r.right = new Wall();
                r.down = new Wall();
                walls.add(r.right);
                walls.add(r.down);

                // The if blocks check for the edges of the grid
                if (i == 0)
                {
                    r.left = new Wall();

                    walls.add(r.left);
                }
                else
                {
                    r.left = rooms[i - 1][j].right;

                }
                if (j == 0)
                {
                    r.up = new Wall();

                    walls.add(r.up);
                }
                else
                {
                    r.up = rooms[i][j - 1].down;

                }

                // Set the wall references
                r.up.down = r;
                r.left.right = r;
                r.down.up = r;
                r.right.left = r;

                System.out.println("Created " + r.toString());
            }
        }

        // Select random rooms for start and finish, these will be on opposite edges
        random = new Random();
        start = rooms[0][random.nextInt(this.height)];
        finish = rooms[this.width - 1][random.nextInt(this.height)];

        System.out.println("Start: " + start.toString());
        System.out.println("Finish: " + finish.toString());

        // Knock down random walls until every room is connected in one component
        while (start.root.size < this.size && walls.size() > 1)
        {
            wallRemover(walls.get(random.nextInt(walls.size())));
        }

        System.out.println("All rooms connected, displaying maze:");

        // Display the maze at the end
        displayMaze();
        System.out.print('\n');
        System.out.println("Start: " + start + ", root: " + root(start));
        System.out.println("Finish: " + finish + ", root: " + root(finish));
    }

    // Knocks down the wall unless a) the rooms are already connected b) it's the edge of the maze
    private void wallRemover(Wall w)
    {
        if (w.up != null && w.down != null)
        {
            if (!connected(w.up, w.down))
            {
                union(w.up, w.down);
                w.up.down = null;
                w.down.up = null;
                w.up = null;
                w.down = null;
                walls.remove(w);
                return;
            }
        }

        if (w.right != null && w.left != null)
        {
            if (!connected(w.left, w.right))
            {
                union(w.left, w.right);
                w.left.right = null;
                w.right.left = null;
                w.left = null;
                w.right = null;
                walls.remove(w);
                return;
            }
        }

        // If it can't execute the above if blocks, that means we don't need to look at this wall again.
        walls.remove(w);
    }

    // Return true if two rooms are in the same tree
    private boolean connected(Room p, Room q)
    {
        return root(p) == root(q);
    }

    // Returns root of a room's tree
    private Room root(Room p)
    {
        while (!p.root.equals(p))
        {
            p = p.root;
        }
        return p;
    }

    // Join two trees
    private void union(Room p, Room r)
    {
        Room pRoot = root(p);
        Room rRoot = root(r);

        // If the two rooms have the same root, do nothing
        if (pRoot.equals(rRoot))
        {
            return;
        }

        System.out.println("Connecting " + p + " and " + r + ".");

        // Figure out which tree is smaller, join it to the larger tree
        if (pRoot.size >= rRoot.size)
        {
            System.out
                    .println(p + "'s tree size: " + pRoot.size + ". Merging " + rRoot + " at size " + rRoot.size + ".");
            rRoot.root = pRoot;
            pRoot.size += rRoot.size;
        }
        else
        {
            System.out
                    .println(r + "'s tree size: " + rRoot.size + ". Merging " + pRoot + " at size " + pRoot.size + ".");
            pRoot.root = rRoot;
            rRoot.size += pRoot.size;
        }
    }

    // Show the maze at the end - I wish I was better at ASCII art so this wasn't quite so ugly
    private void displayMaze()
    {
        for (int i = 0; i < width; ++i)
        {
            System.out.print('_');
            System.out.print('_');
        }


        for (int i = 0; i < height; ++i)
        {
            System.out.print('\n');
            System.out.print('|');
            for (int j = 0; j < width; ++j)
            {
                if (rooms[j][i].down != null)
                {
                    System.out.print('_');
                }
                else
                {
                    System.out.print(' ');
                }
                if (rooms[j][i].right != null)
                {
                    System.out.print('|');
                }
                else
                {
                    System.out.print(' ');
                }

            }
        }

    }
}