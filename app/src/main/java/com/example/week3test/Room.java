package com.example.week3test;


import java.util.Stack;

public class Room {
    public final boolean isInfected;
    public boolean visited = false;

    Room(boolean infected) {
        isInfected = infected;
    }
    private static int getRegionSize(Room[][] floor, int row, int column) {
        if (row<0||column<0||row>=floor.length||column>=floor[row].length){
            return 0;
        }
        if (!floor[row][column].isInfected || floor[row][column].visited){
            return 0;
        }
        floor[row][column].visited = true;
        int size = 1;
        for (int r = row-1;r <= row +1; r++){
            for (int c = column-1; c<=column+1;c++){
                if (r != row || c!=column){
                    if (r == row || c == column){
                        size += getRegionSize(floor,r,c);
                    }

                }
            }
        }
        return size;

    }

    public static boolean isOutbreak(Room[][] floor) {
        int consecutiveInfectedRooms = 0;


        for (int row = 0; row <floor.length;row++){
            for (int column = 0; column<floor[row].length;column++){
               if (floor[row][column].isInfected &&!floor[row][column].visited){
                   int size = getRegionSize(floor,row,column);

                   //replace for check if
                   if (size>=5)
                       return true;
               }
            }
        }
        return false;
        /* This code works just not really
        int consecutiveInfectedRooms = 0;
        for (int i =0;i<floor.length;i++){
            for (int j =0;j<floor[i].length;j++){
                if (floor[i][j].isInfected){
                    consecutiveInfectedRooms = 1;
                    //check for 5 in a horozontal row
                    for (int z = 1; z<5 ;z++){
                        if (j+z<floor[i].length){
                            if (floor[i][j+z].isInfected){
                                consecutiveInfectedRooms++;
                            }
                        }
                    }
                    if (consecutiveInfectedRooms==5){
                        return true;
                    }
                    else {
                        consecutiveInfectedRooms = 1;
                    }

                    //check for 5 vertical in a row
                    for (int z = 1; z<5 ;z++){
                        if (i+z<floor.length){
                            if (floor[i+z][j].isInfected){
                                consecutiveInfectedRooms++;
                            }
                        }
                    }
                    if (consecutiveInfectedRooms==5){
                        return true;
                    }
                    else {
                        consecutiveInfectedRooms = 1;
                    }
                }

            }
        }

        return false;*/

    }




    public static void main(String[] args) {
        Room[][] verticalTrue = new Room[][] {
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }
        };
        Room[][] horizontalTrue = new Room[][] {
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }
        };
        Room[][] noInfection = new Room[][] {
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }
        };

        System.out.println("Horizontal outbreak test: " +isOutbreak(horizontalTrue) );
        System.out.println("Vertical outbreak test: " +isOutbreak(verticalTrue) );
        System.out.println("No outbreak test: " +isOutbreak(noInfection) );
    }
}