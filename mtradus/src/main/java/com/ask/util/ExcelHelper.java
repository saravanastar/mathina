/**
 * 
 */
package com.ask.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * @author ASK
 *
 */
@Service
public class ExcelHelper {
	HSSFWorkbook workBook;
	HSSFSheet sheet;
	
	public HSSFWorkbook writeInExcel(HashMap<String,String> map){
		String header = map.get("Header");
		String data = map.get("data");
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Object>> dataArray = (ArrayList<ArrayList<Object>>)gson.fromJson(data, ArrayList.class);
		try {
			workBook = new HSSFWorkbook(new FileInputStream(new  File("D:\\new.xls")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sheet = workBook.getSheetAt(0);
		HSSFRow row = sheet.createRow(0);
		CellStyle style = createHeaderStyle();

        
		//Create a new cell in current row
		String split[] = header.split(",");
		for (int i = 0; i < split.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(split[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}
		 style = createContentStyle();
		for (int i = 0; i < dataArray.size(); i++) {
			row = sheet.createRow(i+1);
			ArrayList<Object> subArray = dataArray.get(i);
			for (int j = 0; j < subArray.size(); j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellValue(String.valueOf(subArray.get(j)));
				cell.setCellStyle(style);
			}
			
		}
		
		return workBook;
	}

	/**
	 * @return
	 */
	private CellStyle createHeaderStyle() {
		CellStyle style = workBook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIME.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//        style.setFillPattern(CellStyle.ALIGN_FILL); 
        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        
        HSSFFont font = workBook.createFont();
        font.setColor(HSSFColor.WHITE.index);
        font.setBoldweight((short)800);
        style.setFont(font);
		return style;
	}

	/**
	 * @return
	 */
	private CellStyle createContentStyle() {
		CellStyle style = workBook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//        style.setFillPattern(CellStyle.ALIGN_FILL); 
        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        
        HSSFFont font = workBook.createFont();
        font.setColor(HSSFColor.BLACK.index);
//        font.setBoldweight((short)800);
        style.setFont(font);
		return style;
	}

}
