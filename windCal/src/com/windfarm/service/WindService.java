package com.windfarm.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.windfarm.util.DBManager;
import com.windfarm.util.DateUtil;

public class WindService {

	/**
	 * 读取excel中的数据，将数据存放在集合中
	 * 
	 * @param file
	 * @return
	 */
	public static Map<String, List<String>> getAllDataByExcel(String file) {
		Map<String, List<String>> excelDataMap = new HashMap<String, List<String>>();
		try {
			// Workbook rwb = Workbook.getWorkbook(new File(file));
			// Sheet rs = rwb.getSheet(0);
			// int clos = rs.getColumns();// 得到所有的列
			// int rows = rs.getRows();// 得到所有的行

			InputStream in = new FileInputStream(file);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int rows = xssfSheet.getLastRowNum();

			List<String> realPowerList = new ArrayList<String>();
			for (int i = 1; i < rows; i++) {
				XSSFRow xssfRow = xssfSheet.getRow(i);
				if (xssfRow != null) {
					XSSFCell oneCell = xssfRow.getCell(0);
					XSSFCell twoCell = xssfRow.getCell(1);
					XSSFCell threeCell = xssfRow.getCell(2);

					Date date = oneCell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String strRealDate = sdf.format(date);
					String strRealPower = threeCell.getStringCellValue();
					boolean isKey = excelDataMap.containsKey(strRealDate);
					if (isKey) {
						realPowerList.add(strRealPower);
					} else {
						realPowerList = new ArrayList<String>();
						realPowerList.add(strRealPower);
					}
					// 将第二天0点的值存为当天24点的值,如果没有0点值，则存0
					String strRealTime = twoCell.getStringCellValue();
					if ("23:45:00".equals(strRealTime)) {
						if (i < rows) {
							XSSFRow xssfRowNext = xssfSheet.getRow(i + 1);
							realPowerList.add(xssfRowNext.getCell(1).getStringCellValue());
						} else {
							realPowerList.add("0");
						}
					}
					excelDataMap.put(strRealDate, realPowerList);
				}
				// for (int j = 0; j < clos; j++) {
				//
				//
				// DateCell dateCell = (DateCell) rs.getCell(j++, i);
				// Date date = dateCell.getDate();
				// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String strRealDate = sdf.format(date);
				// String strRealTime = rs.getCell(j++, i).getContents();
				// String strRealPower = rs.getCell(j++, i).getContents();
				// boolean isKey = excelDataMap.containsKey(strRealDate);
				// if (isKey) {
				// realPowerList.add(strRealPower);
				// } else {
				// realPowerList = new ArrayList<>();
				// realPowerList.add(strRealPower);
				// }
				// // 将第二天0点的值存为当天24点的值,如果没有0点值，则存0
				// if ("23:45:00".equals(strRealTime)) {
				// if (i < rows) {
				// realPowerList.add(rs.getCell(2, i + 1).getContents());
				// } else {
				// realPowerList.add("0");
				// }
				//
				// }
				// excelDataMap.put(strRealDate, realPowerList);
				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelDataMap;
	}

	/**
	 * 判断表中是否有已存在的数据，如果存在，则删除后插入新数据；不存在，则直接插入新数据
	 * 
	 * @param farmId
	 * @param dataMap
	 * @throws Exception
	 */
	public static void isExistInsertValue(int farmId, Map<String, List<String>> dataMap) throws Exception {

		for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {

			String strRealDate = entry.getKey();
			String querySQL = "select count(*) as count from data_powerfarm_realpower where farmID = ? and ymd = ?";
			Connection conn = DBManager.DBConnection();
			PreparedStatement pst = conn.prepareStatement(querySQL);
			pst.setInt(1, farmId);
			pst.setString(2, strRealDate);
			ResultSet rs = pst.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("count");

			}
			if (count > 0) {
				String delSQL = "delete from data_powerfarm_realpower WHERE farmID = ? and ymd = ?";
				pst = conn.prepareStatement(delSQL);
				pst.setInt(1, farmId);
				pst.setString(2, strRealDate);
				pst.executeUpdate();
			}
		}
	}

	/**
	 * 计算数据准确率，将值保存到集合中
	 * 
	 * @throws ParseException
	 */
	public static Map<String, List<Double>> calculateAveragePower(int farmId) throws ParseException {
		Map<String, List<Double>> realPowerMap = new HashMap<String, List<Double>>();
		Map<String, List<Double>> forecastPowerMap = new HashMap<String, List<Double>>();
		Map<String, List<Double>> averageErrorMap = new HashMap<String, List<Double>>();
		List<Double> realPowerList = null;
		List<Double> forecastPowerList = null;
		Connection conn = DBManager.DBConnection();
		PreparedStatement pst = null;
		String sql = "SELECT * FROM data_powerfarm_realpower WHERE farmID = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, farmId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String strRealDate = rs.getString("ymd");
				realPowerList = new LinkedList<Double>();
				for (int i = 5; i <= 100; i++) {
					realPowerList.add(rs.getDouble(i));
				}
				realPowerMap.put(strRealDate, realPowerList);
			}
			for (Map.Entry<String, List<Double>> entry : realPowerMap.entrySet()) {
				String ymd = entry.getKey();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date beginDate = sdf.parse(ymd);
				Calendar c = Calendar.getInstance();
				c.setTime(beginDate);
				c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
				Date endDate = c.getTime();
				String forecasttime = sdf.format(endDate);
				String foreSQL = "SELECT * FROM fcst_st_result WHERE farmID = ? and  ymd = ? and forecasttime = ?";
				pst = conn.prepareStatement(foreSQL);
				pst.setInt(1, farmId);
				pst.setString(2, ymd);
				pst.setString(3, forecasttime + " 06:00:00");
				ResultSet foreRs = pst.executeQuery();
				while (foreRs.next()) {
					forecastPowerList = new LinkedList<Double>();
					for (int i = 6; i <= 101; i++) {
						forecastPowerList.add(foreRs.getDouble(i));
					}
					forecastPowerMap.put(ymd, forecastPowerList);
				}
			}

			String capSQL = "SELECT instcap FROM base_windfarm_info WHERE farmID = ?";
			pst = conn.prepareStatement(capSQL);
			pst.setInt(1, farmId);
			ResultSet capRs = pst.executeQuery();
			double instcap = 0;// 装机容量
			if (capRs.next()) {
				instcap = capRs.getDouble("instcap");
			}
			for (Map.Entry<String, List<Double>> entry : realPowerMap.entrySet()) {
				List<Double> insertDataList = new ArrayList<Double>();
				double powSum = 0;
				String strRealDate = entry.getKey();
				List<Double> realPowerDataList = entry.getValue();
				if (forecastPowerMap.containsKey(strRealDate)) {
					List<Double> forecastDataList = forecastPowerMap.get(strRealDate);
					for (int i = 0; i < realPowerDataList.size(); i++) {
						double realPowerData = realPowerDataList.get(i);
						double forecastPowerData = forecastDataList.get(i);
						double powData = Math.pow((realPowerData - forecastPowerData), 2);
						powSum += powData;
					}
				}
				double rmse = Math.sqrt(powSum / realPowerDataList.size()) / instcap;
				insertDataList.add(rmse);
				averageErrorMap.put(strRealDate, insertDataList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return averageErrorMap;
	}

	/**
	 * 将计算出的准确率存入表中
	 * 
	 * @param farmID
	 * @throws ParseException
	 */
	public static void calculatedValueInsertTable(int farmID) throws ParseException {
		Map<String, List<Double>> averageErrorMap = calculateAveragePower(farmID);
		if (averageErrorMap != null && averageErrorMap.size() > 0) {
			String sql = "INSERT into stat_st_error(farmid,ymd,forecasttime,RMSE) VALUES(?,?,?,?)";
			Connection conn = DBManager.DBConnection();
			PreparedStatement pst = null;
			try {
				conn.setAutoCommit(false);
				pst = conn.prepareStatement(sql);
				for (Map.Entry<String, List<Double>> entry : averageErrorMap.entrySet()) {
					String strRealDate = entry.getKey();
					List<Double> tPowerList = entry.getValue();
					double data = tPowerList.get(0);
					pst.setInt(1, farmID);
					pst.setString(2, strRealDate);
					pst.setString(3, DateUtil.setDateCutOneDay(strRealDate) + " 06:00:00");
					pst.setDouble(4, data);
					pst.addBatch();
				}
				pst.executeBatch();
				conn.commit();
				System.out.println("数据插入成功！！");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
