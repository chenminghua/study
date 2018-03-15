/**
 * @文件名称:XiaoPan.java
 * @文件路径:com.chen.proxy
 * @公司名称：长虹多媒体公司
 * @作者:陈明华
 * @时间:2013-9-23下午2:57:57
 * @版本:V1.0
 */
package com.minghua.proxy;

/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 */
public class XiaoPan implements KindWoman {

	/* (non-Javadoc)
	 * @see com.chen.proxy.KindWoman#makeEyeWithMan()
	 */
	@Override
	public void makeEyeWithMan() {
		System.out.println("小潘抛媚眼！");
	}

	/* (non-Javadoc)
	 * @see com.chen.proxy.KindWoman#happyWithMan()
	 */
	@Override
	public void happyWithMan() {
		System.out.println("小潘在和男人Happy！");
	}

}
