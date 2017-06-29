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
public class RequestChat {

	private static Request req;
	
	public RequestChat(Request request) {
		req = request;
	}
	
	/**
	 * <h2>delete(timeStamp, channelId, asUser)</h2>
	 * 
	 * <p>This method deletes a message from a channel.</p>
	 * 
	 * https://api.slack.com/methods/chat.delete
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>TimeStamp: Timestamp of the message to be deleted.</br>
	 * Channel: Channel containing the message to be deleted.</br>
	 * AsUser: Pass true to delete the message as the authed user. 
	 * Bot users in this context are considered authed users.</p>
	 * 
	 * @param timeStamp
	 * @param channelId
	 * @param asUser
	 * 
	 * @return JSONObject 
	 */
	public JSONObject delete(String timeStamp, String channelId, boolean asUser){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("ts", timeStamp);
		para.put("channel", channelId);
		para.put("as_user", asUser);
		return req.post(SlackMethods.chatDelete, para);
	}
	
	/**
	 * <h2>meMessage(timeStamp, channelId, asUser)</h2>
	 * 
	 * <p>This method sends a me message to a channel from the calling user.</p>
	 * 
	 * https://api.slack.com/methods/chat.meMessage
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel to send message to. Can be a public channel, private group or IM channel. Can be an encoded ID, or a name.</br>
	 * Text: Text of the message to send.</p>
	 * 
	 * @param channelId
	 * @param text
	 * 
	 * @return JSONObject 
	 */
	public JSONObject meMessage(String channelId, String text){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("text", text);
		return req.post(SlackMethods.chatMeMessage, para);
	}
	
	/**
	 * <h2>postMessage(timeStamp, channelId, asUser)</h2>
	 * 
	 * <p>This method posts a message to a public channel, private 
	 * channel, or direct message/IM channel.</p>
	 * 
	 * <p>Please note that the default value of the as_user parameter 
	 * varies depending on the kind of token you're using. It's best 
	 * to be explicit with this value. Read more about Authorship to 
	 * understand how its default value may vary.</br>
	 * https://api.slack.com/methods/chat.postMessage#authorship</br>
	 * https://api.slack.com/methods/chat.postMessage#formatting</p>
	 * 
	 * <p>A message must have either text or attachments or both. The 
	 * text parameter is required unless you provide attachments. You 
	 * can use both parameters in conjunction with each other to 
	 * create awesome messages.</p>
	 * 
	 * https://api.slack.com/methods/chat.postMessage
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Channel, private group, or IM channel to send message 
	 * to. Can be an encoded ID, or a name. See below for more details.</br>
	 * Text: Text of the message to send. See below for an explanation of 
	 * formatting. This field is usually required, unless you're providing 
	 * only attachments instead.</br>
	 * Parse: Change how messages are treated. Defaults to none. </br>
	 * LinkNames: Find and link channel names and usernames.</br>
	 * Attachments: Structured message attachments.</br>
	 * UnfurlLinks: Pass true to enable unfurling of primarily text-based 
	 * content.</br>
	 * UnfurlMedia: Pass false to disable unfurling of media content.</br>
	 * Username: Set your bot's user name. Must be used in conjunction with 
	 * as_user set to false, otherwise ignored.</br>
	 * AsUser: 	Pass true to post the message as the authed user, instead of 
	 * as a bot. Defaults to false.</br>
	 * IconUrl: URL to an image to use as the icon for this message. Must be 
	 * used in conjunction with as_user set to false, otherwise ignored.</br>
	 * IconEmoji: Emoji to use as the icon for this message. Overrides icon_url. 
	 * Must be used in conjunction with as_user set to false, otherwise ignored.</br>
	 * ThreadTS: Provide another message's ts value to make this message a reply. 
	 * Avoid using a reply's ts value; use its parent instead.</br>
	 * ReplyBroadcast: Used in conjunction with thread_ts and indicates whether 
	 * reply should be made visible to everyone in the channel or conversation. 
	 * Defaults to false.</p>
	 * 
	 * @param channelId
	 * @param text
	 * @param parse
	 * @param linkNames
	 * @param attachments
	 * @param unfurlLinks
	 * @param unfurlMedia
	 * @param username
	 * @param asUser
	 * @param iconUrl
	 * @param iconEmoji
	 * @param threadTs
	 * @param replyBroadcast
	 * 
	 * @return JSONObject 
	 */
	public JSONObject postMessage(String channelId, String text, String parse, boolean linkNames, String attachments, boolean unfurlLinks,
			boolean unfurlMedia, String username, boolean asUser, String iconUrl, String iconEmoji, String threadTs, boolean replyBroadcast){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("text", text);
		para.put("parse", parse);
		para.put("link_names", linkNames);
		para.put("attachments", attachments);
		para.put("unfurl_links", unfurlLinks);
		para.put("unfurl_media", unfurlMedia);
		para.put("username", username);
		para.put("as_user", asUser);
		para.put("icon_url", iconUrl);
		para.put("icon_emoji", iconEmoji);
		para.put("thread_ts", threadTs);
		para.put("reply_broadcast", replyBroadcast);
		return req.post(SlackMethods.chatPostMessage, para);
	}
	
	/**
	 * <h2>unfurl(channelId, timeStamp, unfurls, userAuth)</h2>
	 * 
	 * <p>This method attaches Slack app unfurl behavior to a specified 
	 * and relevant message. A user token is required as this method 
	 * does not support bot user tokens.</p>
	 * 
	 * <p>The first time this method is executed with a particular ts 
	 * and channel combination, the valid unfurls attachments you provide 
	 * will be attached to the message. Subsequent attempts with the same 
	 * ts and channel values will modify the same attachments, rather 
	 * than adding more.</p>
	 * 
	 * https://api.slack.com/methods/chat.delete
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>TimeStamp: Timestamp of the message to be deleted.</br>
	 * Channel: Channel containing the message to be deleted.</br>
	 * AsUser: Pass true to delete the message as the authed user. 
	 * Bot users in this context are considered authed users.</p>
	 * 
	 * @param channelId
	 * @param timeStamp
	 * @param unfurls
	 * @param userAuth
	 * 
	 * @return JSONObject 
	 */
	public JSONObject unfurl(String channelId, String timeStamp, JSONObject unfurls, boolean userAuth){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("ts", timeStamp);
		para.put("unfurls", unfurls);
		para.put("user_auth_required", userAuth);
		return req.post(SlackMethods.chatUnfurl, para);
	}
	
	/**
	 * <h2>update(timeStamp, channelId, asUser)</h2>
	 * 
	 * <p>This method updates a message in a channel. Though related 
	 * to chat.postMessage, some parameters of chat.update are handled 
	 * differently.</p>
	 * 
	 * https://api.slack.com/methods/chat.update
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>TimeStamp: Timestamp of the message to be deleted.</br>
	 * Channel: Channel containing the message to be deleted.</br>
	 * AsUser: Pass true to delete the message as the authed user. 
	 * Bot users in this context are considered authed users.</p>
	 * 
	 * @param channelId
	 * @param text
	 * @param attachments
	 * @param parse
	 * @param linkNames
	 * @param asUser
	 * 
	 * @return JSONObject 
	 */
	public JSONObject update(String channelId, String text, JSONObject attachments, String parse, boolean linkNames, boolean asUser){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("text", text);
		para.put("attachments", attachments);
		para.put("parse", parse);
		para.put("link_names", linkNames);
		para.put("as_user", asUser);
		return req.post(SlackMethods.chatUpdate, para);
	}
	
}
