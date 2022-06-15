package com.springboot.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Stream {
	
	public static void main(String[] args) {
		/**Stream API를 이용한 간단한 짝수 판별*/
//		IntStream.range(1, 11).filter(i -> i % 2 == 0)
//								.forEach(System.out::println);
		
		/**0~1000까지의 값 중 500이상이며 짝수이면서 5의 배수인 수의 합을 구하라*/
		System.out.println(
						IntStream.range(0, 1001)
								.filter(i -> (i >= 500) && (i % 2 == 0) && (i % 5) == 0)
								.sum()
						);
		
		System.out.println(
				IntStream.range(0, 1001)
						.skip(500)
						.filter(i -> (i % 2 == 0) && (i % 5) == 0)
						.sum()
				);
		
		/**==========================================================================================*/
		String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
		List<String> nameList = Arrays.asList(nameArr);
		
		
		java.util.stream.Stream<String> nameStream = nameList.stream();
		java.util.stream.Stream<String> arrayStream = Arrays.stream(nameArr);
		
		System.out.println(nameStream.sorted().count());	//4
//		java.util.stream.Stream<String> nameStream = nameList.stream();
//		Stream API는 일회용이기 때문에 한번 사용이 끝나면 재사용이 불가능하다.
//		Stream이 필요한 경우네는 Stream을 다시 생성해주어야 한다.
//		닫힌 Stream을 다시 사용한다면 IllegalStateException이 발생한다.
		
		java.util.stream.Stream<String> reStream = nameList.stream();
		reStream.sorted().forEach(System.out::println);	


			
	}//end main()
}//end class()
