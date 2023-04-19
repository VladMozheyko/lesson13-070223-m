import java.util.Objects;

public class Car {
    private int price;                                   // Поля класса
    private double speed;
    private String brand;

    public Car(int price, double speed, String brand) {
        this.price = price;                             // Присваиваем значения полям(инициализируем)
        this.speed = speed;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Double.compare(car.speed, speed) == 0 && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, speed, brand);
    }

    @Override                                          // Указываем, что метод переопределен
    public String toString() {
        return                                         // Теперь метод toString класса Object будет возвращать текстовое представление нашего объекта
                 "price=" + price +
                ", speed=" + speed +
                ", brand='" + brand + '\'';
    }

}
