package lambdasinaction.chap2;

import java.util.*;



public class FilteringApplesSimple2_4 {
	public static void main(String[] args) {
		List<Apple4> inventory = Arrays.asList(new Apple4(80,"green"),
											new Apple4(155, "green"),
											new Apple4(120, "red"),
											new Apple4(100, "red"));	
		
		//정렬하기 
		inventory.sort(new Comparator<Apple4>() {
			public int compare(Apple4 a1, Apple4 a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		
		//inventory.sort((Apple4 a1, Apple4 a2) -> a1.getWeight().compareTo(a2.getWeight()));
		
		System.out.println("sort inventory" + inventory.toString());
		
	}

	
	public static class Apple4 {
        private int weight = 0;
        private String color = "";

        public Apple4(int weight, String color){
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
