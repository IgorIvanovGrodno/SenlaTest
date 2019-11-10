/*
 * Solution
 * Класс создает список вещей(Thing), предназначенных для размещения в рюкзаке(Backpack).
 * И передает этот список в метод Backpack для размещения вещей с максимизацией суммарной ценности
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 */
package test.task6;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        //Создаем список вещей, которые будут переданы для упаковки в рюкзак Backpack
        ArrayList<Thing> listThing = new ArrayList<>();
        listThing.add(new Thing(5,3,"compass"));
        listThing.add(new Thing(10,5,"knife"));
        listThing.add(new Thing(6,4,"water"));
        listThing.add(new Thing(5,2,"smartphone"));

        //Создаем рюкзак грузоподъемностью 14
        Backpack backpack = new Backpack(14);

        //Передаем список вещей для размещения их в рюкзаке с максимизацией суммарной ценности
        backpack.maximizationValueFilling(listThing);

        //Выводим на консоль содержимое рюкзака
        backpack.displayContaisThings();

    }


}
