package com.ui.pojo;

public class AddressPojo {

	
	private  String COMPANY_TEXT_BOX;
	private  String ADDRESS1_TEXT_BOX;
	private  String ADDRESS2_TEXT_BOX;
	private  String CITY_TEXT_BOX;
	private  String POSTCODE_TEXT_BOX;
	private  String HOMEPHONE_TEXT_BOX;
	private  String MOBILENO_TEXT_BOX;
	private  String ADDRESS_ALIAS_TEXT_BOX;
//	private  String ADDITIONAL_INFO_TEXT_BOX;
	private  String STATE_DRIPDOWN;
	
	/**
	 * @param cOMPANY_TEXT_BOX
	 * @param aDDRESS1_TEXT_BOX
	 * @param aDDRESS2_TEXT_BOX
	 * @param cITY_TEXT_BOX
	 * @param pOSTCODE_TEXT_BOX
	 * @param hOMEPHONE_TEXT_BOX
	 * @param mOBILENO_TEXT_BOX
	 * @param aDDRESS_ALIAS_TEXT_BOX
	 * @param ADDITIONAL_INFO_TEXT_BOX
	 * @param sTATE_DRIPDOWN
	 */
	public AddressPojo(String cOMPANY_TEXT_BOX, String aDDRESS1_TEXT_BOX, String aDDRESS2_TEXT_BOX,
			String cITY_TEXT_BOX, String pOSTCODE_TEXT_BOX, String hOMEPHONE_TEXT_BOX, String mOBILENO_TEXT_BOX,
			String aDDRESS_ALIAS_TEXT_BOX,  String sTATE_DRIPDOWN) {
		super();
		COMPANY_TEXT_BOX = cOMPANY_TEXT_BOX;
		ADDRESS1_TEXT_BOX = aDDRESS1_TEXT_BOX;
		ADDRESS2_TEXT_BOX = aDDRESS2_TEXT_BOX;
		CITY_TEXT_BOX = cITY_TEXT_BOX;
		POSTCODE_TEXT_BOX = pOSTCODE_TEXT_BOX;
		HOMEPHONE_TEXT_BOX = hOMEPHONE_TEXT_BOX;
		MOBILENO_TEXT_BOX = mOBILENO_TEXT_BOX;
		ADDRESS_ALIAS_TEXT_BOX = aDDRESS_ALIAS_TEXT_BOX;
	//	ADDITIONAL_INFO_TEXT_BOX = ADDITIONAL_INFO_TEXT_BOX;
		STATE_DRIPDOWN = sTATE_DRIPDOWN;
	}

	public String getCOMPANY_TEXT_BOX() {
		return COMPANY_TEXT_BOX;
	}

	public String getADDRESS1_TEXT_BOX() {
		return ADDRESS1_TEXT_BOX;
	}

	public String getADDRESS2_TEXT_BOX() {
		return ADDRESS2_TEXT_BOX;
	}

	public String getCITY_TEXT_BOX() {
		return CITY_TEXT_BOX;
	}

	public String getPOSTCODE_TEXT_BOX() {
		return POSTCODE_TEXT_BOX;
	}

	public String getHOMEPHONE_TEXT_BOX() {
		return HOMEPHONE_TEXT_BOX;
	}

	public String getMOBILENO_TEXT_BOX() {
		return MOBILENO_TEXT_BOX;
	}

	public String getADDRESS_ALIAS_TEXT_BOX() {
		return ADDRESS_ALIAS_TEXT_BOX;
	}

//	public String getADDITIONAL_INFO_TEXT_BOX() {
//		return ADDITIONAL_INFO_TEXT_BOX;
//	}

	public String getSTATE_DRIPDOWN() {
		return STATE_DRIPDOWN;
	}
	
	
	
	


}
