/* Assignment: 3
Campus: Ashdod
Authors:
Eliran Naduyev 312089105
Maria Garber
*/

package com.example.Recipeapp;

public class PresentIngredient {
    private String name;
    private String Thumbnail;
    private boolean selected;

    PresentIngredient(String name, String thumbnail) {
        this.name = name;
        Thumbnail = "https://spoonacular.com/cdn/ingredients_100x100/" + thumbnail;
        selected = false;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected() {
        selected = !selected;
    }
}
