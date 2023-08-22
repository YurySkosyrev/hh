package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        Integer k = 0;
        Integer nForRead;

        Integer cnMax = 0;
        Integer nextValue = 0;

        Boolean check = true;

        int[] integers = new int[n];

        nForRead = n;
        while (nForRead > 0) {
            nextValue = scanner.nextInt();
            integers[n-nForRead] = nextValue;
            if (cnMax < nextValue) {
                cnMax = nextValue;
            }
            nForRead--;
        }

        k = cnMax;

        if (m < n) {
            System.out.println(0);
        } else if (m == n) {
            System.out.println(k);
        } else {
            while (check) {
                check = checkList(integers, n, m, k);
                k -= 1;
            }
            System.out.println(k + 2);
        }
    }

    static boolean checkList(int[] array, Integer n, Integer m, Integer k){

        int node;
        Integer i = 0;

        while (i < n) {
            node = array[i];
            while (node > 0 && m > 0) {
                m -= 1;
                node -= k;
            }

            if (node > 0 || m < 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }
}
