package ru.stqa.sandbox;

public class Distance
{
    public static void main(String[] args)
    {
        Point A = new Point(5,6);
        Point B = new Point(1,3);
        System.out.println("Distance between points: " + A.distance(B));
    }
}