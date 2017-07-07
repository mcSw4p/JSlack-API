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
public class RequestChannel {

	private Request req;
	
	public RequestChannel(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>archive(ChannelId)</h2>
	 * 
	 * <p>This method archives a channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.archive
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ChannelId: Channel to archive</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject archive(String channelId){
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.channelArchive, parameters);
	}
	
	/**
	 * <h2>create(channelName, validate)</h2>
	 * 
	 * <p>This method is used to create a channel.To create a 
	 * private channel, use groups.create.</p>
	 * 
	 * https://api.slack.com/methods/channels.create
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ChannelName: Name of channel to create (length <= 21)</br>
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
		return this.req.post(SlackMethods.channelCreate, parameters);
	}
	
	/**
	 * <h2>history(channelName, latest, oldest, inclusive, count, unreads)</h2>
	 * 
	 * <p>This method returns a portion of message events from the 
	 * specified public channel. To read the entire history for a 
	 * channel, call the method with no latest or oldest arguments. 
	 * To retrieve a single message, specify its ts value as latest, 
	 * set inclusive to true, and dial your count down to 1.</p>
	 * 
	 * https://api.slack.com/methods/channels.history
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to fetch history for </br>
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
		return this.req.post(SlackMethods.channelHistory, parameters);
	}
	
	/**
	 * <h2>info(channelId)</h2>
	 * 
	 * <p>This method returns information about a team channel.
	 * To retrieve information on a private channel, use 
	 * groups.info.</p>
	 * 
	 * https://api.slack.com/methods/channels.info
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to get info on</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.channelInfo, parameters);
	}
	
	/**
	 * <h2>invite(channelId, userId)</h2>
	 * 
	 * <p>This method is used to invite a user to a channel. The 
	 * calling user must be a member of the channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.invite
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to invite user to.</br>
	 * User: User to invite to channel.</p>
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
		return this.req.post(SlackMethods.channelInvite, parameters);
	}
	
	/**
	 * <h2>join(channelName, validate)</h2>
	 * 
	 * <p>This method is used to join a channel. If the 
	 * channel does not exist, it is created.</p>
	 * 
	 * https://api.slack.com/methods/channels.join
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Name: Name of channel to join.</br>
	 * Validate: Whether to return errors on invalid 
	 * channel name instead of modifying it to meet 
	 * the specified criteria.</p>
	 * 
	 * @param channelName
	 * @param validate
	 * 
	 * @return JSONObject 
	 */
	public JSONObject join(String channelName, boolean validate){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("name", channelName);
		parameters.put("validate", validate);
		return this.req.post(SlackMethods.channelJoin, parameters);
	}
	
	/**
	 * <h2>kick(channelId, userId)</h2>
	 * 
	 * <p>This method allows a user to remove another 
	 * member from a team channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.kick
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to remove user from.</br>
	 * User: User to remove from channel.</p>
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
		return this.req.post(SlackMethods.channelKick, parameters);
	}
	
	/**
	 * <h2>leave(channelId)</h2>
	 * 
	 * <p>This method is used to leave a channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.leave
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to leave.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject leave(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.channelLeave, parameters);
	}
	
	/**
	 * <h2>list(excludeArchived, excludeMembers)</h2>
	 * 
	 * <p>This method returns a list of all channels in the team. 
	 * This includes channels the caller is in, channels they are 
	 * not currently in, and archived channels but does not include 
	 * private channels. The number of (non-deactivated) members in 
	 * each channel is also returned.</br>
	 * To retrieve a list of private channels, use groups.list.</br>
	 * Having trouble getting a HTTP 200 response from this method? 
	 * Try excluding the members list from each channel object using 
	 * the exclude_members parameter.</p>
	 * 
	 * https://api.slack.com/methods/channels.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>ExcludeArchive: Exclude archived channels from the list</br>
	 * ExcludeMembers: Exclude the members collection from each 
	 * channel.</p>
	 * 
	 * @param excludeArchived
	 * @param excludeMembers
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(boolean excludeArchived, boolean excludeMembers){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("exclude_archived", excludeArchived);
		parameters.put("exclude_members", excludeMembers);
		return this.req.post(SlackMethods.channelList, parameters);
	}
	
	/**
	 * <h2>mark(channelId, timeStamp)</h2>
	 * 
	 * <p>This method moves the read cursor in a channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.mark
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to set reading cursor in.</br>
	 * TimeStamp: Timestamp of the most recently seen message.</p>
	 * 
	 * @param channelId
	 * @param timeStamp
	 * 
	 * @return JSONObject 
	 */
	public JSONObject mark(String channelId, String timeStamp){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		parameters.put("ts", timeStamp);
		return this.req.post(SlackMethods.channelMark, parameters);
	}
	
	/**
	 * <h2>rename(channelId, channelName, validate)</h2>
	 * 
	 * <p>This method renames a team channel. The only people who 
	 * can rename a channel are Team Admins, or the person that 
	 * originally created the channel. Others will receive a 
	 * "not_authorized" error.</p>
	 * 
	 * https://api.slack.com/methods/channels.rename
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to rename.</br>
	 * ChannelName: New name for channel.</br>
	 * Validate: Whether to return errors on invalid channel 
	 * name instead of modifying it to meet the specified 
	 * criteria.</p>
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
		return this.req.post(SlackMethods.channelRename, parameters);
	}
	
	/**
	 * <h2>replies(channelId, threadTs)</h2>
	 * 
	 * <p>This method returns an entire thread (a message plus all 
	 * the messages in reply to it).</p>
	 * <p>The channel and thread_ts arguments are always required. 
	 * thread_ts must be the timestamp of an existing message with 
	 * 0 or more replies. If there are no replies then just the 
	 * single message referenced by thread_ts will be returned - 
	 * it is just an ordinary message.</p>
	 * 
	 * https://api.slack.com/methods/channels.replies
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to rename.</br>
	 * ThreadTimeStamp: New name for channel.</p>
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
		return this.req.post(SlackMethods.channelReplies, parameters);
	}
	
	/**
	 * <h2>setPurpose(channelId, purpose)</h2>
	 * 
	 * <p>This method is used to change the purpose of a channel. 
	 * The calling user must be a member of the channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.setPurpose
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to set the purpose of.</br>
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
		return this.req.post(SlackMethods.channelSetPurpose, parameters);
	}
	
	/**
	 * <h2>setTopic(channelId, topic)</h2>
	 * 
	 * <p>This method is used to change the topic of a channel. 
	 * The calling user must be a member of the channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.setTopic
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to set the topic of.</br>
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
		return this.req.post(SlackMethods.channelSetTopic, parameters);
	}
	
	/**
	 * <h2>unarchive(channelId)</h2>
	 * 
	 * <p>This method unarchives a channel. The calling user 
	 * is added to the channel.</p>
	 * 
	 * https://api.slack.com/methods/channels.unarchive
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to unarchive.</p>
	 * 
	 * @param channelId
	 * 
	 * @return JSONObject 
	 */
	public JSONObject unarchive(String channelId){			
		Map<String, Object> parameters = new LinkedHashMap<>();
		parameters.put("token", Slack.SLACK_TOKEN);
		parameters.put("channel", channelId);
		return this.req.post(SlackMethods.channelUnarchive, parameters);
	}
	
}
