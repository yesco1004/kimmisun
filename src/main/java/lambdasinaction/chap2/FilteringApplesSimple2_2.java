package lambdasinaction.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambdasinaction.chap2.FilteringApples.AppleColorPredicate;
import lambdasinaction.chap2.FilteringApplesSimple2_1.Apple;

public class FilteringApplesSimple2_2 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
											new Apple(155, "green"),
											new Apple(120, "red"));	
		List<Apple> greenApples1 =  filterApples(inventory, new AppleColorPredicate());
		List<Apple> weightApples150 =  filterApples(inventory, new AppleHavyWeightPredicate());
		
		System.out.println("greenApples1="+greenApples1.toString());
		System.out.println("weightApples150="+weightApples150.toString());
		
		
		//익명클래스 사용
		List<Apple> redApples1 =  filterApples(inventory, new ApplePredicate() {

			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
			
		});
		System.out.println("redApples1="+redApples1.toString());
		//익명클래스 사용
		List<Apple> weightApples100 =  filterApples(inventory, new ApplePredicate() {

					@Override
					public boolean test(Apple apple) {
						return apple.getWeight() > 100;
					}
					
				});
		System.out.println("weightApples100="+weightApples100.toString());
	}
	public interface ApplePredicate{
		boolean test(Apple apple);
	}
	
	public static class AppleHavyWeightPredicate implements ApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}
	
	public static class AppleColorPredicate implements ApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		 List<Apple> result = new ArrayList<>();
		 for(Apple apple :  inventory) {
			 if(p.test(apple)) {
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
