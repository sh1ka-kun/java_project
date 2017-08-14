public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Distance between points is " + dist());
    }

    public static double dist()
    {
        Point p1 = new Point(6,2);
        Point p2 = new Point(3,3);
        return Math.sqrt(Math.pow(p1.distance(),2) + (Math.pow(p2.distance(),2)));
    }
}