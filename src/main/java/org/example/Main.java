package org.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// Узел queue


class Main
{
    // Ниже массивы детализируют все четыре возможных перемещения из ячейки
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    // Функция проверки возможности перехода на позицию (строка, столбец)
    // от текущей позиции. Функция возвращает false, если (строка, столбец)
    // недопустимая позиция или имеет значение 0 или уже посещено.
    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col)
    {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == 0 && !visited[row][col];
    }

    // Находим кратчайший маршрут в матрице `mat` из источника
    // ячейка (i, j) в ячейку назначения (x, y)
    private static int findShortestPathLength(int[][] mat, int i, int j, int x, int y)
    {
        // базовый случай: неверный ввод
        if (mat == null || mat.length == 0 || mat[i][j] == 1 || mat[x][y] == 1) {
            return -1;
        }

        // Матрица `M × N`
        int M = mat.length;
        int N = mat[0].length;

        // создаем матрицу для отслеживания посещенных ячеек
        boolean[][] visited = new boolean[M][N];

        // создаем пустую queue
        Queue<Node> q = new ArrayDeque<>();

        // помечаем исходную ячейку как посещенную и ставим исходный узел в queue
        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        // сохраняет длину самого длинного пути от источника к месту назначения
        int min_dist = Integer.MAX_VALUE;

        // цикл до тех пор, пока queue не станет пустой
        while (!q.isEmpty())
        {
            // удалить передний узел из очереди и обработать его
            Node node = q.poll();

            // (i, j) представляет текущую ячейку, а `dist` хранит ее
            // минимальное расстояние от источника
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // если пункт назначения найден, обновляем `min_dist` и останавливаемся
            if (i == x && j == y)
            {
                min_dist = dist;
                break;
            }

            // проверяем все четыре возможных перемещения из текущей ячейки
            // и ставим в queue каждое допустимое движение
            for (int k = 0; k < 4; k++)
            {
                // проверяем, можно ли выйти на позицию
                // (i + row[k], j + col[k]) от текущей позиции
                if (isValid(mat, visited, i + row[k], j + col[k]))
                {
                    // отметить следующую ячейку как посещенную и поставить ее в queue
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int [][] mat = new int[n][m];

        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        int min_dist = findShortestPathLength(mat, y0, x0, y1, x1);


        if (min_dist != -1) {
            System.out.println(min_dist);
        } else {
            System.out.println(0);
        }
    }

    static class Node
    {
        // (x, y) представляет собой координаты ячейки матрицы, а
        // `dist` представляет их минимальное расстояние от источника
        int x, y, dist;

        Node(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}