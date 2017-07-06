package net.wynsolutions.slackapi.methods;

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
public class SlackMethods {
	
	/*
	 * This class hold the Slack API method URLS 
	 */
	
	// API Address
	private static String slackAddress = "https://slack.com/api/";
	
	// Test
	public static String apiTest = slackAddress + "api.test";
	
	// Auth
	public static String authRevoke = slackAddress + "auth.revoke",
			authTest = slackAddress + "auth.test";
	
	// Bots
	public static String botsInfo = slackAddress + "bots.info";
	
	// Channels
	public static String channelArchive = slackAddress + "channels.archive",
			channelCreate = slackAddress + "channels.create",
			channelHistory = slackAddress + "channels.history",
			channelInfo = slackAddress + "channels.info",
			channelInvite = slackAddress + "channels.invite",
			channelJoin = slackAddress + "channels.join",
			channelKick = slackAddress + "channels.kick",
			channelLeave = slackAddress + "channels.leave",
			channelList = slackAddress + "channels.list",
			channelMark = slackAddress + "channels.mark",
			channelRename = slackAddress + "channels.rename",
			channelReplies = slackAddress + "channels.replies",
			channelSetPurpose = slackAddress + "channels.setPurpose",
			channelSetTopic = slackAddress + "channels.setTopic",
			channelUnarchive = slackAddress + "channels.unarchive";
	
	// Chat
	public static String chatDelete = slackAddress + "chat.delete",
			chatMeMessage = slackAddress + "chat.meMessage",
			chatPostMessage = slackAddress + "chat.postMessage",
			chatUnfurl = slackAddress + "chat.unfurl",
			chatUpdate = slackAddress + "chat.update";
	
	// Do Not Disturb
	public static String dndEndDnd = slackAddress + "dnd.endDnd",
			dndEndSnooze = slackAddress + "dnd.endSnooze",
			dndInfo = slackAddress + "dnd.info",
			dndSetSnooze = slackAddress + "dnd.setSnooze",
			dndTeamInfo = slackAddress + "dnd.teamInfo";
	
	// Emoji
	public static String emojiList = slackAddress + "emoji.list";
	
	// File Comments
	public static String fileCommentAdd = slackAddress + "files.comments.add",
			fileCommentDelete = slackAddress + "files.comments.delete",
			fileCommentEdit = slackAddress + "files.comments.edit";
	
	// Files
	public static String filesDelete = slackAddress + "files.delete",
			filesInfo = slackAddress + "files.info",
			filesList = slackAddress + "files.list",
			filesRevokePublicURL = slackAddress + "files.revokePublicURL",
			filesSharedPublicURL = slackAddress + "files.sharedPublicURL",
			filesUpload = slackAddress + "files.upload";
	
	// Channels
	public static String groupsArchive = slackAddress + "groups.archive",
			groupsClose = slackAddress + "groups.close",
			groupsCreate = slackAddress + "groups.create",
			groupsCreateChild = slackAddress + "groups.createChild",
			groupsHistory = slackAddress + "groups.history",
			groupsInfo = slackAddress + "groups.info",
			groupsInvite = slackAddress + "groups.invite",
			groupsKick = slackAddress + "groups.kick",
			groupsLeave = slackAddress + "groups.leave",
			groupsList = slackAddress + "groups.list",
			groupsMark = slackAddress + "groups.mark",
			groupsOpen = slackAddress + "groups.open",
			groupsRename = slackAddress + "groups.rename",
			groupsReplies = slackAddress + "groups.replies",
			groupsSetPurpose = slackAddress + "groups.setPurpose",
			groupsSetTopic = slackAddress + "groups.setTopic",
			groupsUnarchive = slackAddress + "groups.unarchive";
	
	// Instant Message (Direct Messages)
	public static String imClose = slackAddress + "im.close",
			imHistory = slackAddress + "im.history",
			imList = slackAddress + "im.list",
			imMark = slackAddress + "im.mark",
			imOpen = slackAddress + "im.open",
			imReplies = slackAddress + "im.replies";
			
	// Multiparty Direct Messages
	public static String mpimClose = slackAddress + "mpim.close",
			mpimHistory = slackAddress + "mpim.history",
			mpimList = slackAddress + "mpim.list",
			mpimMark = slackAddress + "mpim.mark",
			mpimOpen = slackAddress + "mpim.open",
			mpimReplies = slackAddress + "mpim.replies";
	
	// OAuth
	public static String oauthAccess = slackAddress + "oauth.access";
	
	// Pins
	public static String pinsAdd = slackAddress + "pins.add",
			pinsList = slackAddress + "pins.list",
			pinsRemove = slackAddress + "pins.remove";
	
	// Reactions
	public static String reactionsAdd = slackAddress + "reactions.add",
			reactionsGet = slackAddress + "reactions.get",
			reactionsList = slackAddress + "reactions.list",
			reactionsRemove = slackAddress + "reactions.remove";
	
	// Reminders
	public static String remindersAdd = slackAddress + "reminders.add",
			remindersComplete = slackAddress + "reminders.complete",
			remindersDelete = slackAddress + "reminders.delete",
			remindersInfo = slackAddress + "reminders.info",
			remindersList = slackAddress + "reminders.list";
	
	// Real Time Messaging
	public static String rtmConnect = slackAddress + "rtm.connect",
			rtmStart = slackAddress + "rtm.start";
	
	// Search
	public static String searchAll = slackAddress + "search.all",
			searchFiles = slackAddress + "search.files",
			searchMessages = slackAddress + "search.messages";
	
	// Stars
	public static String starsAdd = slackAddress + "stars.add",
			starsList = slackAddress + "stars.list",
			starsRemove = slackAddress + "stars.remove";
	
	// Team
	public static String teamAccessLogs = slackAddress + "team.accessLogs",
			teamBillableInfo = slackAddress + "team.billableInfo",
			teamInfo = slackAddress = slackAddress + "team.info",
			teamIntegrationLogs = slackAddress + "team.integrationLogs";
	
	// Team Profile
	public static String teamProfileGet = slackAddress + "team.profile.get";
	
	// User Groups
	public static String usergroupsCreate = slackAddress + "usergroups.create",
			usergroupsDisable = slackAddress + "usergroups.disable",
			usergroupsEnable = slackAddress + "usergroups.enable",
			usergroupsList = slackAddress + "usergroups.list",
			usergroupsUpdate = slackAddress + "usergroups.update";
	
	// User Groups Users
	public static String usergroupsUsersList = slackAddress + "usergroups.users.list",
			usergroupsUsersUpdate = slackAddress + "usergroups.users.update";
	
	// Users
	public static String usersDeletePhoto = slackAddress + "users.deletePhoto",
			usersGetPresence = slackAddress + "users.getPresence",
			usersIdentity = slackAddress + "users.identity",
			usersInfo = slackAddress + "users.info",
			usersList = slackAddress + "users.list",
			usersSetActive = slackAddress + "users.setActive",
			usersSetPhoto = slackAddress + "users.setPhoto",
			usersSetPresence = slackAddress + "users.setPresence";
	
	// Users Profile
	public static String usersProfileGet = slackAddress + "users.profile.get",
			usersProfileSet = slackAddress + "users.profile.set";
	
	public static void setBaseURL(String url){
		slackAddress = url;
	}
	
}
