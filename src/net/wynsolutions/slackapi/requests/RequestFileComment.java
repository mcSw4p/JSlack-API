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
public class RequestFileComment {

	private Request req;
	
	public RequestFileComment(Request request) {
		this.req = request;
	}
	
	/**
	 * <h2>add(file, comment)</h2>
	 * 
	 * <p>This method lists the custom emoji for a team.</p>
	 * 
	 * https://api.slack.com/methods/files.comments.add
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: File to add a comment to.</br>
	 * Comment: Text of the comment to add.</p>
	 * 
	 * @param file
	 * @param comment
	 * 
	 * @return JSONObject 
	 */
	public JSONObject add(String file, String comment){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		para.put("comment", comment);
		return req.post(SlackMethods.fileCommentAdd, para);
	}
	
	/**
	 * <h2>delete(file, id)</h2>
	 * 
	 * <p>Delete an existing comment on a file. Only the original 
	 * author of the comment or a Team Administrator may delete a 
	 * file comment.</p>
	 * 
	 * https://api.slack.com/methods/files.comments.delete
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: File to delete a comment from.</br>
	 * Id: The comment to delete.</p>
	 * 
	 * @param file
	 * @param id
	 * 
	 * @return JSONObject 
	 */
	public JSONObject delete(String file, String id){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		para.put("id", id);
		return req.post(SlackMethods.fileCommentDelete, para);
	}
	
	/**
	 * <h2>edit(file, id, comment)</h2>
	 * 
	 * <p>Edit an existing comment on a file. Only the user who 
	 * created a comment may make edits. Teams may configure a 
	 * limited time window during which file comment edits are 
	 * allowed.</p>
	 * 
	 * https://api.slack.com/methods/files.comments.edit
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: File containing the comment to edit.</br>
	 * Id: The comment to edit.</br>
	 * Comment: Text of the comment to edit.</p>
	 * 
	 * @param file
	 * @param id
	 * @param comment
	 * 
	 * @return JSONObject 
	 */
	public JSONObject edit(String file, String id, String comment){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		para.put("id", id);
		para.put("comment", comment);
		return req.post(SlackMethods.fileCommentEdit, para);
	}
	
}
