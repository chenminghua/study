/**
 * @文件名称:Minister.java
 * @文件路径:com.chen.singleton
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午4:48:29
 * @版本:V1.0
 */
package com.minghua.singleton;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
@SuppressWarnings("all")
public class Minister {
	public static void main(String[] args){
		//First day
		Emperor emperor1 = Emperor.getInstance();
		emperor1.emperorInfo();
		//Second day
		Emperor emperor2 = Emperor.getInstance();
		emperor2.emperorInfo();
		//third day
		Emperor emperor3 = Emperor.getInstance();
		emperor3.emperorInfo();
	}
}
