package lambdasinaction.chap3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class LambdasSimple3 {
	public static void main(String ...args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
												new Apple(155, "green"),
												new Apple(120, "red"),
												new Apple(100, "red"));	
		
		List<String> strList = Arrays.asList("green","red","yellow","black","white");	
		
		Runnable r1 = () -> System.out.println("Hello Wolrd 1!!!");
		
		Runnable r2 = new Runnable(){
			public void run() {
				System.out.println("Hello Wolrd 2!!!");
			}
		};
		
		process(r1);
		process(r2);
		process(()->System.out.println("Hello Wolrd 3!!!"));
		//함수형 인터페이스 
		//Apple a1 = (() -> new Apple(200,"yellow"));
		//Predicate
		//객체  불린 반환
		//Predicate<객체>
		Predicate<Apple> predicate1 = (Apple a) -> a.getWeight() >150;//->test
		//Function
		//입력을 출력으로 매핑하는 람다 정의시 
		//객체에서 추출 및 선택 
		//Function<추출객체, 추출후전달객체>
		Function<String, Integer>  function1 = (String s) -> s.length();//->apply
		//Consumer
		//객체를 인수로 받아서 어떤 동작을 수행하고  싶을때 
		Consumer<Integer> consumer1 = (Integer i) ->  System.out.println(">>"+i); //->accept
		Runnable runnable1 = () -> System.out.println("runnable1!!!"); //->run
		
	}
	
	public static void process(Runnable r) {
		r.run();
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