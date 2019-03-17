public class TestPlanet {
    public static void main(String[] args) {
        Planet x = new Planet(1.0e12, 2.0e11, 0, 0, 2.0e30,null);
        Planet y = new Planet(2.3e12, 9.5e11, 0, 0, 6.0e26, null);
        System.out.println(x.calcDistance(y));
        System.out.println(x.calcForceExertedBy(y));
        System.out.println(x.calcForceExertedByX(y));
    }
}
