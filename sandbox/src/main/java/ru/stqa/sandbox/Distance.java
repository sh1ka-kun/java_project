package ru.stqa.sandbox;

public class Distance
{
    public static void main(String[] args)
    {
        Point p = new Point(5,6,1,3);
        System.out.println("Distance between points: " + p.distance());
    }
}