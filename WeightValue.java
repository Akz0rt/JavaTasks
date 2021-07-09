import java.util.Scanner;

//Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
//Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
//Пример:
//Дан массив [1, 2, 3], и массив весов [1, 2, 10].
//В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».


public class WeightValue {

    private int[] array;

    public WeightValue(int[] values, int[] weights){
        int s = 0;
        for(int i = 0; i < weights.length; i++){
            s += weights[i];
        }
        int c = 0;
        array = new int[s];
        for(int i = 0; i < weights.length; i++){
            for(int k = 0; k < weights[i]; k++){
                array[c] = values[i];
                c += 1;
            }
        }
    }
    public int random(){
        int random = (int) (Math.random() * array.length);
        return array[random];
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int l = 3;
        int a = 0;
        int b = 0;
        int c = 0;
        int[] values = new int[l];
        int[] weights = new int[l];
        for(int i = 0; i < values.length; i++){
            System.out.println("Value #" + (i+1));
            values[i] = in.nextInt();
        }
        for(int i = 0; i < weights.length; i++){
            System.out.println("Weight of value #" + (i+1));
            weights[i] = in.nextInt();
        }
        for(int i = 0; i < 150; i++){
            int arr = new WeightValue(values, weights).random();
            if(arr == values[0]){
                a += 1;
            }
            else if (arr == values[1]){
                b += 1;
            }
            else if (arr == values[2]){
                c += 1;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}
