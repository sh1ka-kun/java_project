package ru.stqa.sandbox;

public class Distance
{
    public double p1;
    public double p2;

    public Distance(double p1, double p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    };

    public double distance()
    {
        return Math.sqrt(Math.pow(this.p1,2) + (Math.pow(this.p2,2)));
    }
}
