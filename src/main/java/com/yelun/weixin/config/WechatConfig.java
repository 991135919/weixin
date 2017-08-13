package com.yelun.weixin.config;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

@Component
public class WechatConfig {
	
	private static final WxMpService wxService = setWxMpService();
	
	private static WxMpInMemoryConfigStorage getConfig() {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx6e2c894e58e678df"); // 设置微信公众号的appid
		config.setSecret("ca6097a32bfb9d6231cfef0eb1123fb8"); // 设置微信公众号的app corpSecret
		config.setToken("yelun"); // 设置微信公众号的token
		config.setAesKey("e59ad8a2ad0f44f38aa1e59ad8a2ad0f44f38aa1qaz"); // 设置微信公众号的EncodingAESKey
		
		return config;
	}
	
	private static WxMpService setWxMpService() {
		WxMpService wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(getConfig());
		return wxService;
	}
	 
	public static WxMpService getWxMpService() {
		return wxService;
	}
}
