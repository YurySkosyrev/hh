package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> integers = new LinkedList<>();

        while (N > 0) {
            integers.add(scanner.nextInt());
            N--;
        }

        N = integers.size();

        System.out.println(integers);

    }

    static void bubbleSort(List<Integer> arr){
        for(int i = arr.size() -1; i >= 0; i--){
            for (int j = 0; j < i; j ++){
                if (arr.get(j)>arr.get(j+1)){
                    int tmp = arr.get(j);
                    arr.get(j) = arr.get(j+1);
                    arr. = tmp;
                }
            }
        }
    }
}
