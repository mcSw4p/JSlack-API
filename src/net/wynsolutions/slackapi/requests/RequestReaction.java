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
public class RequestReaction {

	private Request req;
	
	public RequestReaction(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>add(name, channelId, file, fileComment, timeStamp)</h2>
	 * 
	 * <p>This method adds a reaction (emoji) to an item 
	 * (file, file comment, channel message, group message, 
	 * or direct message). One of file, file_comment, or 
	 * the combination of channel and timestamp must be 
	 * specified.</p>
	 * 
	 * https://api.slack.com/methods/reactions.add
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Name: Reaction (emoji) name.</br>
	 * Channel: Channel where the message to add reaction to 
	 * was posted.</br>
	 * File: File to add reaction to.</br>
	 * FileComment: File comment to add reaction to.</br>
	 * TimeStamp: Timestamp of the message to add reaction to.</p>
	 * 
	 * @param name
	 * @param channelId
	 * @param file
	 * @param fileComment
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject add(String name, String channelId, String file, String fileComment, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("name", name);
		para.put("channel", channelId);
		para.put("file", file);
		para.put("file_comment", fileComment);
		para.put("timestamp", timeStamp);
		return this.req.post(SlackMethods.reactionsAdd, para);
	}

	/**
	 * <h2>get(channelId, file, fileComment, full, timeStamp)</h2>
	 * 
	 * <p>This method returns a list of all reactions for a 
	 * single item (file, file comment, channel message, group 
	 * message, or direct message).</p>
	 * 
	 * https://api.slack.com/methods/reactions.get
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel where the message to get reactions 
	 * for was posted.</br>
	 * File: File to get reactions for.</br>
	 * FileComment: File comment to get reactions for.</br>
	 * Full: If true always return the complete reaction list.</br>
	 * TimeStamp: Timestamp of the message to get reactions for.</p>
	 * 
	 * @param channelId
	 * @param file
	 * @param fileComment
	 * @param full
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject get(String channelId, String file, String fileComment, boolean full, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("file", file);
		para.put("file_comment", fileComment);
		para.put("full", full);
		para.put("timestamp", timeStamp);
		return this.req.post(SlackMethods.reactionsGet, para);
	}
	
	/**
	 * <h2>list(count, full, page, user)</h2>
	 * 
	 * <p>This method returns a list of all items (file, file 
	 * comment, channel message, group message, or direct 
	 * message) reacted to by a user.</p>
	 * 
	 * https://api.slack.com/methods/reactions.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Count: Number of items to return per page.</br>
	 * Full: If true always return the complete reaction list.</br>
	 * Page: Page number of results to return.</br>
	 * User: Show reactions made by this user. Defaults to 
	 * the authed user.</p>
	 * 
	 * @param count
	 * @param full
	 * @param page
	 * @param user
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(long count, boolean full, long page, String user){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("count", count);
		para.put("full", full);
		para.put("page", page);
		para.put("user", user);
		return this.req.post(SlackMethods.reactionsList, para);
	}
	
	/**
	 * <h2>remove(name, channelId, file, fileComment, timeStamp)</h2>
	 * 
	 * <p>This method removes a reaction (emoji) from an item 
	 * (file, file comment, channel message, group message, 
	 * or direct message). One of file, file_comment, or the 
	 * combination of channel and timestamp must be specified.</p>
	 * 
	 * https://api.slack.com/methods/reactions.remove
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Name: Reaction (emoji) name.</br>
	 * Channel: Channel where the message to remove reaction 
	 * from was posted.</br>
	 * File: File to remove reaction from.</br>
	 * FileComment: File comment to remove reaction from.</br>
	 * TimeStamp: Timestamp of the message to remove reaction 
	 * from.</p>
	 * 
	 * @param name
	 * @param channelId
	 * @param file
	 * @param fileComment
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject remove(String name, String channelId, String file, String fileComment, String timeStamp){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("name", name);
		para.put("channel", channelId);
		para.put("file", file);
		para.put("file_comment", fileComment);
		para.put("timestamp", timeStamp);
		return this.req.post(SlackMethods.reactionsRemove, para);
	}
	
}
