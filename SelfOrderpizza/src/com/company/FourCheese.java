/*Sub class for Four Cheese Pizza */
package com.company;

public class FourCheese extends Pizza {
    public String name = "Four Cheese Pizza";
    public int pizzaId = 4;
    public double prize = 8.9;
    public String[] ingredients = {"Cheese", "Feta cheese","Tomato sauce", "Mozzarella cheese", "Roquefort", "Parmesan"};
    public void nameIngreds(){
        for (int i= 0; i < ingredients.length;i++){
            System.out.print(ingredients[i]+", ");
        }
        System.out.println();
    }
}
