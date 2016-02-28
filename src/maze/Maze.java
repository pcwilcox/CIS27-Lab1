package maze;

import java.util.Random;

/**
 * Created by Pete Wilcox on 2/27/2016.
 * petercwilcox@gmail.com
 */
public class Maze
{
    // This class creates a maze
    private int      height;
    private int      width;
    private int      size;
    private Room[][] rooms;
    private Room     start;
    private Room     finish;
    private Random   roomSelector;

    private class Room
    {
        int     hid;
        int     wid;
        boolean up;
        boolean down;
        boolean right;
        boolean left;
        int     height;
        int     width;

        boolean equals(Room p)
        {
            if (p.height == this.height && p.width == this.width)
            {
                return true;
            }
            return false;
        }
    }

    public Maze(int h, int w)
    {
        // Set the initial values of the maze
        height = h;
        width = w;
        size = height * width;
        rooms = new Room[height][width];

        // Go through each room and record its height/width, set its walls to true
        for (int i = 0; i < height; ++i)
        {
            for (int j = 0; j < width; ++j)
            {
                Room r = rooms[i][j];
                r.hid = i;
                r.wid = j;
                r.height = i;
                r.width = j;
                r.up = true;
                r.down = true;
                r.left = true;
                r.right = true;
            }
        }

        // Select random rooms for start and finish, these will be on opposite edges
        roomSelector = new Random();
        start = rooms[0][roomSelector.nextInt(width)];
        finish = rooms[height][roomSelector.nextInt(width)];

        while (!connected(start, finish))
        {
            wallRemover(roomSelector.nextInt(height), roomSelector.nextInt(width));
        }
    }

    private void wallRemover(int h, int w)
    {

    }

    private boolean connected(Room p, Room q)
    {
        if (root(p) == root(q))
        {
            return true;
        }
        return false;
    }

    private Room root(Room p)
    {
        while (p.hid != p.height && p.wid != p.width)
        {
            p = rooms[p.hid][p.wid];
        }
        return p;
    }
}
