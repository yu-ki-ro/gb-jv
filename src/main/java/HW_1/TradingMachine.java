package HW_1;

public interface TradingMachine {
    HotDrink getProduct(String DrinkName, int volume);
    DrinkTemp getProduct(String DrinkName, int volume, int temp);
}