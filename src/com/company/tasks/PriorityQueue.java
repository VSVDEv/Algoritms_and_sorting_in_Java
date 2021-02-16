package com.company.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * priority queue
 * Задача на программирование: очередь с приоритетами
 * Первая строка входа содержит число операций 1 <= n<= 10^5.
 * Каждая из последующих nn строк задают операцию одного из следующих двух типов:
 *Insert x, где 0 <= x <= 10^9 — целое число;
 * ExtractMax.
 * Первая операция добавляет число x в очередь с приоритетами, вторая — извлекает максимальное число и выводит его.
 * Sample Input:
 * 6
 * Insert 200
 * Insert 10
 * ExtractMax
 * Insert 5
 * Insert 500
 * ExtractMax
 * Sample Output:
 * 200
 * 500
 *
 *
 */
public class PriorityQueue {

    void run(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        java.util.PriorityQueue<Integer> task = new java.util.PriorityQueue<>((t0, t1) -> -Integer.compare(t0,t1));
        for(int i = 0; i < n; i++){
            String[] commands = in.nextLine().split(" ");
            if("Insert".equals(commands[0])){
                task.add(Integer.parseInt(commands[1]));
            }else{
                System.out.println(task.poll());
            }
        }
    }

    public static void main(String[] args) {
        new PriorityQueue().run();
    }
}
/*
Other
 */
class Main4 {
    static java.util.PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int actionsCounter = 0;
        if (input.hasNextLine()) {
            actionsCounter = Integer.parseInt(input.nextLine());
        }
        priorityQueue = new java.util.PriorityQueue<>(Collections.reverseOrder());
        List<String> actions = new ArrayList<>();
        for (int i = 0; i < actionsCounter; i++) {
            String action = input.nextLine();
            if (action.isEmpty()) {
                break;
            }
            actions.add(action);
        }
        process(actions);
    }

    private static void process(List<String> actions) {
        actions.forEach(action -> {
            if (action.equals("ExtractMax")) {
                System.out.println(priorityQueue.poll());
            } else if (action.contains("Insert ")) {
                priorityQueue.add(Integer.parseInt(action.split(" ")[1]));
            }
        });
    }
}