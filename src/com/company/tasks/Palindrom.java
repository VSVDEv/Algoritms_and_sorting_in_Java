package com.company.tasks;

/**
 *Палиндром - слово, которое одинаково читается в обоих направлениях.
 * Например:
 *     • 123454321
 *     • madam i’m Adam
 *     • Olson in Oslo
 * Необходимо реализовать функцию:
 *     • на вход функция получает строку;
 *     • нужно вывести в консоль слово yes, если строка является палиндромом;
 *     • нужно вывести в консоль слово no, если строка не является палиндромом;
 *     • при определении палиндрома игнорировать все пробелы, знаки препинания и апостроф.
 * Палиндром
 * Палиндром - слово, которое одинаково читается в обоих направлениях.
 * Например:
 *     • 123454321
 *     • madam i’m Adam
 *     • Olson in Oslo
 * Необходимо реализовать функцию:
 *     • на вход функция получает строку;
 *     • нужно вывести в консоль слово yes, если строка является палиндромом;
 *     • нужно вывести в консоль слово no, если строка не является палиндромом;
 *     • при определении палиндрома игнорировать все пробелы, знаки препинания и апостроф.
 *
 *
 *
 *
 */

public class Palindrom {

    void checkPalindrom(String s){
        String sb = new String(s);
        String str=sb.replaceAll("[^A-Za-z1-9]+", "");
        StringBuilder strbui=new StringBuilder( str );
        if (str.equalsIgnoreCase(strbui.reverse().toString())){
            System.out.println("yes");
        } else{
            System.out.println("no");
        }
    }

    void checkPalindrom1(String s){
        String san = s.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(new StringBuilder(san).reverse().toString().equalsIgnoreCase(san) ? "yes" : "no");
    }

    public static void main(String[] args) {
        Palindrom palindrom = new Palindrom();
        palindrom.checkPalindrom("123454321");
        palindrom.checkPalindrom1("123454321");
        palindrom.checkPalindrom1("madam i’m Adam");
        palindrom.checkPalindrom("madam i’m Adam");
        palindrom.checkPalindrom1("madam i’m Ada");
        palindrom.checkPalindrom("madam i’m Ada");
    }
}
