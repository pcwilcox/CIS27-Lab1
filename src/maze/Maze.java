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
        Room    root;
        boolean up;
        boolean down;
        boolean right;
        boolean left;
        int     height;
        int     width;
        int     size;

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
                r.root = r;
                r.height = i;
                r.width = j;
                r.up = true;
                r.down = true;
                r.left = true;
                r.right = true;
                r.size = 1;
            }
        }

        // Select random rooms for start and finish, these will be on opposite edges
        roomSelector = new Random();
        start = rooms[0][roomSelector.nextInt(width)];
        finish = rooms[height][roomSelector.nextInt(width)];

        // Knock down random walls until every room is connected in one component
        while (start.root.size != this.size)
        {
            wallRemover(roomSelector.nextInt(height), roomSelector.nextInt(width));
        }

        displayMaze();
    }

    private void wallRemover(int h, int w)
    {
        if (h < height)
        {
            if (rooms[h][w].down == true)
            {
                if (!connected(rooms[h][w], rooms[h + 1][w]))
                {
                    rooms[h][w].down = false;
                    rooms[h + 1][w].up = false;
                    union(rooms[h][w], rooms[h + 1][w]);
                }
            }
        }
        else if (w < width)
        {
            if (rooms[h][w].right == true)
            {
                if (!connected(rooms[h][w], rooms[h][w + 1]))
                {
                    rooms[h][w].right = false;
                    rooms[h][w + 1].left = false;
                    union(rooms[h][w], rooms[h][w + 1]);
                }
            }
        }
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
        while (!p.root.equals(p))
        {
            p = p.root;
        }
        return p;
    }

    private void union(Room p, Room r)
    {
        Room pRoot = root(p);
        Room rRoot = root(r);
        if (pRoot.equals(rRoot))
        {
            return;
        }

        if (pRoot.size >= rRoot.size)
        {
            rRoot.root = pRoot;
            rRoot.size++;
        }
        else
        {
            pRoot.root = rRoot;
            pRoot.size++;
        }
    }

    private void displayMaze()
    {
        for (int i = 0; i < width; ++i)
        {
            System.out.print('_');
        }


        for (int i = 0; i < height; ++i)
        {
            System.out.print('\n');
            System.out.print('|');
            for (int j = 0; j < width; ++j)
            {
                if (rooms[i][j].down)
                {
                    System.out.print('_');
                }
                else
                {
                    System.out.print(' ');
                }
                if (rooms[i][j].right)
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