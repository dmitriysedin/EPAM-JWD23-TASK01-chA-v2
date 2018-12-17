package by.epam.dmitriysedin.task01.model.entity;

/**
 * Created by Dmitriy Sedin on 05.12.2018.
 */
public class Triangle {

    private Point2D apexA;
    private Point2D apexB;
    private Point2D apexC;

    public Triangle() {
    }

    public Triangle(Point2D apexA, Point2D apexB, Point2D apexC) {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }

    public Point2D getApexA() {
        return apexA;
    }

    public void setApexA(Point2D apexA) {
        this.apexA = apexA;
    }

    public Point2D getApexB() {
        return apexB;
    }

    public void setApexB(Point2D apexB) {
        this.apexB = apexB;
    }

    public Point2D getApexC() {
        return apexC;
    }

    public void setApexC(Point2D apexC) {
        this.apexC = apexC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (!apexA.equals(triangle.apexA)) return false;
        if (!apexB.equals(triangle.apexB)) return false;
        return apexC.equals(triangle.apexC);
    }

    @Override
    public int hashCode() {
        int result = apexA.hashCode();
        result = 31 * result + apexB.hashCode();
        result = 31 * result + apexC.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                '}';
    }
}
