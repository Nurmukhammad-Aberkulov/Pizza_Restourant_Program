/*Sub class for Bandito Pizza */
package com.company;

public class Bandito extends Pizza {
    public String name = "Bandito Pizza";
    public int pizzaId = 5;
    public double prize = 9.9;
    public String[] ingredients = {"Cheese","Salami","Tomato sauce","Pickled Mushrooms","pickled garlic","red pepper","jalapeno"};
    public void nameIngreds(){
        for (int i= 0; i < ingredients.length;i++){
            System.out.print(ingredients[i]+", ");
        }
        System.out.println();
    }
}
