package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApplesSimple1_1 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
											new Apple(155, "green"),
											new Apple(120, "red"));	
		//green 사과 필터
		List<Apple> result1  = filterGreenApples(inventory);
		//green 사과 필터
		List<Apple> result2  = filterWeightApples(inventory);
		
		System.out.println(result1.toString());
		System.out.println(result2.toString());
		
	}
	//green 사과만 필터
	public static List<Apple> filterGreenApples(List<Apple> inventory){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if("green".equals(apple.getColor())) {
				 result.add(apple);
			 }
		 }
		 return result;
	}
	
	//green 사과만 필터
	public static List<Apple> filterWeightApples(List<Apple> inventory){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if(apple.getWeight() > 150) {
				 result.add(apple);
			 }
		 }
		 return result;
	}
	
	public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                   "color='" + color + '\'' +
                   ", weight=" + weight +
                   '}';
        }
    }
}
