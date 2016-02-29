package maze;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Pete Wilcox on 2/27/2016.
 * petercwilcox@gmail.com
 */
public class Maze
{
    // This class creates a maze
    private int             width;
    private int             height;
    private int             size;
    private Room[][]        rooms;
    private Room            start;
    private Room            finish;
    private Random          roomSelector;
    private ArrayList<Room> roomList;


    // The maze is an array of Room objects
    private class Room
    {
        // Root of the tree
        Room root;

        // True if there is a wall on this side
        boolean up;
        boolean down;
        boolean right;
        boolean left;

        // Coordinates of the room
        int width;
        int height;

        // Size of the tree
        int size;

        public String toString()
        {
            return "[" + width + "," + height + "]";
        }

        boolean equals(Room p)
        {
            if (p.width == this.width && p.height == this.height)
            {
                return true;
            }
            return false;
        }
    }

    public Maze(int h, int w)
    {
        // Set the initial values of the maze
        this.width = h;
        this.height = w;
        size = this.width * this.height;
        rooms = new Room[this.width][this.height];
        roomList = new ArrayList<>();

        System.out.println("Creating a " + this.width + "x" + this.height + " maze with " + size + " rooms.");

        // Go through each room and record its height/width, set its walls to true
        for (int i = 0; i < this.width; ++i)
        {
            for (int j = 0; j < this.height; ++j)
            {
                rooms[i][j] = new Room();
                Room r = rooms[i][j];
                r.root = r;
                r.width = i;
                r.height = j;
                r.up = true;
                r.down = true;
                r.left = true;
                r.right = true;
                r.size = 1;
                roomList.add(r);
                System.out.println("Created " + r.toString());
            }
        }

        // Select random rooms for start and finish, these will be on opposite edges
        roomSelector = new Random();
        start = rooms[0][roomSelector.nextInt(this.height)];
        finish = rooms[this.width - 1][roomSelector.nextInt(this.height)];

        System.out.println("Start: " + start.toString());
        System.out.println("Finish: " + finish.toString());

        // Knock down random walls until every room is connected in one component
        while (roomList.size() > 0)
        {
            wallRemover(roomList.get(roomSelector.nextInt(roomList.size())));
        }

        System.out.println("All rooms connected, displaying maze:");

        displayMaze();
    }

    // Knocks down the right or down wall of a given room
    private void wallRemover(Room r)
    {
        // Go through the four walls of the room, if we can knock one down, do so and return
        if (r.width < this.width - 2)
        {
            if (r.right == true)
            {
                if (!connected(r, rooms[r.width + 1][r.height]))
                {
                    r.right = false;
                    rooms[r.width + 1][r.height].left = false;
                    union(r, rooms[r.width + 1][r.height]);
                    System.out
                            .println("Connecting " + r.toString() + " with " + rooms[r.width + 1][r.height].toString());
                    return;
                }
            }
        }

        if (r.height < this.height - 2)
        {
            if (r.down == true)
            {
                if (!connected(r, rooms[r.width][r.height + 1]))
                {
                    r.down = false;
                    rooms[r.width][r.height + 1].up = false;
                    union(r, rooms[r.width][r.height + 1]);
                    System.out
                            .println("Connecting " + r.toString() + " with " + rooms[r.width][r.height + 1].toString());
                    return;
                }
            }
        }

        if (r.height > 0)
        {
            if (r.up == true)
            {
                if (!connected(r, rooms[r.width][r.height - 1]))
                {
                    r.up = false;
                    rooms[r.width][r.height - 1].down = false;
                    union(r, rooms[r.width][r.height - 1]);
                    System.out
                            .println("Connecting " + r.toString() + " with " + rooms[r.width][r.height - 1].toString());
                    return;
                }
            }
        }

        if (r.width > 0)
        {
            if (r.left == true)
            {
                if (!connected(r, rooms[r.width - 1][r.height]))
                {
                    r.left = false;
                    rooms[r.width -1][r.height].right = false;
                    union(r, rooms[r.width-1][r.height]);
                    System.out
                            .println("Connecting " + r.toString() + " with " + rooms[r.width-1][r.height].toString());
                    return;
                }
            }
        }
        System.out.println("Can't knock down walls in " + r.toString());
        roomList.remove(r);

    }

    // Return true if two rooms are in the same tree
    private boolean connected(Room p, Room q)
    {
        if (root(p) == root(q))
        {
            return true;
        }
        return false;
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

        // Figure out which tree is smaller, join it to the larger tree
        if (pRoot.size >= rRoot.size)
        {
            rRoot.root = pRoot;
            rRoot.size += pRoot.size;
        }
        else
        {
            pRoot.root = rRoot;
            pRoot.size += rRoot.size;
        }
    }

    // Show the maze at the end
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
                if (rooms[j][i].down)
                {
                    System.out.print('_');
                }
                else
                {
                    System.out.print(' ');
                }
                if (rooms[j][i].right)
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