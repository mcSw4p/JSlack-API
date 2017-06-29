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

	private RequestTest tests;
	private RequestAuth auth;
	private RequestBot bot;
	private RequestChannel channel;
	private RequestChat chat;
	
	public Request() {
		this.tests = new RequestTest(this);
		this.auth = new RequestAuth(this);
		this.bot = new RequestBot(this);
		this.channel = new RequestChannel(this);
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
	 * <h2>executeGet(targetURL)</h2>
	 * 
	 * <p>This method sends a GET request to the specified URL.</p>
	 * 
	 * @param targetURL
	 * 
	 * @return JSONObject
	 */
	public JSONObject get(String targetURL) {
		HttpURLConnection connection = null;
		JSONParser parser = new JSONParser();
		Slack.getLogger().log(Level.INFO, "Fetching data from \"" + targetURL + "\".");
		
		try {
			connection = (HttpURLConnection) new URL(targetURL).openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuffer response = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
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
	
	/**
	 * <h2>executePost(targetURL, urlParameters)</h2>
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
		HttpURLConnection connection = null;
		JSONParser parser = new JSONParser();
		Slack.getLogger().log(Level.INFO, "Fetching data from \"" + targetURL + "\".");
		
		try {
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.toString().getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			StringBuilder postData = new StringBuilder();
	        for (Map.Entry<String,Object> param : urlParameters.entrySet()) {
	            if (postData.length() != 0) postData.append('&');
	            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	            postData.append('=');
	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	        }
			
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.write(postData.toString().getBytes("UTF-8"));
			wr.close();

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
