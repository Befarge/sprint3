import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dishes;
    private Random random;

    public DinnerConstructor() {
        dishes = new HashMap<>();
        random = new Random();
    }

    public void fillDishes(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            dishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> listOfDishes = new ArrayList<>();
            listOfDishes.add(dishName);
            dishes.put(dishType, listOfDishes);
        }
    }

    public boolean checkType(String type) {
        return dishes.containsKey(type);
    }

    public ArrayList<ArrayList<String>> comboOfDishes(ArrayList<String> dishesOfTypes, int numberOfCombos) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int count = 0; count < numberOfCombos; count++) {
            ArrayList<String> kitOfDishes = new ArrayList<>();

            for (String type : dishesOfTypes) {
                ArrayList<String> currentType = dishes.get(type);

                kitOfDishes.add(currentType.get(random.nextInt(currentType.size())));
            }
            result.add(kitOfDishes);
        }
        return result;
    }
}
