package net.wynsolutions.slackapi.requests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.wynsolutions.slackapi.Slack;

/**
 * Copyright (C) 2017 Sw4p
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Sw4p
 *
 */
public class Request {

	// Request topic class variables
	private RequestTest tests;
	private RequestAuth auth;
	private RequestBot bot;
	private RequestChannel channel;
	private RequestChat chat;
	private RequestDnd dnd;
	private RequestEmoji emoji;
	private RequestFile file;
	private RequestGroup group;
	private RequestIm im;
	private RequestMpim mpim;
	private RequestOAuth oauth;
	
	public Request() {
		// Init request topic class variables
		this.tests = new RequestTest(this);
		this.auth = new RequestAuth(this);
		this.bot = new RequestBot(this);
		this.channel = new RequestChannel(this);
		this.chat = new RequestChat(this);
		this.dnd = new RequestDnd(this);
		this.emoji = new RequestEmoji(this);
		this.file = new RequestFile(this);
		this.group = new RequestGroup(this);
		this.im = new RequestIm(this);
		this.mpim = new RequestMpim(this);
		this.oauth = new RequestOAuth(this);
	}
	
	/**
	 * <h2>tests()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for testing Slack API.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#api</p>
	 * 
	 * @return
	 */
	public RequestTest tests(){
		return this.tests;
	}
	
	/**
	 * <h2>auth()</h2>
	 * 
	 * <p>This method returns a class containing API calls
	 * for API authorization.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#auth</p>
	 * 
	 * @return
	 */
	public RequestAuth auth(){
		return this.auth;
	}
	
	/**
	 * <h2>bots()</h2>
	 * 
	 * <p>This method returns a class containing API calls
	 * for getting info on a bot user.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#bots</p>
	 * 
	 * @return
	 */
	public RequestBot bots(){
		return this.bot;
	}
	
	/**
	 * <h2>channels()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for getting info on your team's Slack channels, creating 
	 * or archiving channels, inviting users, setting the topic 
	 * and purpose, and marking a channel as read.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#channels</p>
	 * 
	 * @return
	 */
	public RequestChannel channels(){
		return this.channel;
	}
	
	/**
	 * <h2>chat()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for posting chat messages to Slack.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#chat</p>
	 * 
	 * @return
	 */
	public RequestChat chat(){
		return this.chat;
	}
	
	/**
	 * <h2>dnd()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for fetching to Do Not Disturb settings of users.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#dnd</p>
	 * 
	 * @return
	 */
	public RequestDnd dnd(){
		return this.dnd;
	}
	
	/**
	 * <h2>emoji()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for fetching emojis.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#emoji</p>
	 * 
	 * @return
	 */
	public RequestEmoji emoji(){
		return this.emoji;
	}
	
	/**
	 * <h2>files()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for getting/creating/uploading files and comments.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#files</br>
	 * https://api.slack.com/methods#files.comments</p>
	 * 
	 * @return
	 */
	public RequestFile files(){
		return this.file;
	}
	
	/**
	 * <h2>group()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for getting info on your teams private channels.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#groups</p>
	 * 
	 * @return
	 */
	public RequestGroup groups(){
		return this.group;
	}
	
	/**
	 * <h2>im()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for getting info on your direct messages.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#im</p>
	 * 
	 * @return
	 */
	public RequestIm im(){
		return this.im;
	}
	
	/**
	 * <h2>mpim()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for getting info on your multiparty direct messages.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#mpim</p>
	 * 
	 * @return
	 */
	public RequestMpim mpim(){
		return this.mpim;
	}
	
	/**
	 * <h2>oauth()</h2>
	 * 
	 * <p>This method returns a class containing API calls 
	 * for exchanging temporary oauth tokens.</p>
	 * </br>
	 * 
	 * <p>https://api.slack.com/methods#oauth</p>
	 * 
	 * @return
	 */
	public RequestOAuth oauth(){
		return this.oauth;
	}
	
	/**
	 * <h2>get(targetURL)</h2>
	 * 
	 * <p>This method sends a GET request to the specified URL.</p>
	 * 
	 * @param targetURL
	 * 
	 * @return JSONObject
	 */
	public JSONObject get(String targetURL) {
		return request(targetURL, null, "GET");
	}
	
	/**
	 * <h2>post(targetURL, urlParameters)</h2>
	 * 
	 * <p>This method sends a POST request to the specified URL with 
	 * the specified parameters.</p>
	 * 
	 * @param targetURL
	 * @param urlParameters
	 * 
	 * @return JSONObject
	 */
	public JSONObject post(String targetURL, Map<String, Object> urlParameters) {
		return request(targetURL, urlParameters, "POST");
	}
	
	/**
	 * <h2>request(targetURL, urlParameters, method)</h2>
	 * 
	 * <p>This method sends a request to the specified URL with 
	 * the specified parameters and method.</p>
	 * 
	 * @param targetURL
	 * @param urlParameters
	 * @param request
	 * 
	 * @return JSONObject
	 */
	public JSONObject request(String targetURL, Map<String, Object> urlParameters, String method){
		HttpURLConnection connection = null;
		JSONParser parser = new JSONParser();
		
		try {
			connection = (HttpURLConnection) new URL(targetURL).openConnection();
			
			connection.setRequestMethod(method);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if(urlParameters != null)
				connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.toString().getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			if(urlParameters != null) {
				StringBuilder postData = new StringBuilder();
				for (Map.Entry<String, Object> param : urlParameters.entrySet()) {
					if (postData.length() != 0)
						postData.append('&');
					postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
					postData.append('=');
					postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
				}

				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.write(postData.toString().getBytes("UTF-8"));
				wr.close();
				Slack.getLogger().log(Level.INFO, "Fetching data from \'" + connection.getURL().toString() + "?" + postData.toString()+ "\'");
			}else{
				Slack.getLogger().log(Level.INFO, "Fetching data from \'" + connection.getURL().toString() + "\'");
			}
			
			
			
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuffer response = new StringBuffer();
			String line;
			while((line = rd.readLine()) != null){
				response.append(line);
				response.append('\r');
			}
			
			rd.close();
			return (JSONObject) parser.parse(response.toString());

		} catch (Exception e) {
			Slack.getLogger().log(Level.WARNING, "Error fetching data from \"" + targetURL + "\"\n" + e.getStackTrace().toString());
			return null;
		} finally {
			if(connection != null)
				connection.disconnect();
			Slack.getLogger().log(Level.INFO, "Closed connection...");
		}
	}

}
