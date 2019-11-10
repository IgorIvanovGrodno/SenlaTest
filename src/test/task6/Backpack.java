/*
 * Backpack
 * Класс представляет собой рюкзак определенной грузоподъемности.
 * Рюкзак содержит набор помещенных в него вещей и имеет функцию,
 * которая помещает в рюкзак вещи с максимизацией суммарной ценности.
 *
 * Автор: Иванов Игорь
 * Контакты: igor.ivanov.grodno@gmail.com
 */

package test.task6;

import java.util.ArrayList;

public class Backpack {
    private int carryingCapacityMax;
    private int summaryValue;
    private ArrayList<Thing> containsThings;

    public Backpack(int carryingCapacity){
        this.carryingCapacityMax = carryingCapacity;
        containsThings = new ArrayList<>();
        summaryValue=0;
    }

    /*
    * Метод принимает список вещей. С учетом
    * их веса и ценности метод добавляет в containsThings
    * только те вещи, добавление которых даст максимальную
    * суммарную ценность.
    */
    public void maximizationValueFilling(ArrayList<Thing> things) {
        int numberItems = things.size();

        //Создаем таблицу суммарных ценностей в зависимости от количества элементов и грузоподъемности рюкзака.
        //С помощью таблицы будем искать максимальную суммарную ценность, которая будет находится после заполнения
        // в элементе mtrix[numberItems][carryingCapacityMax]
        int[][] matrix = new int[numberItems + 1][carryingCapacityMax + 1];

        //Инициализируем первую линию нулями
        for (int i = 0; i <= carryingCapacityMax; i++) {
            matrix[0][i] = 0;
        }

        //Заполняем таблицу
        for (int i = 1; i <= numberItems; i++) {
            for (int j = 0; j <= carryingCapacityMax; j++) {

                //Если вес элемента больше чем вместимость рюкзака, то добавляем в ячейку значение из предыдущей линии
                if (things.get(i-1).getWeight() > j)
                    matrix[i][j] = matrix[i - 1][j];

                //Иначе определяем: суммарная ценность будет выше с добавлением текущего элемента, или без его добавления(значение из предыдущей линии)
                //Ячейке присваиваем максимальное значение
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - things.get(i-1).getWeight()] +
                            things.get(i-1).getValue());
            }
        }
        summaryValue = matrix[numberItems][carryingCapacityMax];

        //Определив максимально возможную суммарную ценность, определяем вещи которые нужно добавить в рюкзак
        int bufValue = summaryValue;
        int bufCapacity = carryingCapacityMax;

        for (int i = numberItems; i > 0  &&  bufValue > 0; i--) {

            //Если значение в текущей ячейке и в ячейке в предыдущей линии не равны, то добавление текущего элемента
            // максимизирует суммарную ценность и мы его добавляем в рюкзак
            if (bufValue != matrix[i-1][bufCapacity]) {
                containsThings.add(things.get(i-1));

                //Минусуем грузоподъемность рюкзака и суммарную ценность, т.к. элемент был добавлен в рюкзак
                bufValue -= things.get(i-1).getValue();
                bufCapacity -= things.get(i-1).getWeight();
            }
        }
    }

    /*
    * Метод выводит на консоль параметры рюкзака и его содержимое
    */
    public void displayContaisThings(){
        System.out.println("Backpack capacity="+ carryingCapacityMax+" values="+summaryValue+" contains:");
        for(Thing thing:containsThings){
            System.out.println(thing);
        }
    }

    public int getCarryingCapacity() {
        return carryingCapacityMax;
    }
}
