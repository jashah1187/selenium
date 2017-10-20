/*
public static ObjectMap ObjMap;$Id: BaseTestCase.java 190 2014-01-27 05:39:49Z 812203 $
Copyright 2012 iGATE GROUP OF COMPANIES. All rights reserved
(Subject to Limited Distribution and Restricted Disclosure Only.)
THIS SOURCE FILE MAY CONTAIN INFORMATION WHICH IS THE PROPRIETARY 
 INFORMATION of iGATE GROUP OF COMPANIES AND IS INTENDED FOR USE 
 ONLY BY THE ENTITY WHO IS ENTITLED TO AND MAY CONTAIN 
 INFORMATION THAT IS PRIVILEGED, CONFIDENTIAL, OR EXEMPT FROM         
 DISCLOSURE UNDER APPLICABLE LAW.
YOUR ACCESS TO THIS SOURCE FILE IS GOVERNED BY THE TERMS AND           
 CONDITIONS OF AN AGREEMENT BETWEEN YOU AND IGATE GROUP OF COMPANIES.                  
 The USE, DISCLOSURE REPRODUCTION OR TRANSFER OF THIS PROGRAM IS      
 RESTRICTED AS SET FORTH THEREIN.
*/

package com.app.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.igate.utils.*;

public class ObjectMap {
	private List<Map> rows;
	private String omFilePath;
	private String filePath = omFilePath;

	// ..............................
	// Getting Data form CSV file
	public Map<String, Map> getObjectMap() {
		final Map<String, Map> out = new HashMap<String, Map>();
		// for (Object key : rows.)
		for (Map row : rows) {
			out.put((String) row.get("Name"), row);
		}
		return out;
	}
	// ..............................

	/*public ObjectMap(String omFilePath, String omSheetName) throws Exception {
		if (omFilePath.toLowerCase().contentEquals("same")) {
			omFilePath = filePath;
		}
		rows = ExcelReader.read(omFilePath, omSheetName);
	}*/

	public Map<String, Map> getPageMap(String pageName) {
		final Map<String, Map> out = new HashMap<String, Map>();
		// for (Object key : rows.)

		for (Map row : rows) {
			if (!row.get("PageName").equals(pageName))
				continue;
			out.put((String) row.get("Name"), row);
		}
		return out;
	}

	public List<Map> getWebCtrl() {
		return rows;
	}

	public Map<String, String> getAppInfo(String ctrlName) {
		Map<String, String> out = new HashMap<String, String>();
		final Map<String, Map> appInfoMap = getPageMap("_AppInfo_");
		out = (Map<String, String>) appInfoMap.get(ctrlName);
		return out;
	}
}
