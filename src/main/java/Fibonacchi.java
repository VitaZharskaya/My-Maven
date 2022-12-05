import java.util.ArrayList;
import java.util.List;

public class Fibonacchi {
    //        Написать программу для вывода ряда Фиббоначи с 0 до заданного значения. Для примера можно взять 610

    public static List<Integer> fibo(int n){

        List<Integer> fibo = new ArrayList();
        fibo.add(0);
        fibo.add(1);
        for (int i = 1; fibo.get(i) < 610; i++) {

            fibo.add(fibo.get(i) + fibo.get(i - 1));

        }
        return fibo;
    }



    public static void main(String[] args) {
        System.out.println(fibo(610));
    }
}
