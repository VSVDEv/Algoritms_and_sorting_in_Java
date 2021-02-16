package com.company.algoritms.deykstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


/** * Sample Input:
 *
 * 4 8
 * 1 2 6
 * 1 3 2
 * 1 4 10
 * 2 4 4
 * 3 1 5
 * 3 2 3
 * 3 4 8
 * 4 2 1
 * 1 4
 * Sample Output:
 *
 * 9
 *
 */
public class FindShortWay4 {

    public static void main(String[] args) {
        int[] graphData = null;
        int[] taskCoordinates = null;
        Integer[][] edges = null;
        try (Scanner s = new Scanner(System.in)) {
            if (s.hasNextLine()) {
                String[] line = s.nextLine().split(" ");
                // получаем данные о графе(число вершин и число ребер)
                graphData = Stream.of(line).mapToInt(Integer::parseInt).toArray();
                // создаем матрицу смежности, длинну ребер используем как флаг существования связи между вершинами
                edges = new Integer[graphData[0]][graphData[0]];
                for (int i = 0; i < graphData[1]; i++) {
                    line = s.nextLine().split(" ");
                    edges[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = Integer.parseInt(line[2]);
                }
                // получаем данные о исходной и конечной точке задачи
                line = s.nextLine().split(" ");
                taskCoordinates = Stream.of(line).mapToInt(Integer::parseInt).toArray();
                // для удобства работы с матрицей
                taskCoordinates[0] = taskCoordinates[0] - 1;
                taskCoordinates[1] = taskCoordinates[1] - 1;
            } else {
                System.out.printf("%s", -1);
                return;
            }
        }

        Map<Integer, NodeStat> nodeMinPaths = new HashMap<>();
        // устанавливаем стартовый нод для обхода графа
        int currentNode = taskCoordinates[0];
        for (int i = 0; i < graphData[0]; i++) {
            if (i == taskCoordinates[0]) {
                nodeMinPaths.put(i, new NodeStat(0));
            } else {
                nodeMinPaths.put(i, new NodeStat());
            }
        }

        // пока есть неотмеченные ноды до которых можно добраться
        while (true) {
            // вычислить все ноды сопряженных с активным
            for (int i = 0; i < graphData[0]; i++) {
                int newPathDistance;
                if (edges[currentNode][i] != null) {
                    newPathDistance = edges[currentNode][i] + nodeMinPaths.get(currentNode).minPath;
                    nodeMinPaths.merge(i, new NodeStat(newPathDistance),
                            (old, incoming) -> old.minPath > incoming.minPath ? incoming : old);
                }
            }

            // отмечаем посещенный нод, проверяем является ли он "точкой назначения"
            nodeMinPaths.get(currentNode).isChecked = true;
            if (currentNode == taskCoordinates[1]) {
                System.out.print(nodeMinPaths.get(currentNode).minPath);
                return;
            }

            // выбираем новый нод из непосещенных
            int uncheckedGraphMinPath = Integer.MAX_VALUE;
            for (Map.Entry<Integer, NodeStat> nodeWithStat : nodeMinPaths.entrySet()) {
                if (nodeWithStat.getValue().minPath < uncheckedGraphMinPath && nodeWithStat.getValue().isChecked == false) {
                    uncheckedGraphMinPath = nodeWithStat.getValue().minPath;
                    currentNode = nodeWithStat.getKey();
                }
            }

            // проверям был ли найден хоть один путь меньший чем бесконечность
            if (uncheckedGraphMinPath == Integer.MAX_VALUE) {
                System.out.printf("%s", -1);
                return;
            }

        }
    }
}

class NodeStat {
    int minPath;
    boolean isChecked;

    public NodeStat() {
        this.minPath = Integer.MAX_VALUE;
        this.isChecked = false;
    }

    public NodeStat(int minPath) {
        this.minPath = minPath;
        this.isChecked = false;
    }
}