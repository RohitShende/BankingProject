package com.inb.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
 * Author Navin Maheshwari
 * */

public class AdminUtil {

	public static void populateAdmin() {

		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("init_data/admin.txt"));
			JSONObject jobj = (JSONObject) obj;

			String jsonFile = jobj.toJSONString();
			DBObject dbo = (DBObject) com.mongodb.util.JSON.parse(jsonFile);

			String date = (String) dbo.get("dateOfBirth");
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			dbo.removeField("dateOfBirth");
			dbo.put("dateOfBirth", date1);

			if (new MongoClient().getDB("test").getCollection("admin").find()
					.size() == 0) {
				new MongoClient().getDB("test").getCollection("admin")
						.save(dbo);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

	}

}
