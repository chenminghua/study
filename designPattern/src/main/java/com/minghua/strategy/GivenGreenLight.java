/**
 * @文件名称:GivenGreenLight.java
 * @文件路径:com.chen.strategy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-17下午5:49:12
 * @版本:V1.0
 */
package com.minghua.strategy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class GivenGreenLight implements IStrategy {

	/* (non-Javadoc)
	 * @see com.chen.strategy.IStratrgy#opertare()
	 */
	@Override
	public void opertare() {
		System.out.println("求吴国太开个绿灯,放行！");
	}

}
