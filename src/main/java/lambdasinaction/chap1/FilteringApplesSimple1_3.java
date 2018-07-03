package lambdasinaction.chap1;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilteringApplesSimple1_3 {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
											new Apple(155, "green"),
											new Apple(120, "red"));	
		
		//스트림 : 컬렉션을 필터링 할수 있는 가장 빠른 방법은 컬렉션을 스트림으로 바꾸고 병렬로 처리 한 다음.에 다시 리스트로 복원 
		System.out.println("inventory.stream() : "+inventory.stream());
		//순차처리방식
		List<Apple> heavyApples1 = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
										.collect(toList());
		System.out.println("heavyApples1 : "+heavyApples1.toString());
		//병렬 처리 방식
		List<Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150)
				.collect(toList());
		System.out.println("heavyApples2 : "+heavyApples2.toString());
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
