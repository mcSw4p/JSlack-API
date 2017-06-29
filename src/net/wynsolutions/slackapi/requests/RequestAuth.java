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
public class RequestAuth {

	private static Request req;
	
	public RequestAuth(Request request) {
		req = request;
	}
	
	/**
	 * <h2>revoke(test)</h2>
	 * 
	 * <p>This method revokes an access token. Use it when you no longer
	 *  need a token. For example, with a Sign In With Slack app, call 
	 *  this to log a user out.</p>
	 * 
	 * https://api.slack.com/methods/auth.revoke
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Test: Setting this parameter to 1 triggers a testing mode where 
	 * the specified token will not actually be revoked.</p>
	 * 
	 * @param test
	 * 
	 * @return JSONObject 
	 */
	public JSONObject revoke(boolean test){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("test", test);
		return req.post(SlackMethods.authRevoke, para);
	}
	
	/**
	 * <h2>test()</h2>
	 * 
	 * <p>This method checks authentication and tells you who you are.</br>
	 * When working against a team within an Enterprise Grid, you'll 
	 * also find their enterprise_id here.</p>
	 * 
	 * https://api.slack.com/methods/auth.test
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject test(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return req.post(SlackMethods.authTest, para);
	}
	
}
