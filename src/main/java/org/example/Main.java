package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = 0;

        short max = 0;
        short nextValue = 0;

        boolean check = true;

        int[] cookies = new int[n];

        for (int i = 0; i < n; i++) {
            nextValue = scanner.nextShort();
            cookies[i] = nextValue;
            if (max < nextValue) {
                max = nextValue;
            }
        }

        k = max;

        if (m < n) {
            System.out.println(0);
        } else if (m == n) {
            System.out.println(k);
        } else {
            System.out.println(findMininum(cookies, m, max));
        }

    }

    private static short findMininum(int[] cookies, int m, short max) {
        short left = 0;
        short right = max;
        short mid;
        short result = 0;

        while (left <= right) {
            mid = (short)(left + ((right - left) / 2));
            if (canEatAllCookies(cookies, mid, m)) {
                result = mid;
                right = (short)(mid - 1);
            } else {
                left  = (short)(mid + 1);
            }
        }
        return result;
    }

    private static boolean canEatAllCookies(int[] cookies, short mid, int m) {

        int steps = m;

        if(mid == 0) {
            return false;
        }

        for (int i = 0; i < cookies.length; i++) {
            steps -= cookies[i]/mid;
            if (cookies[i]%mid > 0) {
                steps -= 1;
            }
            if (steps < 0) {
                return false;
            }
        }
        return true;
    }

}
