package maze;

/**
 * Created by Pete Wilcox on 2/28/2016.
 * petercwilcox@gmail.com
 */
public class MazeTester
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(10, 10);
    }
}

/* Program output:
NOTE: I omitted a whole lot of repetitive output here, I think it's pretty clear what the output looks like.

Creating a 10x10 maze with 100 rooms.
Created [0,0]
...
Created [9,9]
Start: [0,3]
Finish: [9,4]
Connecting [5,7] and [5,8].
[5,7]'s tree size: 1. Merging [5,8] at size 1.
...
Connecting [5,0] and [6,0].
[5,0]'s tree size: 87. Merging [7,0] at size 6.
Connecting [5,8] and [5,9].
[5,8]'s tree size: 93. Merging [4,9] at size 2.
Connecting [9,4] and [9,5].
[9,5]'s tree size: 95. Merging [9,4] at size 1.
Connecting [9,3] and [9,4].
[9,4]'s tree size: 96. Merging [8,2] at size 3.
Connecting [0,0] and [0,1].
[0,1]'s tree size: 99. Merging [0,0] at size 1.
All rooms connected, displaying maze:
____________________
| | |      _ _ _   _|
|  _  |_|_|     |_ _|
| | |    _| | |_|_  |
|_  |_| |_  |     | |
|_  |_ _|_  |_| |_| |
| |     | |_|    _ _|
|_ _| |  _ _| | |  _|
|_  | |  _   _|  _ _|
| |  _| |_  |_ _  | |
|_ _|_ _|_ _|_ _ _ _|
Start: [0,3], root: [1,3]
Finish: [9,4], root: [1,3]

Process finished with exit code 0
 */