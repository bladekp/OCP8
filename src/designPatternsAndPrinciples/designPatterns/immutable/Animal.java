package designPatternsAndPrinciples.designPatterns.immutable;

import java.util.*;

public final class Animal {

    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }
}

/*
1. Use a constructor to set all properties of the object.
2. Mark all of the instance variables private and final .
3. Don’t define any setter methods.
4. Don’t allow referenced mutable objects to be modified or accessed directly.
5. Prevent methods from being overridden.
*/

/*
Does this sample follow all five rules? Well, all fields are marked private and final,
and the constructor sets them upon object creation. Next, there are no setter methods and
the class itself is marked final, so the methods cannot be overridden by a subclass. The
class does contain a mutable object, List, but no references to the object are publically
available. We provide two methods for retrieving the total number of favorite foods as
well as a method to retrieve a food based on an index value. Note that String is given to
be immutable, so we don’t have to worry about any of the String objects being modified.
Therefore, all five rules are preserved and instances of this class are immutable.
*/

/*
You may notice that we created a new ArrayList in the Animal constructor. This is
absolutely important to prevent the class that initially creates the object from maintaining
a reference to the mutable List used by Animal. Consider if we had just done the
following in the constructor:
this.favoriteFoods = favoriteFoods;
With this change, the caller that creates the object is using the same reference as the
immutable object, which means that it has the ability to change the List! It is important
when creating immutable objects that any mutable input arguments are copied to the
instance instead of being used directly.
*/