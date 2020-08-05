package com.example.demo.effectivejava.part2;

/**
 * @ClassName Part2
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/8/4  12:20 下午
 * @Version 1.0
 */
public class NutritionFacts {

    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohyfrate;

    static class Builder {
        private final int servingSize;
        private final int serving;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohyfrate = 0;

        public Builder(int servingSize, int serving) {
            this.serving = serving;
            this.servingSize = servingSize;
        }

        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder setSodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohyfrate(int carbohyfrate) {
            this.carbohyfrate = carbohyfrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        serving = builder.serving;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohyfrate = builder.carbohyfrate;
    }

    public static void main(String[] args) {
        NutritionFacts aa = new NutritionFacts.Builder(249, 0)
                .setCalories(32).setFat(44).setSodium(33).setCarbohyfrate(44).build();
    }

}
