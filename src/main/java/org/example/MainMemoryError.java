package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMemoryError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        Long m = scanner.nextLong();
        Integer k = 0;
        Long nForRead;

        Integer cnMax = 0;
        Integer nextValue = 0;

        Boolean check = true;

        List<Integer> integers = new LinkedList<>();

        nForRead = n;
        while (nForRead > 0) {
            nextValue = scanner.nextInt();
            integers.add(nextValue);
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
                check = checkList(integers, m, k);
                k -= 1;
            }
            System.out.println(k + 2);
        }
    }

    static boolean checkList(List<Integer> list, Long m, Integer k){
        Iterator<Integer> iterator = list.listIterator();

        Integer node;

        while (iterator.hasNext()) {
            node = iterator.next();
            while (node > 0 && m > 0) {
                m -= 1;
                node -= k;
            }

            if (node > 0 || m < 0) {
                return false;
            }
        }
        return true;
    }

}
