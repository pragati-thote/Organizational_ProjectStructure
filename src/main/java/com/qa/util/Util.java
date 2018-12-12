package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	

	public static long PAGE_LOAD_TIME=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="/home/bynry01/Documents/Own/My_Projects/Organisational_Level/src/main/java/com/qa/testdata/LoginTest_Data.xlsx";

	private static XSSFSheet ExcelWSheet;
	//private static XSSFWorkbook ExcelWBook;
	private static Workbook wb;
	private static Sheet sh;
	private static XSSFCell Cell;
}

	