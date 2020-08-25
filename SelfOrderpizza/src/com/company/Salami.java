/*Sub class for Salami Pizza */
package com.company;

public class Salami extends Pizza {
    public String name = "Salami Pizza";
    public int pizzaId = 1;
    public double prize = 7.9;
    public String[] ingredients = {"Cheese", "Salami", "Tomato sauce" };
    public void nameIngreds(){
        for (int i= 0; i < ingredients.length;i++){
            System.out.print(ingredients[i]+", ");
        }
        System.out.println();
    }

}
