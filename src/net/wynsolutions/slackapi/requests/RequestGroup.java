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
public class RequestGroup {

	private Request req;
	
	public RequestGroup(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>archive(ChannelId)</h2>
	 * 
	 * <p>This method archives a private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.archive
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ChannelId: Private channel to archive</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject archive(String channelId){
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsArchive, parameters);
	}
	
	/**
	 * <h2>close(channelId)</h2>
	 * 
	 * <p>This method closes a private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.close
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to close.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject close(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsClose, parameters);
	}
	
	/**
	 * <h2>create(channelName, validate)</h2>
	 * 
	 * <p>This method creates a private channel.</p>
	 * 
	 * <p>Private channel names can only contain lowercase letters, 
	 * numbers, hyphens, and underscores, and must be 21 characters 
	 * or less. We will validate the submitted channel name and 
	 * modify it to meet the above criteria. When calling this method,
	 *  we recommend storing the private channel's name value that 
	 *  is returned in the response.</p>
	 * 
	 * https://api.slack.com/methods/groups.create
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ChannelName: Name of private channel to create.</br>
	 * Validate: Whether to return errors on invalid channel 
	 * name instead of modifying it to meet the specified criteria.</p>
	 * 
	 * @param channelName
	 * @param validate
	 * 
	 * @return JSONObject 
	 */
	public JSONObject create(String channelName, boolean validate){
		if(!(channelName.length() <= 21))
			return null;				
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("name", channelName);
		parameters.put("validate", validate);
		return this.req.post(SlackMethods.groupsCreate, parameters);
	}
	
	/**
	 * <h2>createChild(channelId)</h2>
	 * 
	 * <pThis method takes an existing private channel and performs 
	 * the following steps:</br>
	 * <ul>
	 *   <li>Renames the existing private channel (from "example" to 
	 *   "example-archived").</li>
	 *   <li>Archives the existing private channel.</li>
	 *   <li>Creates a new private channel with the name of the existing 
	 *   private channel.</li>
	 *   <li>Adds all members of the existing private channel to the new 
	 *   private channel.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>This is useful when inviting a new member to an existing private 
	 * channel while hiding all previous chat history from them. In this 
	 * scenario you can call groups.createChild followed by groups.invite.</p>
	 * 
	 * <p>The new private channel will have a special parent_group property 
	 * pointing to the original archived private channel. This will only be 
	 * returned for members of both private channels, so will not be visible 
	 * to any newly invited members.</p>
	 * 
	 * https://api.slack.com/methods/groups.createChild
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to clone and archive.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject createChild(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsCreateChild, parameters);
	}
	
	/**
	 * <h2>history(channelName, latest, oldest, inclusive, count, unreads)</h2>
	 * 
	 * <p>This method returns a portion of messages/events from the specified 
	 * private channel. To read the entire history for a private channel, 
	 * call the method with no latest or oldest arguments, and then continue 
	 * paging using the instructions below.</p>
	 * 
	 * https://api.slack.com/methods/groups.history
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to fetch history for </br>
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
		return this.req.post(SlackMethods.groupsHistory, parameters);
	}
	
	/**
	 * <h2>info(channelId)</h2>
	 * 
	 * <p>This method returns information about a private channel.</p>
	 * 
	 * https://api.slack.com/methods/group.info
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to get info on</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsInfo, parameters);
	}
	
	/**
	 * <h2>invite(channelId, userId)</h2>
	 * 
	 * <p>This method is used to invite a user to a private 
	 * channel. The calling user must be a member of the private 
	 * channel.</p>
	 * 
	 * <p>To invite a new member to a private channel without 
	 * giving them access to the archives of the private channel, 
	 * call the groups.createChild method before inviting.</p>
	 * 
	 * https://api.slack.com/methods/groups.invite
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to invite user to.</br>
	 * User: User to invite.</p>
	 * 
	 * @param channelId
	 * @param userId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject invite(String channelId, String userId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("user", userId);
		return this.req.post(SlackMethods.groupsInvite, parameters);
	}
	
	/**
	 * <h2>kick(channelId, userId)</h2>
	 * 
	 * <p>This method allows a user to remove another member from a 
	 * private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.kick
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to remove user from.</br>
	 * User: User to remove from private channel.</p>
	 * 
	 * @param channelId
	 * @param userId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject kick(String channelId, String userId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("user", userId);
		return this.req.post(SlackMethods.groupsKick, parameters);
	}
	
	/**
	 * <h2>leave(channelId)</h2>
	 * 
	 * <p>This method is used to leave a private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.leave
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to leave.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject leave(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsLeave, parameters);
	}
	
	/**
	 * <h2>list(excludeArchived)</h2>
	 * 
	 * <p>This method returns a list of private channels in the 
	 * team that the caller is in and archived groups that the 
	 * caller was in. The list of (non-deactivated) members in each 
	 * private channel is also returned.</p>
	 * 
	 * https://api.slack.com/methods/groups.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ExcludeArchive: Don't return archived private channels.</p>
	 * 
	 * @param excludeArchived
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(boolean excludeArchived){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("exclude_archived", excludeArchived);
		return this.req.post(SlackMethods.groupsList, parameters);
	}
	
	/**
	 * <h2>mark(channelName, timeStamp)</h2>
	 * 
	 * <p>This method moves the read cursor in a private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.mark
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ChannelName: Private channel to set reading cursor in.</br>
	 * TimeStamp: Timestamp of the most recently seen message.</p>
	 * 
	 * @param channelName
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject mark(String channelId, String timeStamp){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("name", channelId);
		parameters.put("ts", timeStamp);
		return this.req.post(SlackMethods.groupsMark, parameters);
	}
	
	/**
	 * <h2>open(channelId)</h2>
	 * 
	 * <p>This method opens a private channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.open
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to open.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject open(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsOpen, parameters);
	}
	
	/**
	 * <h2>rename(channelId, channelName, validate)</h2>
	 * 
	 * <p>This method renames a private channel.</p>
	 * 
	 * <p>Private channel names can only contain lowercase letters, 
	 * numbers, hyphens, and underscores, and must be 21 characters 
	 * or less. We will validate the submitted channel name and 
	 * modify it to meet the above criteria. When calling this 
	 * method, we recommend storing the channel's name value that 
	 * is returned in the response.</p>
	 * 
	 * https://api.slack.com/methods/groups.rename
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to rename.</br>
	 * ChannelName: New name for private channel.</br>
	 * Validate: Whether to return errors on invalid channel name 
	 * instead of modifying it to meet the specified criteria.</p>
	 * 
	 * @param channelId
	 * @param channelName
	 * @param validate
	 * 
	 * @return JSONObject 
	 */
	public JSONObject rename(String channelId, String channelName, boolean validate){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("name", channelName);
		parameters.put("validate", validate);
		return this.req.post(SlackMethods.groupsRename, parameters);
	}
	
