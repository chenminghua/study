/**
 * @文件名称:Emperor.java
 * @文件路径:com.chen.multition
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-27下午5:06:51
 * @版本:V1.0
 */
package com.minghua.multition;

import java.util.ArrayList;
import java.util.Random;

/**
 * @类功能说明：多例模式，例如明朝时期的两个皇帝
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
@SuppressWarnings("all")
public class Emperor {
	private static int maxNumOfEmperor = 2;//限制最多有两个皇帝
	private static ArrayList emperorInfoList = new ArrayList(maxNumOfEmperor);
	private static ArrayList emperorList = new ArrayList(maxNumOfEmperor);
	private static int countNumOfEmperor = 0;//正在被称为皇帝的那个
	//把两个皇帝造出来
	static{
		//把所有皇帝都造出来
		for(int i = 0; i < maxNumOfEmperor; i++){
			emperorList.add(new Emperor("皇帝" + i +"号"));
		}
	}
	//好了，最多也就两个了
	private Emperor(){
		
	}
	private Emperor(String info){
		emperorInfoList.add(info);
	}
	public static Emperor getInstance(){
		Random random = new Random();
		countNumOfEmperor = random.nextInt(maxNumOfEmperor);
		return (Emperor) emperorList.get(countNumOfEmperor);
	}
	//皇帝的名字
	public static void emperorInfo(){
		System.out.println(emperorInfoList.get(countNumOfEmperor));
	}
}
