package com.example.posstrsoftware.posonline.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wasabi on 3/27/2017.
 */

public class DivisionDao {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("companyCode")
    @Expose
    private String companyCode;
    @SerializedName("divisionCode")
    @Expose
    private String divisionCode;
    @SerializedName("divisionNameTh")
    @Expose
    private String divisionNameTh;
    @SerializedName("divisionAddressShop")
    @Expose
    private String divisionAddressShop;
    @SerializedName("divisionTel")
    @Expose
    private String divisionTel;
    @SerializedName("divisionFax")
    @Expose
    private String divisionFax;
    @SerializedName("divisionEmail")
    @Expose
    private String divisionEmail;
    @SerializedName("CusTaxId")
    @Expose
    private String cusTaxId;
    @SerializedName("xxxDate")
    @Expose
    private String xxxDate;
    @SerializedName("idCompany")
    @Expose
    private Integer idCompany;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionNameTh() {
        return divisionNameTh;
    }

    public void setDivisionNameTh(String divisionNameTh) {
        this.divisionNameTh = divisionNameTh;
    }

    public String getDivisionAddressShop() {
        return divisionAddressShop;
    }

    public void setDivisionAddressShop(String divisionAddressShop) {
        this.divisionAddressShop = divisionAddressShop;
    }

    public String getDivisionTel() {
        return divisionTel;
    }

    public void setDivisionTel(String divisionTel) {
        this.divisionTel = divisionTel;
    }

    public String getDivisionFax() {
        return divisionFax;
    }

    public void setDivisionFax(String divisionFax) {
        this.divisionFax = divisionFax;
    }

    public String getDivisionEmail() {
        return divisionEmail;
    }

    public void setDivisionEmail(String divisionEmail) {
        this.divisionEmail = divisionEmail;
    }

    public String getCusTaxId() {
        return cusTaxId;
    }

    public void setCusTaxId(String cusTaxId) {
        this.cusTaxId = cusTaxId;
    }

    public String getXxxDate() {
        return xxxDate;
    }

    public void setXxxDate(String xxxDate) {
        this.xxxDate = xxxDate;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }
}
