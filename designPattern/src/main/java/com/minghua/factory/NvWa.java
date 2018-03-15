/**
 * @文件名称:NvWa.java
 * @文件路径:com.chen.factory
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-27下午5:35:10
 * @版本:V1.0
 */
package com.minghua.factory;

import com.minghua.factory.Human;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class NvWa {
	/**
	 *方法功能说明
	 *chen  2013-9-27
	 *@参数：@param args
	 *@return void
	 */
	public static void main(String[] args) {
		//女娲第一次造人，试验性质，少造点，火候不足，缺陷产品
		System.out.println("------------造出的第一批人是这样的：白人-----------------");
		Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
		whiteHuman.cry();
		whiteHuman.laugh();
		whiteHuman.talk();
		//女娲第二次造人，火候加足点，然后又出了个次品，黑人
		System.out.println("------------造出的第一批人是这样的：黑人-----------------");
		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		blackHuman.cry();
		blackHuman.laugh();
		blackHuman.talk();
		//女娲第三次造人，造出来的是黄色人种，完美
		System.out.println("\n\n------------造出的第三批人是这样的：黄色人种-----------------");
		Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
		yellowHuman.cry();
		yellowHuman.laugh();
		yellowHuman.talk();
	}

}
