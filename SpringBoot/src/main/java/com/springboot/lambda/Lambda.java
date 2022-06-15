package com.springboot.lambda;

public class Lambda {

	public static void main(String[] args) {
		
		test1();	//매개 변수가 없고, 리턴 값이 없는 람다식
		test2();	//매개 변수가 있고, 리턴 값이 없는 람다식
		test3();	//매개 변수가 없고, 리턴 값이 있는 람다식
		test4();	//매개 변수가 있고, 리턴 값이 있는 람다식
		
	}//end main()

	/**매개 변수가 없고, 리턴 값이 없는 람다식*/
	private static void test1() {
		LambdaInterface test;
		
		//{} 실행코드 뒤에 세미콜론을 붙여야 한다.
		test = () -> {
			System.out.println("안녕하세요, 신형철입니다.");
		};
		
		test.nowCoding();
		
		//실행 코드가 한 줄인경우 {} 생략가능
		test = () -> System.out.println("안녕하세요, 신형철입니다2222.");
		
		test.nowCoding();	// << 이거 안쓰면 출력 안됨
		
	}//end test1()
	
	/**매개 변수가 있고, 리턴 값이 없는 람다식*/
	private static void test2() {
		LambdaInterface2 test;
        String str;

        test = (a) -> {
            System.out.println(a + "형철1");
        };
        str = "신1";
        test.nowCoding(str);

        //람다식 바디{}를 생략하고 한 줄에 작성하기
        test = (a) -> System.out.println(a + "형철2");
        str= "신2";
        test.nowCoding(str);

        //매개변수가 1개인 경우 () 생략할 수 있음
        test = a -> System.out.println(a+ "형철3");
        test.nowCoding("신3");
		
	}//end test2()
	
	/**매개 변수가 없고, 리턴 값이 있는 람다식*/
	private static void test3() {
		LambdaInterface3 test;
		
		String str1 = "신";
		String str2 = "형";
		String str3 = "철";
		
		test = () -> {
			return str1;
		};
		System.out.println(test.nowCoding());
		
		test = () -> {return str2;};
		System.out.println(test.nowCoding());
		
		//실행코드가 return만 있는 경우 {}와 return문 생략 가능
		test = () -> str3;
		System.out.println(test.nowCoding());
	}//end test2()

	/**매개 변수가 있고, 리턴 값이 있는 람다식*/
	private static void test4() {
		LambdaInterface4 test;
		
		String str1 = "010";
		String str2 = "2213";
		String str3 = "1320";
		
		test = (a) -> {
			return a + str1;
		};
		System.out.println(test.nowCoding("앞"));
		
		test = (a) -> {return a + str2;};
		System.out.println(test.nowCoding("중간"));
		
		test = a -> a + str3;
		System.out.println(test.nowCoding("뒤"));
		
	}//end test2()

}//end class()
