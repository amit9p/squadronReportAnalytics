package com.capitalone.squadron.ayalytics.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import com.capitalone.squadron.ayalytics.constants.GetObjects;
import com.capitalone.squadron.ayalytics.constants.SQLConstants;
import com.capitalone.squadron.ayalytics.schedular.DemonTaskDriver;
import com.capitalone.squadron.ayalytics.schedular.Report1Task;
import com.capitalone.squadron.ayalytics.service.SuadronReportService;
import com.capitalone.squadron.ayalytics.service.SuadronReportServiceImpl;

public class App {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		// TODO Auto-generated method stub
	/*
		Map<Object, Object> segregatedTypes = GetObjects.suadronReportService
				.prepareReportData(SQLConstants.select_statement);

		for (Entry<Object, Object> entry : segregatedTypes.entrySet()) {

			GetObjects.suadronReportService.pushFetchedReportToReportTbl(entry.getKey(),
					(List<Object>) entry.getValue());
		}
*/
	
	
	
	/*
	Map<Object, Object> segregatedTypes = GetObjects.suadronReportService
			.getReportMetadaInfo(SQLConstants.select_report_metadata);

	for (Entry<Object, Object> entry : segregatedTypes.entrySet()) {

		
		System.out.println(entry.getKey()+"----"+entry.getValue());
		
	}
*/
	
		TimerTask task = new DemonTaskDriver();

    	Timer timer = new Timer();
    	timer.schedule(task, 1000,60000);
		
	}

}
