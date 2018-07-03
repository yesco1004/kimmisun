package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilteringApplesSimple1_2 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
											new Apple(155, "green"),
											new Apple(120, "red"));	
		//green 사과 필터
		List<Apple> greeapple1  = filterGreenApples(inventory);
		//green 사과 필터
		List<Apple> weight1  = filterWeightApples(inventory);
		

		
		List<Apple> greeapple2 = filterApples(inventory, FilteringApplesSimple1_2::isGreenApple);
		List<Apple> weight2 = filterApples(inventory, FilteringApplesSimple1_2::isHeavyApple);
		
		System.out.println("###simple Filter###");
		System.out.println(greeapple1.toString());
		System.out.println(weight1.toString());
		System.out.println("###predicate Filter###");
		System.out.println(greeapple1.toString());
		System.out.println(weight1.toString());
		
		
	}
	//predicate 인수로 값을 받아 true나 false로 반환하는 함수
	public interface Predicate<T>{
		boolean test(T t);
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if(p.test(apple)) {
				 result.add(apple);
			 }
		 }
		 return result;
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
	
	public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor()); 
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
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
