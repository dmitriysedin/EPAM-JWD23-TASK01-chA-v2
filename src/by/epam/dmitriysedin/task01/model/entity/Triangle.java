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
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (apexA != null ? !apexA.equals(triangle.apexA) : triangle.apexA != null) return false;
        if (apexB != null ? !apexB.equals(triangle.apexB) : triangle.apexB != null) return false;
        return apexC != null ? apexC.equals(triangle.apexC) : triangle.apexC == null;
    }

    @Override
    public int hashCode() {
        int result = apexA != null ? apexA.hashCode() : 0;
        result = 31 * result + (apexB != null ? apexB.hashCode() : 0);
        result = 31 * result + (apexC != null ? apexC.hashCode() : 0);
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
