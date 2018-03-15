/**
 * @文件名称:Emperor.java
 * @文件路径:com.chen.singleton
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午4:42:34
 * @版本:V1.0
 */
package com.minghua.singleton;

/**
 * @类功能说明：单例模式，皇帝只能有一个哈
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class Emperor {
	private static Emperor emperor = null; //皇帝的名字
	private Emperor(){
		//只能有一个
	}
	public static Emperor getInstance(){
		if (null == emperor ){//如果没有皇帝，就创建一个，国不可一日无君
			emperor = new Emperor();
		}
		return emperor;
	}
	public static void emperorInfo (){
		System.out.println("我就是皇帝XXX");
	}

}
