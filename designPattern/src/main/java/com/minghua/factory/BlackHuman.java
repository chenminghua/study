/**
 * @文件名称:YellowHuman.java
 * @文件路径:com.chen.factory
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-27下午5:25:10
 * @版本:V1.0
 */
package com.minghua.factory;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class BlackHuman implements Human {

	@Override
	public void laugh() {
		System.out.println("黑人种会哭");
	}

	@Override
	public void cry() {
		System.out.println("黑人种会大笑，幸福呀！");
	}

	@Override
	public void talk() {
		System.out.println("黑人种会说话，但是一般都听不懂");
	}

}
