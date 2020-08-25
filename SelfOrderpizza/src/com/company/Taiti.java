/*Sub class for Taiti Pizza */
package com.company;

public class Taiti extends Pizza {
    public String name = "Taiti Pizza";
    public int pizzaId = 2;
    public double prize = 7.9;
    public String[] ingredients = {"Cheese", "Chicken", "Tomato sauce","Pineapple" };
    public void nameIngreds(){
        for (int i= 0; i < ingredients.length;i++){
            System.out.print(ingredients[i]+", ");
        }
        System.out.println();
    }
}
