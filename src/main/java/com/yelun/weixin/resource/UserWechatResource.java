package com.yelun.weixin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yelun.weixin.config.WechatConfig;
import com.yelun.weixin.domain.user.UserRepo;
import com.yelun.weixin.domain.user.WechatUser;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 微信用户资源类
 * @author yelun
 *
 */
@Path("users/wechat/")
@Service
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserWechatResource {
	
	@Autowired private UserRepo userRepo;
	
	/**
	 * 微信公众号获取授权连接
	 * @param redirectUrl
	 * @return url
	 */
	@GET
	@Path("authorizationUrl")
	public String oauth2buildAuthorizationUrl(@QueryParam("redirectUrl") String redirectUrl) {
		WxMpService service = WechatConfig.getWxMpService();
		
		String url = service.oauth2buildAuthorizationUrl(redirectUrl, WxConsts.OAUTH2_SCOPE_USER_INFO, "STATE");
		return url;
	}
	
	/**
	 * 注册微信用户
	 * @param code
	 * @return
	 */
	public WechatUser saveUserWechat(@QueryParam("code") String code) {
		WxMpService service = WechatConfig.getWxMpService();
		WxMpOAuth2AccessToken accessToken;
		WxMpUser wxUser = null;
		try {
			accessToken = service.oauth2getAccessToken(code);
			wxUser = service.oauth2getUserInfo(accessToken, "zh_CN");
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		WechatUser wechatUser = userRepo.getWechatUserByOpenId(wxUser.getOpenId());
		if (wechatUser == null) {
			wechatUser = new WechatUser(wxUser); 
			wechatUser.update(wxUser);
			userRepo.saveWechatUser(wechatUser);
		}else {
			wechatUser.update(wxUser);
			userRepo.updateWechatUser(wechatUser);
		}
		return wechatUser;
	}
}
