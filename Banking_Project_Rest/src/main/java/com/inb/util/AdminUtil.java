package com.inb.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.inb.mongo.collections.Admin;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/*
 * Author Navin Maheshwari
 * */

public class AdminUtil {

	public static void populateAdmin() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser
					.parse(new FileReader(
							"C:/Users/maheshwari_m/git/BankingProject/Banking_Project_Rest/target/admin.txt"));
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

	public static boolean isAdmin(String id) {
		try {
			DBCursor cursor = new MongoClient().getDB("test")
					.getCollection("admin").find();
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				if (dbObject.get("_id").equals(id)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
}
