package lambdasinaction.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApplesSimple2_1 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
											new Apple(155, "green"),
											new Apple(120, "red"));	
		//green 사과 필터
		List<Apple> result1  = filterGreenApples(inventory);
		//weight 사과 필터
		List<Apple> result2  = filterWeightApples(inventory);
		
		System.out.println("result1="+result1.toString());
		System.out.println("result2="+result2.toString());
		
		List<Apple> greenApple  = filterApplesByColor(inventory,"green");
		List<Apple> redApple  = filterApplesByColor(inventory,"red");
		
		List<Apple> apple100  = filterApplesByWeight(inventory,100);
		List<Apple> apple150  = filterApplesByWeight(inventory, 150);
		
		System.out.println("greenApple="+greenApple.toString());
		System.out.println("redApple="+redApple.toString());
		
		System.out.println("apple100="+apple100.toString());
		System.out.println("apple150="+apple150.toString());
		
		
		List<Apple> greenApple1  = filterApples(inventory,"green" , 0 , true);
		List<Apple> apple1501  = filterApples(inventory,"" , 150 , false);
		System.out.println("greenApple1="+greenApple1.toString());
		System.out.println("apple1501="+apple1501.toString());
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
	
	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if(apple.getColor().equals(color)) {
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
	
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if(apple.getWeight() > weight) {
				 result.add(apple);
			 }
		 }
		 return result;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if((flag&& apple.getColor().equals(color)) ||(!flag && apple.getWeight() > weight)) {
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
