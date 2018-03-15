/**
 * @文件名称:ZhaoYun.java
 * @文件路径:com.chen.strategy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-17下午5:55:45
 * @版本:V1.0
 */
package com.minghua.strategy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class ZhaoYun {

	/**
	 *方法功能说明
	 *chen  2013-9-17
	 *@参数：@param args
	 *@return void
	 */
	public static void main(String[] args) {
		Context context;
		//使用第一计
		System.out.print("----------刚到吴国的时候拆第一个----------------");
		context = new Context(new BackDoor());
		context.operate();
		System.out.println("\n\n\n\n\n\n\n\n");
		//使用第二计
		System.out.print("----------刘备乐不思蜀，拆第二个----------------");
		context = new Context(new GivenGreenLight());
		context.operate();
		System.out.print("\n\n\n\n\n\n\n\n");
		//使用第三计
		System.out.print("----------孙权的小兵追了，拆第三个----------------");
		context = new Context(new BlockEnemy());
		context.operate();
		System.out.print("\n\n\n\n\n\n\n\n");
	}

}
