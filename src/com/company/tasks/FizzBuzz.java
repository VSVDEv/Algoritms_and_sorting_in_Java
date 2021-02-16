package com.company.tasks;

/**
 *
 *Необходимо реализовать функцию:
 *     • на вход функция получает целое число;
 *     • нужно вывести в консоль слово Fizz, если число кратно трем;
 *     • нужно вывести в консоль слово Buzz, если число кратно пяти;
 *     • нужно вывести в консоль слово FizzBuzz, если число кратно трем и пяти одновременно;
 *     • если число не кратно ни трем, ни пяти, вывести это число.
 *
 *
 */
public class FizzBuzz {

    void fizzBuzzPrint(int i){
        if(i % 15 == 0){
            System.out.println("FizzBuzz");
        }else if(i % 3 == 0){
            System.out.println("Fizz");
        }else if(i % 5 == 0){
            System.out.println("Buzz");
        }else{ System.out.println(i);
        }
    }

    void fizzBuzzPrint1(int i){
        if(i % 5 == 0 & i % 3 == 0)
            System.out.println("FizzBuzz");
        else if(i % 3 == 0)
            System.out.println("Fizz");
        else if(i % 5 == 0) System.out.println("Buzz");
        else System.out.println(i);

    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzzPrint(3);
        fizzBuzz.fizzBuzzPrint1(3);
        fizzBuzz.fizzBuzzPrint1(4);
        fizzBuzz.fizzBuzzPrint(4);
        fizzBuzz.fizzBuzzPrint(15);
        fizzBuzz.fizzBuzzPrint1(15);
        fizzBuzz.fizzBuzzPrint(5);
        fizzBuzz.fizzBuzzPrint1(5);
    }
}
