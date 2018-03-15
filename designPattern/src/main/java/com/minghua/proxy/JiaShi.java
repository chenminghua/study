/**
 * @文件名称:JiaShi.java
 * @文件路径:com.chen.proxy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午3:07:37
 * @版本:V1.0
 */
package com.minghua.proxy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class JiaShi implements KindWoman {

	@Override
	public void makeEyeWithMan() {
		System.out.println("贾氏正在抛媚眼！");		
	}

	@Override
	public void happyWithMan() {
		System.out.println("贾氏正在和男人HAPPY！");
	}

}
