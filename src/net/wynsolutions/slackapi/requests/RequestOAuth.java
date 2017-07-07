package net.wynsolutions.slackapi.requests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import net.wynsolutions.slackapi.Slack;
import net.wynsolutions.slackapi.methods.SlackMethods;

/**
 * Copyright (C) 2017  Sw4p
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Sw4p
 *
 */
public class RequestOAuth {

	private Request req;
	
	public RequestOAuth(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>access(clientId, clientSecret, code, redirectUri)</h2>
	 * 
	 * <p>This method allows you to exchange a temporary OAuth 
	 * code for an API access token. This is used as part of 
	 * the OAuth authentication flow.</p>
	 * 
	 * <p>As discussed in RFC 6749 it is possible to supply 
	 * the Client ID and Client Secret using the HTTP Basic 
	 * authentication scheme. If HTTP Basic authentication is 
	 * used you do not need to supply the client_id and 
	 * client_secret parameters as part of the request.</p>
	 * 
	 * <p>Keep your tokens secure. Do not share tokens with 
	 * users or anyone else.</p>
	 * 
	 * https://api.slack.com/methods/oauth.access
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ClientId: Issued when you created your application.</br>
	 * ClientSecret: Issued when you created your application.</br>
	 * Code: The code param returned via the OAuth callback.</br>
	 * Redirect: This must match the originally submitted URI (if 
	 * one was sent).</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject access(String clientId, String clientSecret, String code, String redirect){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("client_id", clientId);
		para.put("client_secret", clientSecret);
		para.put("code", code);
		para.put("redirect_uri", redirect);
		return this.req.post(SlackMethods.oauthAccess, para);
	}
	
}
