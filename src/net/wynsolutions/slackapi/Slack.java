package net.wynsolutions.slackapi;

import java.util.logging.Logger;

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
	private static Logger logger = Logger.getLogger("Slack");
	
	public Slack(String token) {
		
		SLACK_TOKEN = token;
		
		requests = new Request();
	}
	
	public static Request requests(){
		return requests;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		Slack.logger = logger;
	}
	
}