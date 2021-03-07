package HomeWork_4;

public class Triangle {

    public static double triangleSquare(int a, int b, int c) {
        int p = (a + b + c);
        int s = p * (p - a) * (p - b) * (p - c);
        return Math.sqrt(s);
    }
}
