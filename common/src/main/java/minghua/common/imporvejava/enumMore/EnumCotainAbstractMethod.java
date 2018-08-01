package minghua.common.imporvejava.enumMore;

/**
 * @author: minghua
 * @date: 2018/7/24 7:59
 * @modified By:
 */
public enum EnumCotainAbstractMethod {

    PLUS
            {
                public double eval(double x, double y) {
                    return x + y;
                }
            },
    MINUS
            {
                public double eval(double x, double y) {
                    return x - y;
                }
            },
    TIMES
            {
                public double eval(double x , double y) {
                    return x * y;
                }
            },
    DIVIDE
            {
                public double eval(double x, double y) {
                    return x / y;
                }
            };

    public abstract double eval(double x, double y);
}
