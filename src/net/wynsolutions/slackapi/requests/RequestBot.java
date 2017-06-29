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
public class RequestBot {

	private static Request req;
	
	public RequestBot(Request request) {
		req = request;
	}
	
	/**
	 * <h2>info(botId)</h2>
	 * 
	 * <p>This method returns information about a bot user. @param botId 
	 * is returned from bot_message message events and in the response 
	 * of methods like channels.history.
	 * </br>
	 * Use this method to look up the username and icons for those 
	 * bot users. Use the app_id field to identify whether a bot 
	 * belongs to your Slack app.</p>
	 * 
	 * https://api.slack.com/methods/bots.info
	 * <h2>URL Parameters</h2>
	 * 
	 * <p>Bot: Bot user to get info on</p>
	 * 
	 * @param botId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(String botId){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("bot", botId);
		return req.post(SlackMethods.botsInfo, para);
	}
	
	/**
	 * <h2>info()</h2>
	 * 
	 * <p>This method returns information about bot user.</p>
	 * 
	 * https://api.slack.com/methods/bots.info
	 * <h2>URL Parameters</h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return req.post(SlackMethods.botsInfo, para);
	}
}
