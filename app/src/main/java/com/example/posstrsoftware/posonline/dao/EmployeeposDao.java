package com.example.posstrsoftware.posonline.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wasabi on 3/28/2017.
 */

public class EmployeeposDao {
    @SerializedName("idEmployeepos")
    @Expose
    private String idEmployeepos;
    @SerializedName("empCode")
    @Expose
    private String empCode;
    @SerializedName("empPOSName")
    @Expose
    private String empPOSName;
    @SerializedName("empPOSPeopleId")
    @Expose
    private String empPOSPeopleId;
    @SerializedName("empPOSGender")
    @Expose
    private String empPOSGender;
    @SerializedName("empPOSAddress")
    @Expose
    private String empPOSAddress;
    @SerializedName("empPOSTel")
    @Expose
    private String empPOSTel;
    @SerializedName("empPOSEmail")
    @Expose
    private String empPOSEmail;

    public String getIdEmployeepos() {
        return idEmployeepos;
    }

    public void setIdEmployeepos(String idEmployeepos) {
        this.idEmployeepos = idEmployeepos;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpPOSName() {
        return empPOSName;
    }

    public void setEmpPOSName(String empPOSName) {
        this.empPOSName = empPOSName;
    }

    public String getEmpPOSPeopleId() {
        return empPOSPeopleId;
    }

    public void setEmpPOSPeopleId(String empPOSPeopleId) {
        this.empPOSPeopleId = empPOSPeopleId;
    }

    public String getEmpPOSGender() {
        return empPOSGender;
    }

    public void setEmpPOSGender(String empPOSGender) {
        this.empPOSGender = empPOSGender;
    }

    public String getEmpPOSAddress() {
        return empPOSAddress;
    }

    public void setEmpPOSAddress(String empPOSAddress) {
        this.empPOSAddress = empPOSAddress;
    }

    public String getEmpPOSTel() {
        return empPOSTel;
    }

    public void setEmpPOSTel(String empPOSTel) {
        this.empPOSTel = empPOSTel;
    }

    public String getEmpPOSEmail() {
        return empPOSEmail;
    }

    public void setEmpPOSEmail(String empPOSEmail) {
        this.empPOSEmail = empPOSEmail;
    }


}
