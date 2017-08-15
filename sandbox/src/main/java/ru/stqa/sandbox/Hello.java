package ru.stqa.sandbox;

public class Hello
{
    public static void main(String[] args)
    {
        Point p = new Point(5,6,1,3);
        Distance d = new Distance(p.distance()[0], p.distance()[1]);
        System.out.println("Distance between points: " + d.distance());
    }
}