	/**
	 * <h2>replies(channelId, threadTs)</h2>
	 * 
	 * <p>This method returns an entire thread (a message plus all the 
	 * messages in reply to it).</p>
	 * <p>The channel and thread_ts arguments are always required. 
	 * thread_ts must be the timestamp of an existing message with 0 
	 * or more replies. If there are no replies then just the single 
	 * message referenced by thread_ts will be returned - it is just 
	 * an ordinary message.</p>
	 * 
	 * https://api.slack.com/methods/groups.replies
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to fetch thread from.</br>
	 * ThreadTimeStamp: Unique identifier of a thread's parent 
	 * message.</p>
	 * 
	 * @param channelId
	 * @param threadTs
	 * 
	 * @return JSONObject 
	 */
	public JSONObject replies(String channelId, String threadTs){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("thread_ts", threadTs);
		return this.req.post(SlackMethods.groupsReplies, parameters);
	}
	
	/**
	 * <h2>setPurpose(channelId, purpose)</h2>
	 * 
	 * <p>This method is used to change the purpose of a private channel. 
	 * The calling user must be a member of the private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.setPurpose
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to set the purpose of.</br>
	 * Purpose: The new purpose.</p>
	 * 
	 * @param channelId
	 * @param purpose
	 * 
	 * @return JSONObject 
	 */
	public JSONObject setPurpose(String channelId, String purpose){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("purpose", purpose);
		return this.req.post(SlackMethods.groupsSetPurpose, parameters);
	}
	
	/**
	 * <h2>setTopic(channelId, topic)</h2>
	 * 
	 * <p>This method is used to change the topic of a private channel. 
	 * The calling user must be a member of the private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.setTopic
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to set the topic of.</br>
	 * Topic: The new topic.</p>
	 * 
	 * @param channelId
	 * @param topic
	 * 
	 * @return JSONObject 
	 */
	public JSONObject setTopic(String channelId, String topic){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("topic", topic);
		return this.req.post(SlackMethods.groupsSetTopic, parameters);
	}
	
	/**
	 * <h2>unarchive(channelId)</h2>
	 * 
	 * <p>This method unarchives a private channel.</p>
	 * 
	 * https://api.slack.com/methods/groups.unarchive
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Private channel to unarchive.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject unarchive(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.groupsUnarchive, parameters);
	}
	
}
