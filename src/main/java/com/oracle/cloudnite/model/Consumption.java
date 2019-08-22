package com.oracle.cloudnite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLOUD_NITE_SCORECARD")
public class Consumption {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int ID;
	private String SVP;
	private String GVP;
	private String RM;
	private String TERRITORY_NAME;
	private String REPS;	
	private String AVP;
	private String LOB;
	
	private int COMPLETED_CAPTURE;
	private int OPEN_PIPE;
	private int UPSIDE_PIPE;
	private int COMMIT_PIPE;
	private int WON_DEALS;
	private int PIPELINE_CONSULTING;
	private int WON_PARTICIPATION_RATE;
	private int WON_CONSULTING_ATTACH;
	private int NEW_CUSTOMERS_WITH_CONSUMPTION;
	private int CUSTOMERS_WITH_EXPANSION_UCC;
	private int CUSTOMERS_WITH_UCC_RENEWALS;
	private int UNPIPED_CAPTURE;
	private int HERO;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSVP() {
		return SVP;
	}
	public void setSVP(String sVP) {
		SVP = sVP;
	}
	public String getGVP() {
		return GVP;
	}
	public void setGVP(String gVP) {
		GVP = gVP;
	}
	public String getRM() {
		return RM;
	}
	public void setRM(String rM) {
		RM = rM;
	}
	public String getTERRITORY_NAME() {
		return TERRITORY_NAME;
	}
	public void setTERRITORY_NAME(String tERRITORY_NAME) {
		TERRITORY_NAME = tERRITORY_NAME;
	}
	public String getREPS() {
		return REPS;
	}
	public void setREPS(String rEPS) {
		REPS = rEPS;
	}
	public String getLOB() {
		return LOB;
	}
	public void setLOB(String lOB) {
		LOB = lOB;
	}	
	public int getCOMPLETED_CAPTURE() {
		return COMPLETED_CAPTURE;
	}
	public void setCOMPLETED_CAPTURE(int d) {
		COMPLETED_CAPTURE = d;
	}
	public int getOPEN_PIPE() {
		return OPEN_PIPE;
	}
	public void setOPEN_PIPE(int oPEN_PIPE) {
		OPEN_PIPE = oPEN_PIPE;
	}
	public int getUPSIDE_PIPE() {
		return UPSIDE_PIPE;
	}
	public void setUPSIDE_PIPE(int uPSIDE_PIPE) {
		UPSIDE_PIPE = uPSIDE_PIPE;
	}
	public int getCOMMIT_PIPE() {
		return COMMIT_PIPE;
	}
	public void setCOMMIT_PIPE(int cOMMIT_PIPE) {
		COMMIT_PIPE = cOMMIT_PIPE;
	}
	public int getWON_DEALS() {
		return WON_DEALS;
	}
	public void setWON_DEALS(int wON_DEALS) {
		WON_DEALS = wON_DEALS;
	}
	public int getPIPELINE_CONSULTING() {
		return PIPELINE_CONSULTING;
	}
	public void setPIPELINE_CONSULTING(int pIPELINE_CONSULTING) {
		PIPELINE_CONSULTING = pIPELINE_CONSULTING;
	}
	public int getWON_PARTICIPATION_RATE() {
		return WON_PARTICIPATION_RATE;
	}
	public void setWON_PARTICIPATION_RATE(int d) {
		WON_PARTICIPATION_RATE = d;
	}
	public int getWON_CONSULTING_ATTACH() {
		return WON_CONSULTING_ATTACH;
	}
	public void setWON_CONSULTING_ATTACH(int wON_CONSULTING_ATTACH) {
		WON_CONSULTING_ATTACH = wON_CONSULTING_ATTACH;
	}
	public int getNEW_CUSTOMERS_WITH_CONSUMPTION() {
		return NEW_CUSTOMERS_WITH_CONSUMPTION;
	}
	public void setNEW_CUSTOMERS_WITH_CONSUMPTION(int nEW_CUSTOMERS_WITH_CONSUMPTION) {
		NEW_CUSTOMERS_WITH_CONSUMPTION = nEW_CUSTOMERS_WITH_CONSUMPTION;
	}
	public int getCUSTOMERS_WITH_EXPANSION_UCC() {
		return CUSTOMERS_WITH_EXPANSION_UCC;
	}
	public void setCUSTOMERS_WITH_EXPANSION_UCC(int cUSTOMERS_WITH_EXPANSION_UCC) {
		CUSTOMERS_WITH_EXPANSION_UCC = cUSTOMERS_WITH_EXPANSION_UCC;
	}
	public int getCUSTOMERS_WITH_UCC_RENEWALS() {
		return CUSTOMERS_WITH_UCC_RENEWALS;
	}
	public void setCUSTOMERS_WITH_UCC_RENEWALS(int cUSTOMERS_WITH_UCC_RENEWALS) {
		CUSTOMERS_WITH_UCC_RENEWALS = cUSTOMERS_WITH_UCC_RENEWALS;
	}
	public int getUNPIPED_CAPTURE() {
		return UNPIPED_CAPTURE;
	}
	public void setUNPIPED_CAPTURE(int uNPIPED_CAPTURE) {
		UNPIPED_CAPTURE = uNPIPED_CAPTURE;
	}
	public String getAVP() {
		return AVP;
	}
	public void setAVP(String aVP) {
		AVP = aVP;
	}	
	public int getHERO() {
		return HERO;
	}
	public void setHERO(int hERO) {
		HERO = hERO;
	}
	
}