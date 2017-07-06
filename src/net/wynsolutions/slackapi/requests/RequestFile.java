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
public class RequestFile {

	private Request req;
	
	public RequestFileComment comment;
	
	public RequestFile(Request request) {
		this.req = request;
		this.comment = new RequestFileComment(request);
	}
	
	/**
	 * <h2>comments()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for creating/uploading comments.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#files.comments</p>
	 * 
	 * @return
	 */
	public RequestFileComment comments(){
		return this.comment;
	}
	
	/**
	 * <h2>delete(file)</h2>
	 * 
	 * <p>This method deletes a file from your team.</p>
	 * 
	 * https://api.slack.com/methods/files.delete
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: ID of file to delete.</p>
	 * 
	 * @param file
	 * 
	 * @return JSONObject 
	 */
	public JSONObject delete(String file){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		return req.post(SlackMethods.filesDelete, para);
	}
	
	/**
	 * <h2>info(file, count, page)</h2>
	 * 
	 * <p>This method returns information about a file 
	 * in your team.</p>
	 * 
	 * https://api.slack.com/methods/files.info
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: Specify a file by providing its ID.</br>
	 * Count: Number of items to return per page.</br>
	 * Page: Page number of results to return.</p>
	 * 
	 * @param file
	 * @param count
	 * @param page
	 * 
	 * @return JSONObject 
	 */
	public JSONObject info(String file, int count, int page){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		if(count != 0)
			para.put("count", count);
		if(page != 0)
			para.put("page", page);
		return req.post(SlackMethods.filesInfo, para);
	}
	
	/**
	 * <h2>list(channelId, count, page, timeStampFrom, timeStampTo, types, user)</h2>
	 * 
	 * <p>This method deletes a file from your team.</p>
	 * 
	 * https://api.slack.com/methods/files.list
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channel: Filter files appearing in a specific channel, 
	 * indicated by its ID.</br>
	 * Count: Number of items to return per page.</br>
	 * Page: Page number of results to return.</br>
	 * Timestamp From: Filter files created after this timestamp 
	 * (inclusive).</br>
	 * Timestamp To: Filter files created before this timestamp 
	 * (inclusive).</br>
	 * Types: Filter files by type:
	 * <p><ul>
	 *   <li>all - All files</li>
	 *   <li>spaces - Posts</li>
	 *   <li>snippets - Snippets</li>
     *   <li>images - Image files</li>
     *   <li>gdocs - Google docs</li>
     *   <li>zips - Zip files</li>
     *   <li>pdfs - PDF files</li>
	 * </ul>
     *   You can pass multiple values in the types argument, like 
     *   types=spaces,snippets.The default value is all, which does 
     *   not filter the list.</p></br>
     * User: Filter files created by a single user.</p>
	 * 
	 * @param channelId
	 * @param count
	 * @param page
	 * @param timeStampFrom
	 * @param timeStampTo
	 * @param types
	 * @param user
	 * 
	 * @return JSONObject 
	 */
	public JSONObject list(String channelId, int count, int page, long timeStampFrom, long timeStampTo, String types, String user){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("channel", channelId);
		para.put("count", count);
		para.put("page", page);
		para.put("ts_from", timeStampFrom);
		para.put("ts_to", timeStampTo);
		para.put("type", types);
		para.put("user", user);
		return req.post(SlackMethods.filesList, para);
	}
	
	/**
	 * <h2>revokePublicURL(file)</h2>
	 * 
	 * <p>This method disables public/external sharing for a file.</p>
	 * 
	 * https://api.slack.com/methods/files.revokePublicURL
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: File to revoke</p>
	 * 
	 * @param file
	 * 
	 * @return JSONObject 
	 */
	public JSONObject revokePublicURL(String file){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		return req.post(SlackMethods.filesRevokePublicURL, para);
	}
	
	/**
	 * <h2>sharedPublicURL(file)</h2>
	 * 
	 * <p>This method enables public/external sharing for a file.</p>
	 * 
	 * https://api.slack.com/methods/files.sharedPublicURL
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>File: File to share</p>
	 * 
	 * @param file
	 * 
	 * @return JSONObject 
	 */
	public JSONObject sharedPublicURL(String file){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		return req.post(SlackMethods.filesDelete, para);
	}
	
	/**
	 * <h2>upload(channels, content, file, filename, filetype, 
	 * initialContent, title)</h2>
	 * 
	 * <p>This method allows you to create or upload an existing 
	 * file.</p>
	 * 
	 * https://api.slack.com/methods/files.upload
	 * 
	 * <h3>You must provide either a file or content parameter.</h3>
	 * <p>The content of the file can either be posted using an 
	 * enctype of multipart/form-data (with the file parameter 
	 * named file), in the usual way that files are uploaded via 
	 * the browser, or the content of the file can be sent as a POST 
	 * var called content. The latter should be used for creating a 
	 * "file" from a long message/paste and forces "editable" mode.</p>
	 * <p>In both cases, the type of data in the file will be intuited 
	 * from the filename and the magic bytes in the file, for 
	 * supported formats.</p>
	 * <p>Sending a valid filetype parameter will override this behavior. 
	 * Possible filetype values can be found in the file object definition.</p>
	 * <p>Files uploaded via multipart/form-data will be stored either in 
	 * hosted or editable mode, based on certain heuristics (determined 
	 * type, file size).</p>
	 * <p>The file can also be shared directly into channels on upload, 
	 * by specifying an optional argument channels. If there's more than 
	 * one channel name or ID in the channels string, they should be 
	 * comma-separated.</p>
	 * <p>There is a 1 megabyte file size limit for files uploaded as 
	 * snippets.</p>
	 * 
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Channels: Comma-separated list of channel names or IDs 
	 * where the file will be shared.</br>
	 * Content: File contents via a POST variable. If omitting 
	 * this parameter, you must provide a file.</br>
	 * File: File contents via multipart/form-data. If omitting 
	 * this parameter, you must submit content.</br>
	 * Filename: Filename of file.</br>
	 * Filetype: A file type identifier.</br>
	 * InitialComment: Initial comment to add to file.</br>
	 * Title: Title of file.</p>
	 * 
	 * @param file
	 * 
	 * @return JSONObject 
	 */
	public JSONObject upload(String channels, String content, String file, String filename, String filetype, String initialComment, String title){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("token", Slack.SLACK_TOKEN);
		para.put("file", file);
		return req.post(SlackMethods.filesDelete, para);
	}
	
}
