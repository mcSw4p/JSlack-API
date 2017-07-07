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
public class RequestMpim {

	private Request req;
	
	public RequestMpim(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>close(channelId)</h2>
	 * 
	 * <p>This method closes a multiparty direct message 
	 * channel.</p>
	 * 
	 * https://api.slack.com/methods/mpim.close
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: MPIM to close.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject close(String channelId){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		return this.req.post(SlackMethods.mpimClose, para);
	}
	
	/**
	 * <h2>history(channelName, latest, oldest, inclusive, count, unreads)</h2>
	 * 
	 * <p>This method returns a portion of messages/events from the 
	 * specified multiparty direct message channel. To read the 
	 * entire history for a multiparty direct message, call the 
	 * method with no latest or oldest arguments, and then continue 
	 * paging using the instructions below.</p>
	 * 
	 * https://api.slack.com/methods/mpim.history
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Multiparty direct message to fetch history for.</br>
	 * Latest: End of time range of messages to include in results.</br>
	 * Oldest: Start of time range of messages to include in results.</br>
	 * Inclusive: Include messages with latest or oldest timestamp in results.</br>
	 * Count: Number of messages to return, between 1 and 1000.</br>
	 * Unreads: Include unread_count_display in the output?</p>
	 * 
	 * @param channelName
	 * @param latest
	 * @param oldest
	 * @param inclusive
	 * @param count
	 * @param unreads
	 * 
	 * @return JSONObject 
	 */
	public JSONObject history(String channelName, float latest, float oldest, 
			boolean inclusive, int count, boolean unreads){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelName);
		parameters.put("latest", latest);
		parameters.put("oldest", oldest);
		parameters.put("inclusive", inclusive);
		parameters.put("count", count);
		parameters.put("unreads", unreads);
		return this.req.post(SlackMethods.imHistory, parameters);
	}
	
	/**
	 * <h2>list()</h2>
	 * 
	 * <p>This method returns a list of all multiparty direct message 
	 * channels that the user has.</p>
	 * 
	 * https://api.slack.com/methods/mpim.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return this.req.post(SlackMethods.mpimList, para);
	}
	
	/**
	 * <h2>mark(channelId, timeStamp)</h2>
	 * 
	 * <p>This method moves the read cursor in a multiparty direct 
	 * message channel.</p>
	 * 
	 * https://api.slack.com/methods/mpim.mark
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Direct message channel to set reading cursor in.</br>
	 * TimeStamp: Timestamp of the most recently seen message.</p>
	 * 
	 * @param channelId
	 * @param thimeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject mark(String channelId, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("ts", timeStamp);
		return this.req.post(SlackMethods.mpimMark, para);
	}
	
	/**
	 * <h2>open(users)</h2>
	 * 
	 * <p>This method opens a multiparty direct message.</p>
	 * 
	 * <p>Opening a multiparty direct message takes a list 
	 * of up-to 8 encoded user ids. If there is no MPIM already 
	 * created that includes that exact set of members, a new 
	 * MPIM will be created. Subsequent calls to mpim.open with 
	 * the same set of users will return the already existing 
	 * MPIM conversation.</p>
	 * 
	 * https://api.slack.com/methods/mpim.open
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Users: Comma separated lists of users. The ordering 
	 * of the users is preserved whenever a MPIM group is 
	 * returned.</p>
	 * 
	 * @param users
	 * 
	 * @return JSONObject 
	 */
	public JSONObject open(String users){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("users", users);
		return this.req.post(SlackMethods.mpimOpen, para);
	}
	
	/**
	 * <h2>replies(channelId, threadTimeStamp)</h2>
	 * 
	 * <p>This method returns an entire thread (a message plus 
	 * all the messages in reply to it).</p>
	 * 
	 * <p>The channel and thread_ts arguments are always required. 
	 * thread_ts must be the timestamp of an existing message with 
	 * 0 or more replies. If there are no replies then just the 
	 * single message referenced by thread_ts will be returned 
	 * - it is just an ordinary message.</p>
	 * 
	 * https://api.slack.com/methods/mpim.replies
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Multiparty direct message channel to fetch 
	 * thread from.</br>
	 * ThreadTimeStamp: Unique identifier of a thread's parent 
	 * message.</p>
	 * 
	 * @param channelId
	 * @param threadTimeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject replies(String channelId, String threadTimeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("thread_ts", threadTimeStamp);
		return this.req.post(SlackMethods.mpimReplies, para);
	}
	
}
