package HW_1;

public class DrinkTemp extends HotDrink {
    private int temp;

    public DrinkTemp(String DrinkName, int volume, int temp) {
        super(DrinkName, volume);
        this.temp = temp;
    }

    public int gettemp() {
        return temp;
    }
}