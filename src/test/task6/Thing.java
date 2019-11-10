/*
 * Thing
 * Класс представляет собой вещь, которая имеет своё название, ценность, вес.
 * Она может быть помещена в коллекцию объекта Backpack
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 */
package test.task6;

public class Thing {
    private int weight;
    private int value;
    private String name;

    public Thing(int weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
