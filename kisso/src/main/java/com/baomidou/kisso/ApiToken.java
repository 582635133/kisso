/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.kisso;

import com.baomidou.kisso.exception.KissoException;

/**
 * <p>
 * APP 授权 Token
 * </p>
 * 
 * @author hubin
 * @Date 2016-01-16
 */
public class ApiToken {
	/*
	 * 一次性票据
	 */
	private String token;

	/*
	 * 访问票据
	 */
	private String accessToken;

	/*
	 * AES密钥
	 */
	private String aesKey;

	public ApiToken() {
		/* 自定义处理方式 */
	}

	public ApiToken(String token, String accessToken, String aesKey) {
		this.token = token;
		this.accessToken = generateAccessToken(accessToken);
		this.aesKey = aesKey;
	}

	/**
	 * 
	 * 生成访问票据
	 * 
	 * @param accessToken
	 *            		访问票据
	 * @return
	 */
	private String generateAccessToken(String accessToken) {
		try {
			SSOConfig config = SSOConfig.getInstance();
			return config.getEncrypt().encrypt(accessToken, config.getSecretkey());
		} catch (Exception e) {
			throw new KissoException(e);
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = generateAccessToken(accessToken);
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

}
