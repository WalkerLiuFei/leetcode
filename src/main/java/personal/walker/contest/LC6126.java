package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6126 implements Solution {
    @Override
    public void runTestCases() {

        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        foodRatings.highestRated("korean"); // 返回 "kimchi"
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "sushi"
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
    }



    class FoodRatings {
        class Food {
            String name;
            int rating;
            String cuisine;

            Food(String name,
                 int
                         rating,
                 String cuisine) {
                this.name = name;
                this.rating = rating;
                this.cuisine = cuisine;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Food food = (Food) o;
                return Objects.equals(name, food.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);
            }
        }

        HashMap<String, Food> foodMap = new HashMap<>();
        HashMap<String, PriorityQueue<Food>> cuisine2RatingQueue = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                Food fooObj = new Food(foods[i], ratings[i], cuisines[i]);
                foodMap.put(foods[i], fooObj);
                if (!cuisine2RatingQueue.containsKey(cuisines[i])){
                    cuisine2RatingQueue.put(cuisines[i], new PriorityQueue<>((o1, o2) -> {
                        if (o2.rating - o1.rating != 0) {
                            return o2.rating - o1.rating;
                        }
                        return o1.name.compareTo(o2.name);
                    }));
                }

                cuisine2RatingQueue.get(cuisines[i]).add(fooObj);
            }
        }

        public void changeRating(String food, int newRating) {
            Food foodObj = foodMap.get(food);
            PriorityQueue<Food> queue = cuisine2RatingQueue.get(foodObj.cuisine);
            queue.remove(foodObj);
            foodObj.rating = newRating;
            queue.add(foodObj);

//            while (!queue.isEmpty() && queue.peek().name.equals(food)){
//                queue.remove();
//            }
//            queue.add(foodObj);
        }

        public String highestRated(String cuisine) {
            return cuisine2RatingQueue.get(cuisine).peek().name;
        }
    }

}
