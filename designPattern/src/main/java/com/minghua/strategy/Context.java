/**
 * @文件名称:Context.java
 * @文件路径:com.chen.strategy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-17下午5:51:48
 * @版本:V1.0
 */
package com.minghua.strategy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class Context {
	//构造函数，你要使用的那个妙计
	private IStrategy strategy;
	public Context (IStrategy strategy){
		this.strategy = strategy;
	}
	
	//使用计谋，看我出招了
	public void operate(){
		this.strategy.opertare();
	}
}
