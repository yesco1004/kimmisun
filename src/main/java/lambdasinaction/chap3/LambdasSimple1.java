package lambdasinaction.chap3;

import static java.util.stream.Collectors.toList;

import java.util.*;


public class LambdasSimple1 {
	public static void main(String ...args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
												new Apple(155, "green"),
												new Apple(120, "red"),
												new Apple(100, "red"));	
		
		//1. Filter
		//Predicate 활용
		List<Apple> greenApples1 =  filter(inventory, new AppleColorPredicate());
		System.out.println("##Predicate 활용##");
		System.out.println("greenApples1="+greenApples1.toString());
		//익명클래스 활용
		List<Apple> greenApples2 =  filter(inventory, new AppleColorPredicate() {
			public boolean test(Apple apple) {
				return "green".equals(apple.getColor());
			}
		});
		System.out.println("##익명클래스 활용##");
		System.out.println("greenApples2="+greenApples2.toString());
		//람다 활용1
		List<Apple> greenApples3 =  filter(inventory, (Apple apple)-> "green".equals(apple.getColor()));
		System.out.println("##람다 활용1##");
		System.out.println("greenApples3="+greenApples3.toString());
		//람다 활용2(형식파라미터)
		List<Apple> greenApples4 =  filter1(inventory, (Apple apple)-> "green".equals(apple.getColor()));
		System.out.println("##람다 활용2(형식파라미터)##");
		System.out.println("greenApples4="+greenApples4.toString());
		List<Apple> greenApples5 =  inventory.stream()
                .filter(a -> "green".equals(a.getColor())).collect(toList());
		System.out.println("##스트림 ##");
		System.out.println("greenApples5="+greenApples5.toString());
		

		//2. Compare
		//Comparator 활용
		Comparator<Apple> byWeight1 = new Comparator<Apple>() {
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		};
		inventory.sort(byWeight1);
		//람다 활용
		Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		inventory.sort(byWeight2);
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

	}
	
	public interface ApplePredicate<T>{
		boolean test(Apple apple);
	}

	public static class AppleColorPredicate implements ApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}
	
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	} 
	
	public interface Predicate<T>{
		boolean test(T t);
	}
	
	public static <T>List<T> filter1(List<T> inventory, Predicate<T> p){
		 List<T> result = new ArrayList<>();
		 for(T e :  inventory) {
			 if(p.test(e)) {
				 result.add(e);
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