/*Sub class for Margarita Pizza */
package com.company;

public class Margarita extends Pizza {
    public String name = "Margarita Pizza";
    public int pizzaId = 3;
    public double prize = 7.9;
    public String[] ingredients = {"Cheese", "Mozzarella cheese", "Tomato sauce" };
    public void nameIngreds(){
        for (int i= 0; i < ingredients.length;i++){
            System.out.print(ingredients[i]+", ");
        }
        System.out.println();
    }
}
