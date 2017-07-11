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
public class RequestPin {

	private Request req;
	
	public RequestPin(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>add(channelId, file, fileComment, timeStamp)</h2>
	 * 
	 * <p>This method pins an item (file, file comment, channel 
	 * message, or group message) to a particular channel. The 
	 * channel argument is required and one of file, file_comment, 
	 * or timestamp must also be specified.</p>
	 * 
	 * <p>Note that you cannot pin join/leave messages in channels 
	 * and groups.</p>
	 * 
	 * https://api.slack.com/methods/pins.add
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to pin the item in.</br>
	 * File: File to pin.</br>
	 * FileComment: File comment to pin.</br>
	 * TimeStamp: Timestamp of the message to pin.</p>
	 * 
	 * @param channelId
	 * @param file
	 * @param fileComment
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject add(String channelId, String file, String fileComment, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("file", file);
		para.put("file_comment", fileComment);
		para.put("timestamp", timeStamp);
		return this.req.post(SlackMethods.pinsAdd, para);
	}
	
	/**
	 * <h2>list(channelId)</h2>
	 * 
	 * <p>This method lists the items pinned to a channel.</p>
	 * 
	 * https://api.slack.com/methods/pins.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to get pinned items for.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(String channelId){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		return this.req.post(SlackMethods.pinsList, para);
	}
	
	/**
	 * <h2>remove(channelId, file, fileComment, timeStamp)</h2>
	 * 
	 * <p>This method un-pins an item (file, file comment, 
	 * channel message, or group message) from a channel. 
	 * The channel argument is required and one of file, 
	 * file_comment, or timestamp must also be specified.</p>
	 * 
	 * https://api.slack.com/methods/pins.remove
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel where the item is pinned to.</br>
	 * File: File to un-pin.</br>
	 * FileComment: File comment to un-pin.</br>
	 * TimeStamp: Timestamp of the message to un-pin.</p>
	 * 
	 * @param channelId
	 * @param file
	 * @param fileComment
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject remove(String channelId, String file, String fileComment, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("file", file);
		para.put("file_comment", fileComment);
		para.put("timestamp", timeStamp);
		return this.req.post(SlackMethods.pinsRemove, para);
	}
	
}
