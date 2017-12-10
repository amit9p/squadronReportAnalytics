package com.capitalone.squadron.ayalytics.schedular;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;

import com.capitalone.squadron.ayalytics.constants.GetObjects;
import com.capitalone.squadron.ayalytics.constants.SQLConstants;
import com.capitalone.squadron.ayalytics.constants.SchedularConstants;

public class DemonTaskDriver extends TimerTask {

	public static Map<Object, Object> initialMetadataMapReport1;
	public Map<Object, Object> updatedMetadataMapReport1;

	/*
	 * public static void main(String[] args) { try {
	 * 
	 * initialMetadataMapReport1 = GetObjects.suadronReportService
	 * .getReportMetadaInfo(SQLConstants.select_report_metadata);
	 * 
	 * for (Entry<Object, Object> entry : initialMetadataMapReport1 .entrySet())
	 * {
	 * 
	 * Object task = (Object) Class.forName(
	 * GetObjects.miscUtil.getProperties(String.valueOf(entry
	 * .getKey()))).newInstance(); GetObjects.timer.schedule((TimerTask) task,
	 * 100, (Integer) entry.getValue()); } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			if (!SchedularConstants.schedularack.equals("STARTED")) {
				/* Initialize initial metadata map */
				initialMetadataMapReport1 = GetObjects.suadronReportService
						.getReportMetadaInfo(SQLConstants.select_report_metadata);
			}

			else {
				/* Initialize periodic updated metadata map */
				updatedMetadataMapReport1 = GetObjects.suadronReportService
						.prepareReportData(SQLConstants.select_report_metadata);
			}

			if (SchedularConstants.schedularack.equals("STARTED")) {

				/*
				 * compare initial map and periodic map for any change in
				 * frequency
				 */
				/*
				 * if change in frequency found then cancel the running task and
				 * re launch with new frequency* else do nothing
				 */

			} else {

				/* change the schedularack to STARTED */
				SchedularConstants.schedularack = "STARTED";
				/* launch report tasks with specified frequency */
				for (Entry<Object, Object> entry : initialMetadataMapReport1
						.entrySet()) {

					Object task = (Object) Class.forName(
							GetObjects.miscUtil.getProperties(String
									.valueOf(entry.getKey()))).newInstance();
					GetObjects.timer.schedule((TimerTask) task, 100,
							(Integer) entry.getValue());
				}
			}

		}

		catch (Exception e) {
			System.out.println(e.getCause());
		}

	}

}
