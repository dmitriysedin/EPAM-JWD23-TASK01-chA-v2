package by.epam.dmitriysedin.task01.model.entity;

/**
 * Created by Dmitriy Sedin on 05.12.2018.
 */
public class Point2D {

    private double abscissa;
    private double ordinate;

    public Point2D() {
    }

    public Point2D(double abscissa, double ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public double getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(double abscissa) {
        this.abscissa = abscissa;
    }

    public double getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(double ordinate) {
        this.ordinate = ordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;

        Point2D point = (Point2D) o;

        if (Double.compare(point.abscissa, abscissa) != 0) return false;
        return Double.compare(point.ordinate, ordinate) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(abscissa);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ordinate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "abscissa=" + abscissa +
                ", ordinate=" + ordinate +
                '}';
    }
}
