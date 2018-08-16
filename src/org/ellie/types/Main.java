package org.ellie.types;

import java.lang.reflect.Field;
import java.util.Scanner;

import org.ellie.types.model.MyInt;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int x = 10;
		/*int x2 = 11;
		System.out.println(x == x2);
		
		int x3 = 12;
		int x4 = 12;
		System.out.println(x3 == x4);
		
		String s = "10";
		String s2 = "11";
		System.out.println(s == s2);
		
		String s3 = "12";
		String s4 = "12";
		System.out.println(s3 == s4);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input s5:");
		String s5 = sc.next();
		System.out.println("Input s6:");
		String s6 = sc.next();
		System.out.println(s5 == s6);*/
		
		//volatile - модификатор пол€, указывает, что
		//поле может модифицироватьс€ из разных потоков выполнени€
		
		/*foo(x);
		System.out.println("x = " + x);
		
		MyInt myInt = new MyInt();
		myInt.x = 10;
		foo2(myInt);
		System.out.println("x = " + myInt.x);*/
		
		/*int a = 7;
		int b = 0x0001;
		//System.out.println(a | b); // 010 000 -> 010
		//System.out.println(a ^ b); // 010 000 -> 101
		System.out.println(~a); // 010 -> 101
		
		for (int i = 0; i < 32; i++) {
			//System.out.println(a & b); // 010 000 -> 000
			b = b << 1;
		}*/
		
		/*int[] arr1 = {1, 2, 5, -9, 0, 6};
		int[][] arr2 = new int[2][];
		arr2[0] = arr1;
		arr2[1] = new int[] {4, 5};
		for (int[] childArray : arr2) {
			for (int i : childArray) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		MyInt[] arr3 = new MyInt[5];
		arr3[0] = new MyInt();
		arr3[1] = new MyInt();
		try {
			arr3[2] = new MyInt(-5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for (MyInt i : arr3) {
			System.out.print(i + " ");
		}
		
		System.out.print(MyInt.getCount());*/
		
		MyInt myInt = new MyInt(120);
		System.out.println(myInt.getX());
		myCracker(myInt, 123);
		System.out.println(myInt.getX());
	}
	
	/*private static void foo(int _x) {
		_x *= 2;
	}
	
	private static void foo2(MyInt _myX) {
		_myX.x *= 2;
	}*/
	
	private static void myCracker(MyInt _myInt, int _newX) {
		
		Class<? extends MyInt> myClass = _myInt.getClass();
		
		/*for (Field xField : myClass.getDeclaredFields()) {
			System.out.println(xField.getName());
		}*/
		
		try {
			Field xField = myClass.getDeclaredField("x");
			xField.setAccessible(true);
			xField.set(_myInt, _newX);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
