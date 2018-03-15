/**
 * @文件名称:SingletonPattern.java
 * @文件路径:com.chen.singleton
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-27下午4:58:46
 * @版本:V1.0
 */
package com.minghua.singleton;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class SingletonPattern {
	private static final SingletonPattern singletonPattern = new SingletonPattern();
	//限制住不能直接产生一个实例
	private SingletonPattern(){
		
	}
	
	public synchronized static SingletonPattern getInstance(){
		return singletonPattern;
	}
}
 