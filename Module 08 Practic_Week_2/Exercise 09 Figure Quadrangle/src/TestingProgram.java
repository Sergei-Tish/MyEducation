import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class TestingProgram {
    @Test
    public void testFigureInterface() {
        boolean check = Modifier.isInterface(Figure.class.getModifiers());

        Method[] methods = Figure.class.getDeclaredMethods();
        Map<String, String> mDict = new HashMap<>();

        for (Method method : methods) {
            mDict.put(method.getName(), method.getReturnType().getName());
        }

        check = check && mDict.containsKey("area") && mDict.containsKey("perimeter");
        if (check) check = check && mDict.get("area").equals("double") && mDict.get("perimeter").equals("double");

        Assert.assertTrue("The Figure interface is incorrect", check);
    }

    @Test
    public void testQuadrangleClass() {
        boolean check = Modifier.isAbstract(Quadrangle.class.getModifiers()) && Quadrangle.class.getConstructors().length > 0;

        Field[] fields = Quadrangle.class.getDeclaredFields();
        Map<String, String> fDict = new HashMap();

        Method[] methods = Quadrangle.class.getDeclaredMethods();
        Map<String, String> mDict = new HashMap();

        for (Field field : fields) {
            fDict.put(field.getName(), field.getType().getName());
        }

        for (Method method : methods) {
            if (method.getName().equals("getColor") ||
                    method.getName().equals("getHeight") ||
                    method.getName().equals("getLargeDiagonal"))
                check = check && Modifier.isAbstract(method.getModifiers());

            mDict.put(method.getName(), method.getReturnType().getName());
        }

        check = check && fDict.containsKey("a") && fDict.containsKey("b") && fDict.containsKey("color") &&
                mDict.containsKey("getColor") && mDict.containsKey("getHeight") && mDict.containsKey("getLargeDiagonal");

        if (check) check = check && fDict.get("a").equals("int") && fDict.get("b").equals("int") &&
                fDict.get("color").equals("java.lang.String") && mDict.get("getColor").equals("java.lang.String") &&
                mDict.get("getHeight").equals("double") && mDict.get("getLargeDiagonal").equals("double");

        Assert.assertTrue("The Quadrangle class is incorrect", check);
    }

    @Test
    public void testSquareClass() {
        boolean check = Square.class.getSuperclass().getSimpleName().equals("Quadrangle") &&
                Square.class.getInterfaces().length > 0;

        Constructor constructor = null;
        try {
            constructor = Square.class.getConstructor(int.class, String.class);
        } catch (NoSuchMethodException e) {
            check = false;
            Assert.assertTrue("The Square class is incorrect", check);
        }
        Parameter[] params = constructor.getParameters();
        check = check && params.length == 2;

        Assert.assertTrue("The Square class is incorrect", check);
    }

    @Test
    public void testRectangleClass() {
        boolean check = Rectangle.class.getSuperclass().getSimpleName().equals("Quadrangle") &&
                Rectangle.class.getInterfaces().length > 0;

        Constructor constructor = null;
        try {
            constructor = Rectangle.class.getConstructor(int.class, int.class, String.class);
        } catch (NoSuchMethodException e) {
            check = false;
            Assert.assertTrue("The Rectangle class is incorrect", check);
        }
        Parameter[] params = constructor.getParameters();
        check = check && params.length == 3;

        Assert.assertTrue("The Rectangle class is incorrect", check);
    }

    @Test
    public void testRhombusesClass() {
        boolean check = Rhombuses.class.getSuperclass().getSimpleName().equals("Quadrangle") &&
                Rhombuses.class.getInterfaces().length > 0;

        Constructor constructor = null;
        try {
            constructor = Rhombuses.class.getConstructor(int.class, double.class, double.class, String.class);
        } catch (NoSuchMethodException e) {
            check = false;
            Assert.assertTrue("The Rhombuses class is incorrect", check);
        }
        Parameter[] params = constructor.getParameters();
        check = check && params.length == 4;

        Field[] fields = Rhombuses.class.getDeclaredFields();
        Map<String, String> fDict = new HashMap();

        for (Field field : fields) {
            fDict.put(field.getName(), field.getType().getName());
        }

        check = check && fDict.containsKey("alpha") && fDict.containsKey("beta");
        if (check) check = check && fDict.get("alpha").equals("double") && fDict.get("beta").equals("double");

        Assert.assertTrue("The Rhombuses class is incorrect", check);
    }

    @Test
    public void testParallelogramClass() {
        boolean check = Parallelogram.class.getSuperclass().getSimpleName().equals("Quadrangle") &&
                Parallelogram.class.getInterfaces().length > 0;

        Constructor constructor = null;
        try {
            constructor = Parallelogram.class.getConstructor(int.class, int.class, double.class, double.class, String.class);
        } catch (NoSuchMethodException e) {
            check = false;
            Assert.assertTrue("The Parallelogram class is incorrect", check);
        }
        Parameter[] params = constructor.getParameters();
        check = check && params.length == 5;

        Field[] fields = Parallelogram.class.getDeclaredFields();
        Map<String, String> fDict = new HashMap();

        for (Field field : fields) {
            fDict.put(field.getName(), field.getType().getName());
        }

        check = check && fDict.containsKey("alpha") && fDict.containsKey("beta");
        if (check) check = check && fDict.get("alpha").equals("double") && fDict.get("beta").equals("double");

        Assert.assertTrue("The Parallelogram class is incorrect", check);
    }

    @Test
    public void testSquareObject() {
        boolean check;
        Square square = new Square(1, "Blue");
        check = square.getColor().equals("Blue") && square.getHeight() == 1 &&
                square.getLargeDiagonal() == Math.sqrt(2) && square.area() == 1 && square.perimeter() == 4;

        Assert.assertTrue("Some methods in Square is incorrect", check);
    }

    @Test
    public void testRectangleObject() {
        boolean check;
        Rectangle rectangle = new Rectangle(1, 3, "Red");
        Rectangle rectangle2 = new Rectangle(3, 1, "Red");
        check = rectangle.getColor().equals("Red") && rectangle.getHeight() == 1 &&
                rectangle.getLargeDiagonal() == Math.sqrt(10) && rectangle.area() == 3 && rectangle.perimeter() == 8 &&
                rectangle2.getColor().equals("Red") && rectangle2.getHeight() == 1 &&
                rectangle2.getLargeDiagonal() == Math.sqrt(10) && rectangle2.area() == 3 && rectangle2.perimeter() == 8;

        Assert.assertTrue("Some methods in Rectangle is incorrect", check);
    }

    @Test
    public void testRhombusesObject() {
        boolean check;
        Rhombuses rhombuses = new Rhombuses(1, 60, 120, "Pink");
        Rhombuses rhombuses1 = new Rhombuses(1, 90, 90, "Pink");
        Rhombuses rhombuses2 = new Rhombuses(2, 60, 120, "Pink");

        check = rhombuses.getColor().equals("Pink") && rhombuses.getHeight() == Math.sqrt(3) / 2 &&
                rhombuses.getLargeDiagonal() > 1.73 && rhombuses.getLargeDiagonal() < 1.74 && rhombuses.area() == Math.sqrt(3) / 2 &&
                rhombuses.perimeter() == 4 &&
                rhombuses1.getColor().equals("Pink") && rhombuses1.getHeight() == 1 &&
                rhombuses1.getLargeDiagonal() > 1.4142 && rhombuses1.getLargeDiagonal() < 1.4143 &&
                rhombuses1.area() == 1 && rhombuses1.perimeter() == 4 &&
                rhombuses2.getColor().equals("Pink") && rhombuses2.getHeight() == 2 * Math.sqrt(3) / 2 &&
                rhombuses2.getLargeDiagonal() > 3.46 && rhombuses2.getLargeDiagonal() < 3.47 &&
                rhombuses2.area() == 2 * Math.sqrt(3) && rhombuses2.perimeter() == 8;

        Assert.assertTrue("Some methods in Rhombuses is incorrect", check);
    }

    @Test
    public void testParallelogramObject() {
        boolean check;
        Parallelogram parallelogram = new Parallelogram(1, 2, 60, 120, "Pink");
        Parallelogram parallelogram1 = new Parallelogram(2, 1, 60, 120, "Pink");
        Parallelogram parallelogram2 = new Parallelogram(1, 2, 90, 90, "White");
        Parallelogram parallelogram3 = new Parallelogram(2, 3, 60, 120, "Pink");

        check = parallelogram.getColor().equals("Pink") &&
                parallelogram.getHeight() >= 0.86 && parallelogram.getHeight() <= 0.87 &&
                parallelogram.getLargeDiagonal() >= 2.64 && parallelogram.getLargeDiagonal() <= 2.65 &&
                parallelogram.area() >= 1.73 && parallelogram.area() <= 1.74 &&
                parallelogram.perimeter() == 6 &&

                parallelogram1.getColor().equals("Pink") &&
                parallelogram1.getHeight() >= 0.86 && parallelogram1.getHeight() <= 0.87 &&
                parallelogram1.getLargeDiagonal() >= 2.64 && parallelogram1.getLargeDiagonal() <= 2.65 &&
                parallelogram1.area() >= 1.73 && parallelogram1.area() <= 1.74 &&
                parallelogram1.perimeter() == 6 &&

                parallelogram2.getColor().equals("White") &&
                parallelogram2.getHeight() == 1 &&
                parallelogram2.getLargeDiagonal() >= 2.23 && parallelogram2.getLargeDiagonal() <= 2.24 &&
                parallelogram2.area() == 2 &&
                parallelogram2.perimeter() == 6 &&

                parallelogram3.getColor().equals("Pink") &&
                parallelogram3.getHeight() >= 1.73 && parallelogram3.getHeight() <= 1.74 &&
                parallelogram3.getLargeDiagonal() >= 4.35 && parallelogram3.getLargeDiagonal() <= 4.36 &&
                parallelogram3.area() >= 5.19 && parallelogram3.area() <= 5.20 &&
                parallelogram3.perimeter() == 10;

        Assert.assertTrue("Some methods in Parallelogram is incorrect", check);
    }
}
