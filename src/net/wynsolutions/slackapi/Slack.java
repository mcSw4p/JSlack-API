package net.wynsolutions.slackapi;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import net.wynsolutions.slackapi.log.JSlackFormatter;
import net.wynsolutions.slackapi.methods.SlackMethods;
import net.wynsolutions.slackapi.requests.Request;

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
public class Slack {

	private static Request requests;
	
	public static String SLACK_TOKEN;
	
	public static String VERSION = "v0.0.1";
	private static Logger logger;
	
	/**
	 * <p>The JSlack API is a API for Slack written in Java. 
	 * Use this constructor to initialize the Slack API token 
	 * before you use the JSlack API.</p>
	 * 
	 * @param token Slack API token
	 */
	public Slack(String token) {
		SLACK_TOKEN = token;
		requests = new Request();
		
		logger = Logger.getLogger("Slack");
		logger.setUseParentHandlers(false);
		
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new JSlackFormatter());
		logger.addHandler(handler);
		
	}
	
	/**
	 * <p>The JSlack API is a API for Slack written in Java. 
	 * Use this constructor to initialize the Slack API token 
	 * and set the base URL JSlack uses to make the Slack API 
	 * calls, before you use the JSlack API.</p>
	 * 
	 * @param token Slack API token
	 * @param baseURL Slack API URL
	 */
	@SuppressWarnings("static-access")
	public Slack(String token, String baseURL) {
		Slack s = new Slack(token);
		s.setAPIURL(baseURL);
	}
	
	/**
	 * <h2>requests()</h2>
	 * 
	 * <p>This method returns the Request class. Request.class 
	 * contains classes to make API calls to Slack separated 
	 * by topic.</p>
	 * 
	 * @return Slack API calls
	 */
	public static Request requests(){
		return requests;
	}

	/**
	 * <h2>getLogger()</h2>
	 * 
	 * <p>This method fetches the logger for JSlack API.</p>
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * <h2>setLogger(logger)</h2>
	 * 
	 * <p>This method sets the logger that JSlack API uses.</p>
	 * 
	 * @param logger
	 */
	public static void setLogger(Logger logger) {
		Slack.logger = logger;
	}
	
	/**
	 * <h2>setAPIURL(baseUrl)</h2>
	 * 
	 * <p>This method sets the baseUrl of the Slack API
	 * calls.</p>
	 * 
	 * @param baseUrl
	 */
	public static void setAPIURL(String baseUrl){
		SlackMethods.setBaseURL(baseUrl);
	}
	
}
