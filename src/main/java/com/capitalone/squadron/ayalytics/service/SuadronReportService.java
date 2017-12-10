package com.capitalone.squadron.ayalytics.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SuadronReportService {

	public Map<Object, Object> prepareReportData(String query)
			throws ClassNotFoundException, SQLException, IOException;

	public String pushFetchedReportToReportTbl(Object key, List<Object> pojoList)
			throws ClassNotFoundException, SQLException, IOException;

	public Map<Object, Object> getReportMetadaInfo(String query)
			throws ClassNotFoundException, SQLException, IOException;
}
