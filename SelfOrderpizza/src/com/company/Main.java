/* This program is developed to let user make pizza order */
/* There are several features that are going to be described in documentation and in comments of the source code */
/* Created by Nurmukhammad Aberkulov  */
package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
/*This part of the code is if user chooses to order pizza from menu*/

        /* Here I am declaring variables and some objects of the classes to input data from user*/
        int menuOrUnique,salamiN=0,taitiN=0,margaritaN=0,fourCheeseN=0,banditoN=0,colaN=0,fantaN=0;
        double sum = 0, userMoney;
        String choosenPizza,choosenDrink,choosenIngredient;
        System.out.print("If you would like to order pizza from the menu please enter '1', \n" +
                "If you want choose your own ingredients enter 2, \n" +
                "If you want to get random pizza and drink enter 3:  ");
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        menuOrUnique = scanInt.nextInt();
        Salami salami = new Salami();
        Taiti taiti = new Taiti();
        Margarita margarita = new Margarita();
        FourCheese fourCheese = new FourCheese();
        Bandito bandito = new Bandito();
        /*End*/


        if (menuOrUnique == 1){
            /*This part of the code is to list all the pizzas available */
            System.out.print(salami.pizzaId+". " +salami.name + ". Prise: " + salami.prize + " euros. Ingredients: " ); salami.nameIngreds();
            System.out.print(taiti.pizzaId+". " + taiti.name + ". Prise: " + taiti.prize + " euros. Ingredients: " ); taiti.nameIngreds();
            System.out.print(margarita.pizzaId+". " +margarita.name + ". Prise: " + margarita.prize + " euros. Ingredients: " ); margarita.nameIngreds();
            System.out.print(fourCheese.pizzaId+". " + fourCheese.name + ". Prise: " + fourCheese.prize + " euros. Ingredients: " ); fourCheese.nameIngreds();
            System.out.print(bandito.pizzaId+". " + bandito.name + ". Prise: " + bandito.prize + " euros. Ingredients: " ); bandito.nameIngreds();
            /* End */




            /*Here I am accepting order from user in the form of string because user may order more than one pizza.
             Than I am processing that String into array of integers.
             Simultaneously, I am increasing the number of pizzas that are ordered if user's input matches with pizzas ID.
             */
            System.out.print("Here are all the pizzas we have.\n" +
                    "If you want to make order please enter the corresponding number of the pizza or several times with space to order more than one: ");
            choosenPizza = scanStr.nextLine();
            // The string you want to be an integer array.
            String[] integerStrings = choosenPizza.split(" ");
            // Splits each spaced integer into a String array.
            int[] integers = new int[integerStrings.length];
            // Creates the integer array.
            for (int i = 0; i < integers.length; i++){
                integers[i] = Integer.parseInt(integerStrings[i]);
                //Parses the integer for each string.
                if (integers[i] == 1) {
                    sum += salami.prize;
                    salamiN++;
                }
                else if (integers[i] == 2) {
                    sum += taiti.prize;
                    taitiN++;
                }
                else if (integers[i] == 3) {
                    sum += margarita.prize;
                    margaritaN++;
                }
                else if (integers[i] == 4) {
                    sum += fourCheese.prize;
                    fourCheeseN++;
                }
                else if (integers[i] == 5){
                    sum += bandito.prize;
                    banditoN++;
                }

            }
            /*End*/


            /*Here I am doing almost the same thing but only for drinks*/
            System.out.print("We also offer drinks as 'Cola',which costs 2 euros per litre,\n" +
                    "'Fanta', which costs 3 euros per litre. \n" +
                    "Please enter 1 for cola and 2 for fanta: ");
            choosenDrink = scanStr.nextLine();
            String[] DrinksString = choosenDrink.split(" ");
            int[] DrinksInteger = new int[DrinksString.length];

            for (int i = 0; i < DrinksInteger.length; i++) {
                DrinksInteger[i] = Integer.parseInt(DrinksString[i]);
                if (DrinksInteger[i] == 1) {
                    sum += 2;
                    colaN++;
                }
                else if (DrinksInteger[i] == 2) {
                    sum += 3;
                    fantaN++;
                }
            }
            /*End*/

            /*Here I am outputting the cost of order and giving chance for discount*/
            System.out.println("You have made order that costs: " + sum + " euros");
            if (discount()){
                sum = sum * 0.9f;
                System.out.print("After discount your order costs: ");
                System.out.printf("%.2f",sum );
                System.out.println(" euros");
            }
            /* End*/

            /*Here I am carrying out payment process and
            if payment is successful than I am outputting all the pizzas that user ordered.
            This is instead of giving actual pizzas to user.
            */
            System.out.print("Please enter the amount of money you have in your card: ");
            userMoney = scanInt.nextDouble();
            if (userMoney >= sum ){
                userMoney -= sum;
                System.out.println("You have made payment. \n" + "There are ");
                System.out.printf("%.2f",userMoney);
                System.out.println(" euros left in your card");
                if (salamiN>0){
                    System.out.println("You have recieved " + salamiN + " " + salami.name);
                }
                if (taitiN>0){
                    System.out.println("You have recieved " + taitiN + " " + taiti.name);
                }
                if (margaritaN>0){
                    System.out.println("You have recieved " + margaritaN + " " + margarita.name);
                }
                if (fourCheeseN>0){
                    System.out.println("You have recieved " + fourCheeseN + " " + fourCheese.name);
                }
                if (banditoN>0){
                    System.out.println("You have recieved " + banditoN + " " + bandito.name);
                }
                if (colaN>0){
                    System.out.println("You have recieved " + colaN + " Cola");
                }
                if (fantaN>0){
                    System.out.println("You have recieved " + fantaN + " Fanata");
                }
            }else {
                System.out.println("You have insufficient amount of money in your card. You can not make this order. \n" +
                        "Please make another order or see you next time. ");
            }
            /*End*/

/*End*/
        }else if (menuOrUnique == 2){
 /*This part of the code is if user wishes to choose his own ingredients.
 */
            sum = 2;
            /*Here I am listing all the ingredients that user can chooser for his pizza*/
            System.out.println("Now you can create your own pizza. \n" +
                    "Minimum that you can order is cooked dough that costs 2 euros, all the other ingredients you can add by yourself");
            System.out.println("1. Tomato Sauce. Price: 2 euro. \n" +
                               "2. Cheese. Price: 2 euros.       \n" +
                               "3. Salami. Price: 3 euros.       \n" +
                               "4. Chicken. Price: 3 euros.      \n" +
                               "5. Pineapple. Price: 2 euros.    \n" +
                               "6. Mozzarella Cheese. Price: 3 euros. \n" +
                               "7. Feta Cheese. Price: 2 euros.   \n" +
                               "8. Roquefort. Price: 3 euros.     \n" +
                               "9. Parmesan. Price: 2 euros.      \n" +
                               "10. Pickled Mushrooms. Price: 2 euros.   \n" +
                               "11. Pickled Garlic. Price: 1 euro.    \n" +
                               "12. Red Pepper. Price: 1 euro.     \n" +
                               "13. Jalapeno. Price: 2 euros.    \n" +
                               "14. Olives. Price: 3 euros.    \n" +
                               "15. Onions. Price: 1 euro.    \n");
            /*End*/

            /*Here I am accepting order from user in the form of string because user may order more than one ingredient.
             Than I am processing that String into array of integers.
             Simultaneously, I am increasing the number of ingredients that are ordered if user's input matches with ingredient's ID.
             */
            System.out.print("Here are all the ingredients we have.\n" +
                    "If you want to add some please enter the corresponding number of the ingredient or several times with space to add more than one: ");
            choosenIngredient = scanStr.nextLine();
// The string you want to be an integer array.
            String[] integerStrings = choosenIngredient.split(" ");
// Splits each spaced integer into a String array.
            int[] integers = new int[integerStrings.length];
// Creates the integer array.
            for (int i = 0; i < integers.length; i++){
                integers[i] = Integer.parseInt(integerStrings[i]);
                //Parses the integer for each string.
                if (integers[i] == 1)
                    sum += 2;
                else if (integers[i] == 2)
                    sum += 2;
                else if (integers[i] == 3)
                    sum += 3;
                else if (integers[i] == 4)
                    sum += 3;
                else if (integers[i] == 5)
                    sum += 2;
                else if (integers[i] == 6)
                    sum += 3;
                else if (integers[i] == 7)
                    sum += 2;
                else if (integers[i] == 8)
                    sum += 3;
                else if (integers[i] == 9)
                    sum += 2;
                else if (integers[i] == 10)
                    sum += 2;
                else if (integers[i] == 11)
                    sum += 1;
                else if (integers[i] == 12)
                    sum += 1;
                else if (integers[i] == 13)
                    sum += 2;
                else if (integers[i] == 14)
                    sum += 2;
                else if (integers[i] == 15)
                    sum += 1;
            }
            /*End*/

            /*The same process for drinks*/
            System.out.print("We also offer drinks as 'Cola',which costs 2 euros per litre,\n" +
                    "'Fanta', which costs 3 euros per litre. \n" +
                    "Please enter 1 for cola and 2 for fanta: ");
            choosenDrink = scanStr.nextLine();
            String[] DrinksString = choosenDrink.split(" ");
            int[] DrinksInteger = new int[DrinksString.length];
            // Creates the integer array.
            for (int i = 0; i < DrinksInteger.length; i++) {
                DrinksInteger[i] = Integer.parseInt(DrinksString[i]);
                if (DrinksInteger[i] == 1) {
                    sum += 2;
                    colaN++;
                }
                else if (DrinksInteger[i] == 2) {
                    sum += 3;
                    fantaN++;
                }
            }
            /*End*/

            /*Here I am outputting the cost of order and giving chance for discount*/
            System.out.println("You have made order that costs: " + sum + " euros");
            if (discount()){
                sum = sum / 10.0f;
                System.out.print("After discount your order costs: ");
                System.out.printf("%.2f",sum);
                System.out.println(" euros");
            }
            /*End*/

            /*Here I am carrying out payment process and
            if payment is successful than I am outputting all the pizzas that user ordered.
            This is instead of giving actual pizzas to user.
            */
            System.out.print("Please enter the amount of money you have in your card: ");
            userMoney = scanInt.nextDouble();
            if (userMoney >= sum ) {
                userMoney -= sum;
                System.out.println("You have made payment. \n" +
                        "There are " + userMoney + " euros left in your card");
            }else {
                System.out.println("You have insufficient amount of money in your card. You can not make this order. \n" +
                        "Please make another order or see you next time. ");
            }
            /*End*/

/*End*/
        }else if (menuOrUnique == 3){
/*This part of the code is responsible for giving to customer random pizza and drink*/

            /*Here I am creating obejcts for random numbers. Depending on the random umber i am outputting on the screen corresponding pizza*/
            Random rand = new Random();
            int randomPizza = rand.nextInt(4) + 1 ;
            if (randomPizza == salami.pizzaId){
                System.out.print(salami.pizzaId+". " +salami.name + ". Prise: " + salami.prize + " euros. Ingredients: " ); salami.nameIngreds();
                sum += salami.prize;
            }else if (randomPizza == taiti.pizzaId){
                System.out.print(taiti.pizzaId+". " + taiti.name + ". Prise: " + taiti.prize + " euros. Ingredients: " ); taiti.nameIngreds();
                sum += taiti.prize;
            }else if (randomPizza == margarita.pizzaId){
                System.out.print(margarita.pizzaId+". " +margarita.name + ". Prise: " + margarita.prize + " euros. Ingredients: " ); margarita.nameIngreds();
                sum += margarita.prize;
            }else if (randomPizza == fourCheese.pizzaId){
                System.out.print(fourCheese.pizzaId+". " + fourCheese.name + ". Prise: " + fourCheese.prize + " euros. Ingredients: " ); fourCheese.nameIngreds();
                sum += fourCheese.prize;
            }else if (randomPizza == bandito.pizzaId){
                System.out.print(bandito.pizzaId+". " + bandito.name +". Prise: " + bandito.prize + " euros. Ingredients: " ); bandito.nameIngreds();
                sum += bandito.prize;
            }else {
                System.out.println("You should not have seen this message!");
            }
            /*End*/

            /*The same thing for drinks*/
            int randomDrink = rand.nextInt(1) ;
            if (randomDrink == 0){
                System.out.println("Cola is added to your order. Cola costs 2 euros");
                sum += 2;
            }else if (randomDrink == 1){
                System.out.println("Fanta is added to your order. Fanta costs 3 euros");
                sum += 3;
            }
            /*End*/

            /*Here I am letting user know how much his random set is going to cost, and letting him decide if he wants this set or not*/
            System.out.println("Your random set costs: " + sum + " euros");
            System.out.print("If you want to order it please enter 1, otherwise 2: ");
            int randSet = scanInt.nextInt();
            /*End*/
            if (randSet == 1){
                /*If user agrees  with random set, than i am offering him discount game.*/
                if (discount()){
                    sum = sum * 0.9f;
                    System.out.print("After discount your order costs: ");
                    System.out.printf("%.2f",sum );
                    System.out.println(" euros");
                }
                /*End*/

                /*Here I am carrying out payment process.
                 */
                System.out.print("Please enter the amount of money you have in your card: ");
                userMoney = scanInt.nextDouble();
                if (userMoney >= sum ) {
                    userMoney -= sum;
                    System.out.println("You have made payment. \n" + "There are ");
                    System.out.printf("%.2f", userMoney);
                    System.out.println(" euros left in your card");
                }
                /*End*/
            }else if (randSet == 2){
                /*This code is if user does not want random set of pizza and drink*/
                System.out.println("See you next time!");
                /*End*/
            }else {
                System.out.println("You entered some value but 1 and 2, so you received this error message. Be careful next time");
            }

/*End*/
        }
        else {
            System.out.println("You entered some value but 1, 2 and 3, so you received this error message. Be careful next time");
        }
    }

 /*This part of the code is method that is responsible for discounts*/
    public static boolean discount(){
        /*Here I am printing conditions of the quiz and asking user if he wants to take part in quiz or not*/
        Scanner scanInt = new Scanner(System.in);
        boolean correct = false;
        System.out.print("For clever clients we offer 10% discount. \n" +
                "If you want to get discount you should solve some mathematical examples.\n" +
                "Please enter '1' if you want to take part int he quiz, if not '2': ");
        int discountOrNot = scanInt.nextInt();
        /*End*/
        if (discountOrNot == 1){
            /*If user wants to take part, than this code is going to work*/
            /*Next I am gradually displaying four questions and creating if else statements
              If user fails to answer all of them correctly than he fails
              */
            int averPowerB,litres,answer,fives;
            System.out.println("You should solve four examples with basic expressions. If at least one is wrong than you will not receive discount");
            System.out.print("What is the average of powers of b after expanding (a+b)^3: ");
            averPowerB = scanInt.nextInt();
            if (averPowerB == 2){
                System.out.print("How many litres of water is  equal to 10 cubic decimetres: ");
                litres = scanInt.nextInt();
                if (litres == 10){
                    System.out.print("What is the answer of 9 / 3 * 3 = : ");
                    answer = scanInt.nextInt();
                    if (answer == 9){
                        System.out.print("How many fives are there in the numbers between 1 to 100: ");
                        fives = scanInt.nextInt();
                        if (fives == 11){
                            System.out.println("You have successfully answered all the questions.\n" +
                                    "Now you cannot say I am not going to need formulas in my life ;). \n" +
                                    "You will receive ten percent discount. Unlucky for us :)");
                            correct = true;
                        }else
                            System.out.println("Fortunately for us you failed :). You can try next time!");
                    }else
                        System.out.println("Fortunately for us you failed :). You can try next time!");
                }else
                    System.out.println("Fortunately for us you failed :). You can try next time!");
            }else
                System.out.println("Fortunately for us you failed :). You can try next time!");
            /*End*/

        }else if (discountOrNot == 2)
            /*This code is if user does not want to take part in quiz*/
            System.out.println("Well, you must be too clever for this and must have too much money!");
            /*End*/
        else
            System.out.println("You have inputted some value but 1 or 2.  ");

        return correct;
    }
/*End*/

}
