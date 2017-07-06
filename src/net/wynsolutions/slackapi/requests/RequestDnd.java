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
public class RequestDnd {

	private Request req;
	
	public RequestDnd(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>endDnd()</h2>
	 * 
	 * <p>Ends the user's currently scheduled Do Not Disturb 
	 * session immediately.</p>
	 * 
	 * https://api.slack.com/methods/dnd.endDnd
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject endDnd(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return this.req.post(SlackMethods.dndEndDnd, para);
	}
	
	/**
	 * <h2>endSnooze()</h2>
	 * 
	 * <p>Ends the current user's snooze mode immediately.</p>
	 * 
	 * https://api.slack.com/methods/dnd.endSnooze
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject endSnooze(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return this.req.post(SlackMethods.dndEndSnooze, para);
	}
	
	/**
	 * <h2>info(userId)</h2>
	 * 
	 * <p>Provides information about a user's current Do Not Disturb 
	 * settings.</p>
	 * 
	 * https://api.slack.com/methods/dnd.info
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>User: User to fetch status for (defaults to current user)</p>
	 * 
	 * @param userId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(String userId){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("user", userId);
		return this.req.post(SlackMethods.dndInfo, para);
	}
	
	/**
	 * <h2>setSnooze(minutes)</h2>
	 * 
	 * <p>Adjusts the snooze duration for a user's Do Not Disturb settings. 
	 * If a snooze session is not already active for the user, invoking 
	 * this method will begin one for the specified duration.</p>
	 * 
	 * https://api.slack.com/methods/dnd.setSnooze
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Minutes: Number of minutes, from now, to snooze until.</p>
	 * 
	 * @param minutes
	 * 
	 * @return JSONObject 
	 */
	public JSONObject setSnooze(long minutes){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("num_minutes", minutes);
		return this.req.post(SlackMethods.dndSetSnooze, para);
	}
	
	/**
	 * <h2>teamInfo(users)</h2>
	 * 
	 * <p>Provides information about the current Do Not Disturb settings 
	 * for users of a Slack team.</p>
	 * 
	 * https://api.slack.com/methods/dnd.teamInfo
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Users: Comma-separated list of users to fetch Do Not Disturb 
	 * status for. Set to \"\" to disable the users parameter.</p>
	 * 
	 * @param users
	 * 
	 * @return JSONObject 
	 */
	public JSONObject teamInfo(String users){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		if(!users.equals(""))
			para.put("users", users);
		return this.req.post(SlackMethods.dndTeamInfo, para);
	}
	
}
