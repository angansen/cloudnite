package com.oracle.cloudnite.model;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static HashMap<String, Object> GetConsumptionData(InputStream inputStream) throws IOException {
		Boolean status = true;
		String message = "";
		HashMap<String, Object> consumptionDataReadStatus = new HashMap<String, Object>(); 
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		String updateDate="";
		
//		DATA SHEET
//		Sheet datatypeSheet = workbook.getSheetAt(1);
		
//		Iterator<Row> iterator = datatypeSheet.iterator();		
		List<Consumption> consumptionList = new ArrayList<>();
		System.out.println("no of sheets : "+workbook.getNumberOfSheets());
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        	String lob = workbook.getSheetName(i);
    		Sheet datatypeSheet = workbook.getSheetAt(i);
    		Iterator<Row> iterator = datatypeSheet.iterator();
    		while (iterator.hasNext()) {
    			Row currentRow = iterator.next();
    			if (currentRow.getRowNum() == 0 || currentRow.getRowNum() == 1 || currentRow.getRowNum() == 2)
    				continue;
    			Iterator<Cell> cellIterator = currentRow.iterator();
    			Consumption curConsumptionObject = new Consumption();
    			curConsumptionObject.setLOB(lob);
    			while (cellIterator.hasNext()) {
    				Cell currentCell = cellIterator.next();
    				// getCellTypeEnum shown as deprecated for version 3.15
    				// getCellTypeEnum ill be renamed to getCellType starting from version 4.0
    				int cellNumber = currentCell.getColumnIndex();
    				String celltype = currentCell.getCellTypeEnum().name();
    				try{
    					if(i==3) {
        					if(cellNumber == 0) {
        						curConsumptionObject.setSVP(currentCell.getStringCellValue());
        					}
        					else if(cellNumber == 1) {
        						curConsumptionObject.setGVP(currentCell.getStringCellValue());
        					}
        					else if(cellNumber == 2) {
      							curConsumptionObject.setAVP(currentCell.getStringCellValue());
        					}
        					else if(cellNumber == 3) {
      							curConsumptionObject.setRM(currentCell.getStringCellValue());
        					}
        					else if(cellNumber == 4) {
        							curConsumptionObject.setTERRITORY_NAME(currentCell.getStringCellValue());
        					} 
        					else if(cellNumber == 5) {
      							curConsumptionObject.setREPS(currentCell.getStringCellValue());
        					} 
        					else if(cellNumber == 6) {
      							curConsumptionObject.setCOMPLETED_CAPTURE((int) currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 7) {
      							curConsumptionObject.setUNPIPED_CAPTURE((int) currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 8) {
      							curConsumptionObject.setOPEN_PIPE((int) currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 9) {
      							curConsumptionObject.setUPSIDE_PIPE((int) currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 10) {
      							curConsumptionObject.setCOMMIT_PIPE((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 11) {
      							curConsumptionObject.setPIPELINE_CONSULTING((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 12) {
      							curConsumptionObject.setWON_DEALS((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 13) {
      							curConsumptionObject.setWON_PARTICIPATION_RATE((int)Math.round(currentCell.getNumericCellValue()*100));
        					} 
        					else if(cellNumber == 14) {
      							curConsumptionObject.setWON_CONSULTING_ATTACH((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 15) {
      							curConsumptionObject.setNEW_CUSTOMERS_WITH_CONSUMPTION((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 16) {
      							curConsumptionObject.setCUSTOMERS_WITH_EXPANSION_UCC((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 17) {
      							curConsumptionObject.setCUSTOMERS_WITH_UCC_RENEWALS((int)currentCell.getNumericCellValue());
        					} 
        					else if(cellNumber == 18) {
      							curConsumptionObject.setHERO((int)currentCell.getNumericCellValue());
        					}         					
    					} 
    					else {
	    					if(cellNumber == 0) {
	    						curConsumptionObject.setSVP(currentCell.getStringCellValue());
	    					}
	    					else if(cellNumber == 1) {
	    						curConsumptionObject.setGVP(currentCell.getStringCellValue());
	    					}
	    					else if(cellNumber == 2) {
	  							curConsumptionObject.setRM(currentCell.getStringCellValue());
	    					}
	    					else if(cellNumber == 3) {
	    							curConsumptionObject.setTERRITORY_NAME(currentCell.getStringCellValue());
	    					} 
	    					else if(cellNumber == 4) {
	  							curConsumptionObject.setREPS(currentCell.getStringCellValue());
	    					} 
	    					else if(cellNumber == 5) {
	  							curConsumptionObject.setCOMPLETED_CAPTURE((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 6) {
	  							curConsumptionObject.setUNPIPED_CAPTURE((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 7) {
	  							curConsumptionObject.setOPEN_PIPE((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 8) {
	  							curConsumptionObject.setUPSIDE_PIPE((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 9) {
	  							curConsumptionObject.setCOMMIT_PIPE((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 10) {
	  							curConsumptionObject.setPIPELINE_CONSULTING((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 11) {
	  							curConsumptionObject.setWON_DEALS((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 12) {
	  							curConsumptionObject.setWON_PARTICIPATION_RATE((int)Math.round(currentCell.getNumericCellValue()*100));
	    					} 
	    					else if(cellNumber == 13) {
	  							curConsumptionObject.setWON_CONSULTING_ATTACH((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 14) {
	  							curConsumptionObject.setNEW_CUSTOMERS_WITH_CONSUMPTION((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 15) {
	  							curConsumptionObject.setCUSTOMERS_WITH_EXPANSION_UCC((int)currentCell.getNumericCellValue());
	    					} 
	    					else if(cellNumber == 16) {
	  							curConsumptionObject.setCUSTOMERS_WITH_UCC_RENEWALS((int)currentCell.getNumericCellValue());
	    					}
        					else if(cellNumber == 17) {
      							curConsumptionObject.setHERO((int)currentCell.getNumericCellValue());
        					}         						    					
    					}
    					
    				}
    				catch(Exception e){
    					message = "Wrong Data in sheet "+(i+1)+" at Row "+(currentRow.getRowNum()+1)+" Cell "+(cellNumber+1) + "----"+e;
    					consumptionDataReadStatus.put("status", false);
    					consumptionDataReadStatus.put("message", message);
    					return consumptionDataReadStatus;
    				}
    			}
    		consumptionList.add(curConsumptionObject);
    		}
        }
		consumptionDataReadStatus.put("consumption", consumptionList);
		consumptionDataReadStatus.put("status", status);    		

		return consumptionDataReadStatus;
	}
}