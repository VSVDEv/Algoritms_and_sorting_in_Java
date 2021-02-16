package com.company.tasks;

import java.util.*;

/**
 *Huffman coding
 * Задача на программирование: кодирование Хаффмана
 * По данной непустой строке s длины не более 10^4
 *  , состоящей из строчных букв латинского алфавита, постройте оптимальный беспрефиксный код.
 *  В первой строке выведите количество различных букв k, встречающихся в строке, и размер
 *  получившейся закодированной строки. В следующих kk строках запишите коды букв в формате "letter: code".
 *  В последней строке выведите закодированную строку.
 *input a
 * out
 * 1 1
 * a: 0
 * 0
 *
 */
public class HuffmanCoding {

class Node implements Comparable<Node> {
    final int sum;
    String code;

    void buildCode(String code) {
        this.code = code;
    }

    public Node(int sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(sum, o.sum);
    }
}

class InternalNode extends Node {
    Node left;
    Node right;

    public InternalNode(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = left;
        this.right = right;
    }

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + "0");
        right.buildCode(code + "1");
    }
}

class LeafNode extends Node {
    char symbol;

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        System.out.println(symbol + ": " + code);
    }

    public LeafNode(char symbol, int count) {
        super(count);
        this.symbol = symbol;
    }
}

    private void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(new InternalNode(first, second));
        }
        if (count.size() == 1) {
            sum = s.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        String encodedString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            encodedString += charNodes.get(c).code;
        }
        System.out.println(encodedString);
    }

    public static void main(String[] args) throws Exception {
        new HuffmanCoding().run();
    }
}

/*
Another
 */

abstract class Node {  //абстрактный класс для узла бинарного дерева. От него наследуются листья и узлы.
    abstract void find(Map<Character, String> bins); //метод для инициализации бинарных кодов

    String binName; //бинарный код узла
    final int weight;//вес для листьев равен частоте, для узлов сумме весов потомков

    Node(int weight) {
        this.weight = weight;
    }

}

class Leaf extends Node {
    private char ch; //изначальный символ

    @Override
    void find(Map<Character, String> bins) {
        bins.put(ch, binName);
    }

    Leaf(int weight, char ch) {
        super(weight);
        this.ch = ch;
    }
}

class InNode extends Node {
    private Node left; //children
    private Node right;

    InNode(Node left, Node right) {
        super(left.weight + right.weight);
        this.left = left;
        this.right = right;
    }

    @Override
    void find(Map<Character, String> bins) {
        left.binName = binName + "1";
        left.find(bins);
        right.binName = binName + "0";
        right.find(bins);
    }
}

 class Main2 {

    public static void main(String[] args) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.weight));
        String str = new Scanner(System.in).next();
        Map<Character, Integer> counts = new HashMap<>(); //тут храним счётчик для каждой буквы
        Map<Character, String> bins = new HashMap<>(); //финальный мап для бинарных кодов
        for (int i = 0; i < str.length(); i++) { //считаем буквы (можно через стримы сделать)
            char ch = str.charAt(i);
            if (counts.containsKey(ch)) counts.put(ch, counts.get(ch) + 1);
            else counts.put(ch, 1);
        }
        for (Character key : counts.keySet()) { //создаём листья и добавляем в очередь
            Leaf leaf = new Leaf(counts.get(key), key);
            queue.add(leaf);
        }
        while (queue.size() > 1) { //строим дерево
            Node left = queue.poll();
            Node right = queue.poll();
            queue.add(new InNode(left, right));
        }
        assert queue.size() == 1; //на этом моменте в очереде всего один элемент. Корень
        Node root = queue.poll();
        root.binName = (counts.size() > 1 ? "" : "0"); //Отдельно обрабатываем случай для одного элемента
        root.find(bins);//Запускаем инициализацию бинарных кодов

        //Дальше просто выводим на экран всё что просят
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            res.append(bins.get(str.charAt(i)));
        }
        System.out.println(counts.size() + " " + res.length());
        for (Character key : bins.keySet()) {
            System.out.println(key + ": " + bins.get(key));
        }
        System.out.println(res);
    }
}
