package com.minghua.multition;
/**
* @author cbf4Life cbf4life@126.com
* I'm glad to share my knowledge with you all.
* 大臣们悲惨了，一个皇帝都伺候不过来了，现在还来了两个个皇帝
* TND，不管了，找到个皇帝，磕头，请按就成了！
*/
@SuppressWarnings("all")
public class Minister {
	public static void main(String[] args){
		int ministerNum = 10;
		for(int i = 0; i< ministerNum; i++){
			Emperor emperor = Emperor.getInstance();
			System.out.println("第" + i + "个大臣跪拜的是:" );
			emperor.emperorInfo();
		}
	}
}
