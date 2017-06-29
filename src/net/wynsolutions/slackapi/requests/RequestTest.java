package net.wynsolutions.slackapi.requests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;

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
public class RequestTest {

	private static Request req;
	
	public RequestTest(Request request) {
		req = request;
	}
	
	/**
	 * <h2>test()</h2>
	 * 
	 * <p>This method helps you test your calling code.</p>
	 * 
	 * https://api.slack.com/methods/api.test
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>None</p>
	 * 
	 * @return JSONObject 
	 */
	public JSONObject test(){
		return req.get(SlackMethods.apiTest);
	}
	
	/**
	 * <h2>test(error)</h2>
	 * 
	 * <p>This method helps you test your calling code.</p>
	 * 
	 * https://api.slack.com/methods/api.test
	 * <h2>URL Parameters: </h2>
	 * 
	 * <p>Error: Error response to return</p>
	 * 
	 * @param error
	 * 
	 * @return JSONObject 
	 */
	public JSONObject test(String error){
		Map<String, Object> para = new LinkedHashMap<>();
		para.put("error", error);
		return req.post(SlackMethods.authTest, para);
	}
	
}
