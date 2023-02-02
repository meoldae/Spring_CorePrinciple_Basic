package hello.core.singleton;

public class StatefulService {

    private int price; // Stateful field

    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 이 부분 주의의
    }

    public int getPrice() {
        return price;
    }
}
