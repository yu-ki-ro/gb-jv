package HW_6;

import HW_6.work3.Greeter;
import HW_6.work1.Rectangle;
import HW_6.work1.Square;
import HW_6.work3.GreetingIntimate;

public class Main {
    public static void main(String[] args) {

        // I.work1
        Square square = new Square();
        square.setSide(3);
        System.out.println("Сторона квадрата: " + square.getSide());

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(35);
        rectangle.setWidth(6);
        System.out.println("Стороны прямоугольника: " + rectangle.getHeight() + " и " + rectangle.getWidth());

        // III.work3
        Greeter greeter = new Greeter();
        System.out.println(greeter.greet());
        greeter.setGreeting(new GreetingIntimate());
        System.out.println(greeter.greet());
    }
}