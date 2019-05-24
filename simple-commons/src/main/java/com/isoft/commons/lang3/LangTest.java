package com.isoft.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class LangTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// arrayUtilsTest();

		//arrayUtilsTest2();
		
		//arrayUtilsTest3();
		//arrayUtilsTest4();
		
		//arrayUtilsTest5() ;
		//arrayUtilsTest6();
		//arrayUtilsTest7();
		
		arrayUtilsTest9();
	}

	// 二、ArrayUtils 数组工具类
	// byte, int, char, double, float, int, long ,short, T[] 同理
	// add(boolean[] array, boolean element) 将给定的数据添加到指定的数组中，返回一个新的数组
	private static void arrayUtilsTest() {
		System.out.println(StringUtils.center(" arrayUtilsTest ", 40, "=")); // data

		boolean[] barr1 = ArrayUtils.add(null, true);
		printBooleanArr(barr1);

		boolean[] barr2 = { true };
		barr2 = ArrayUtils.add(barr2, false);
		printBooleanArr(barr2);

		boolean[] barr3 = { true, false };
		barr3 = ArrayUtils.add(barr3, true);
		printBooleanArr(barr3);

	}

	// add(boolean[] array, int index, boolean element)
	// 将给定的数据添加到指定的数组下标中，返回一个新的数组。
	private static void arrayUtilsTest2() {
		System.out.println(StringUtils.center(" arrayUtilsTest2 ", 40, "=")); // data

		boolean[] barr1 = ArrayUtils.add(null, 0, true);
		printBooleanArr(barr1);

		boolean[] barr2 = { true };
		barr2 = ArrayUtils.add(barr2, 0, false);
		printBooleanArr(barr2);
		
		

	}

	// addAll(boolean[] array1, boolean... array2) 将给定的多个数据添加到指定的数组中，返回一个新的数组
	// ArrayUtils.addAll(array1, null)
	private static void arrayUtilsTest3() {
		System.out.println(StringUtils.center(" arrayUtilsTest3 ", 40, "=")); // data
		boolean[] barr1 = { true, false };
		barr1 = ArrayUtils.addAll(barr1, null);
		printBooleanArr(barr1);
		
		boolean[] barr2 = { true };
		barr2=ArrayUtils.addAll(null, barr2);
		printBooleanArr(barr2);
		
		boolean[] barr3 = { true };
		boolean[] barr4 = { true,false };
		
		boolean[] barr5=ArrayUtils.addAll(barr3, barr4);
		printBooleanArr(barr5);
		
	}
	
	
	//clone(boolean[] array) 复制数组并返回 结果数组为空将返回空
	private static void arrayUtilsTest4() {
		System.out.println(StringUtils.center(" arrayUtilsTest4 ", 40, "=")); // data
		boolean[] barr1 = { true, false };
		boolean[] barr2=ArrayUtils.clone(barr1);
		printBooleanArr(barr2);
	
	}
	
	//contains(boolean[] array, boolean valueToFind) 检查该数据在该数组中是否存在，返回一个boolean值
	private static void arrayUtilsTest5() {
		System.out.println(StringUtils.center(" arrayUtilsTest5 ", 40, "=")); // data
		boolean[] barr1 = { false, false };
		boolean flag=ArrayUtils.contains(barr1, true);
		System.out.println(flag);
	
	}
	

	//getLength(Object array) 返回该数组长度
	//hashCode(Object array) 返回该数组的哈希Code码
	private static void arrayUtilsTest6() {
		System.out.println(StringUtils.center(" arrayUtilsTest6 ", 40, "=")); // data
		boolean[] barr1 = { false, false };
		int len=ArrayUtils.getLength(barr1);
		System.out.println(len);
		
		int hashcode=ArrayUtils.hashCode(barr1);
		System.out.println(hashcode);
	}
	
	//indexOf(boolean[] array, boolean valueToFind) 从数组的第一位开始查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1
	//indexOf(boolean[] array, boolean valueToFind, int startIndex) 从数组的第startIndex位开始查询该数组中是否有指定的数值，存在返回index的数值，否则返回-1
	private static void arrayUtilsTest7() {
		System.out.println(StringUtils.center(" arrayUtilsTest7 ", 40, "=")); // data
		boolean[] barr1 = { true, false ,false,true};
		int index=ArrayUtils.indexOf(barr1, true);
		System.out.println(index);
		
		int index2=ArrayUtils.indexOf(barr1, true,1);
		System.out.println(index2);
	}
	
	//insert(int index, boolean[] array, boolean... values) 向指定的位置往该数组添加指定的元素，返回一个新的数组
	private static void arrayUtilsTest8() {
		System.out.println(StringUtils.center(" arrayUtilsTest8 ", 40, "=")); // data
		boolean[] barr1 = { true, false ,false,true};
		//ArrayUtils.insert
	}
	
	//isEmpty(boolean[] array) 判断该数组是否为空，返回一个boolean值
	//isNotEmpty(boolean[] array) 判断该数组是否为空，而不是null
	private static void arrayUtilsTest9() {
		System.out.println(StringUtils.center(" arrayUtilsTest9 ", 40, "=")); // data
		boolean[] barr1 = { true, false ,false,true};
		System.out.println(ArrayUtils.isEmpty(barr1));
		System.out.println(ArrayUtils.isNotEmpty(barr1));
		
		boolean[] barr2 =null;
		System.out.println(ArrayUtils.isEmpty(barr2));
		
		boolean[] barr3 ={};
		System.out.println(ArrayUtils.isEmpty(barr3));
		
		
		
	}
	
	//isSameLength(boolean[] array1, boolean[] array2) 判断两个数组的长度是否一样，当数组为空视长度为0。返回一个boolean值
	
	
	
	
	
	
	
	
	
	
	private static void printBooleanArr(boolean[] barr) {
		for (int i = 0; i < barr.length; i++) {
			System.out.print(barr[i] + "\t");
		}
		System.out.println();
	}

}
