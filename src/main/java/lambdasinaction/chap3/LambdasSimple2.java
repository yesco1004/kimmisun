package lambdasinaction.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LambdasSimple2 {
	public static void main(String ...args) throws IOException{
		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

		
	}
	
	public static String processFile() throws IOException {
		//try-with-resources : 자원을 명시적으로 닫을 필요가 없다. 
		try(BufferedReader br = new BufferedReader(new FileReader("D:\\eclipse-workspace\\java8\\src\\main\\resources\\lambdasinaction\\chap3\\data.txt"))){
			return br.readLine();
		}

	}
	
	@FunctionalInterface
	//함수형 인터페이스 선언 
	//함수형 인터페이스가 아닌경우 컴파일시 에러 
	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		//try-with-resources : 자원을 명시적으로 닫을 필요가 없다. 
		try(BufferedReader br = new BufferedReader(new FileReader("D:\\eclipse-workspace\\java8\\src\\main\\resources\\lambdasinaction\\chap3\\data.txt"))){
			return p.process(br);
		}

	}
}