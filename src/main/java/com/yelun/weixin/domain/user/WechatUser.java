package com.yelun.weixin.domain.user;

import com.yelun.weixin.utils.TimeUtil;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class WechatUser {
    private Integer id;

    private String openid;

    private String nickname;

    private Integer sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String privilege;

    private String unionid;

    private Long creditTime;
    
    /**
     * 初始化信息
     * @param wxUser
     */
	public WechatUser(WxMpUser wxUser) {
		this.openid = wxUser.getOpenId();
		this.creditTime = TimeUtil.getCurrentTime();
	}
	
	/**
	 * 更新用户信息
	 * @param wxUser
	 */
	public void update(WxMpUser wxUser) {
		this.nickname = wxUser.getNickname();
		this.sex = Sex.valueOf(wxUser.getSex()).code;
		this.province = wxUser.getProvince();
		this.city = wxUser.getCity();
		this.country = wxUser.getCountry();
		this.headimgurl = wxUser.getHeadImgUrl();
		this.privilege = wxUser.getProvince();
		this.unionid = wxUser.getUnionId();
	}
	
	public enum Sex{
		UNKNOWN (0, "未知"),
		MAN (1, "男") ,
		WOMAN (2, "女") ;
		
		private final int code;
		private final String desc;
		
		private Sex(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}
		
		public int getCode() {
			return code;
		}
		public String getDesc() {
			return desc;
		}
		
	}
	
	public WechatUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public Long getCreditTime() {
		return creditTime;
	}

	public void setCreditTime(Long creditTime) {
		this.creditTime = creditTime;
	}

}