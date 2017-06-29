package test;

import java.util.logging.Level;

import net.wynsolutions.slackapi.Slack;

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
public class Main {

	private static boolean error = false;
	
	public static void main(String[] args) {
		new Slack("xoxp-193348182086-192469169731-202575321760-675ec8c906bce32cdabe5adf7d9d42d5");
		
		if(apiTest()){
			Slack.getLogger().log(Level.INFO, "API TEST METHOD - PASS");
		}else{
			Slack.getLogger().log(Level.INFO, "API TEST METHOD - FAIL");
			error = true;
		}
		
		if(apiAuthRevokeTest()){
			Slack.getLogger().log(Level.INFO, "API AUTH REVOKE TEST METHOD - PASS");
		}else{
			Slack.getLogger().log(Level.INFO, "API AUTH REVOKE TEST METHOD - FAIL");
			error = true;
		}
		
		if(apiAuthTest()){
			Slack.getLogger().log(Level.INFO, "API AUTH TEST METHOD - PASS");
		}else{
			Slack.getLogger().log(Level.INFO, "API AUTH TEST METHOD - FAIL");
			error = true;
		}
		
		if(apiBotInfo()){
			Slack.getLogger().log(Level.INFO, "API BOT INFO METHOD - PASS");
		}else{
			Slack.getLogger().log(Level.INFO, "API BOT INFO METHOD - FAIL");
			error = true;
		}
		
		if(!error)
			Slack.getLogger().log(Level.INFO, "Passed all tests!");
		else
			Slack.getLogger().log(Level.INFO, "Did not pass all tests! ");
		
	}
	
	private static boolean apiTest(){
		return (boolean) Slack.requests().tests().test().get("ok");
	}
	
	private static boolean apiAuthRevokeTest(){
		return (boolean) Slack.requests().auth().revoke(true).get("ok");
	}
	
	private static boolean apiAuthTest(){
		return (boolean) Slack.requests().auth().test().get("ok");
	}
	
	private static boolean apiBotInfo(){
		return (boolean) Slack.requests().bots().info("").get("ok");
	}
	
	private static boolean apiChannelCreate(){
		return (boolean) Slack.requests().channels().create("#hello$$$", true).get("ok");
	}
	
	private static boolean apiChannelArchive(){
		return (boolean) Slack.requests().channels().archive("32").get("ok");
	}
	
	private static boolean apiChannelHistory(){
		return (boolean) Slack.requests().channels().create("#hello$$$", true).get("ok");
	}

}
