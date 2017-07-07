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
public class RequestIm {

	private Request req;
	
	public RequestIm(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>close(channelId)</h2>
	 * 
	 * <p>This method closes a direct message channel.</p>
	 * 
	 * https://api.slack.com/methods/im.close
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Direct message channel to close.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject close(String channelId){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		return this.req.post(SlackMethods.imClose, para);
	}
	
	/**
	 * <h2>history(channelName, latest, oldest, inclusive, count, unreads)</h2>
	 * 
	 * <p>This method returns a portion of messages/events from the 
	 * specified direct message channel. To read the entire history for 
	 * a direct message channel, call the method with no latest or 
	 * oldest arguments, and then continue paging using the instructions 
	 * below.</p>
	 * 
	 * https://api.slack.com/methods/im.history
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Direct message channel to fetch history for.</br>
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
	 * <p>This method returns a list of all im channels that 
	 * the user has.</p>
	 * 
	 * https://api.slack.com/methods/im.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		return this.req.post(SlackMethods.imList, para);
	}
	
	/**
	 * <h2>mark(channelId, timeStamp)</h2>
	 * 
	 * <p>This method moves the read cursor in a direct message 
	 * channel.</p>
	 * 
	 * https://api.slack.com/methods/im.mark
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
		return this.req.post(SlackMethods.imMark, para);
	}
	
	/**
	 * <h2>open(userId, returnIm)</h2>
	 * 
	 * <p>This method opens a direct message channel with another 
	 * member of your Slack team.</p>
	 * 
	 * https://api.slack.com/methods/im.open
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>User: User to open a direct message channel with.</br>
	 * ReturnIm: Boolean, indicates you want the full IM channel 
	 * definition in the response.</p>
	 * 
	 * @param userId
	 * @param returnIm
	 * 
	 * @return JSONObject 
	 */
	public JSONObject open(String userId, boolean returnIm){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("user", userId);
		para.put("return_im", returnIm);
		return this.req.post(SlackMethods.imOpen, para);
	}
	
	/**
	 * <h2>replies(channelId, threadTimeStamp)</h2>
	 * 
	 * <p>This method returns an entire thread (a message plus 
	 * all the messages in reply to it).</p>
	 * 
	 * https://api.slack.com/methods/im.replies
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Direct message channel to fetch thread from.</br>
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
		return this.req.post(SlackMethods.imReplies, para);
	}
	
}
