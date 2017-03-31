package com.example.posstrsoftware.posonline.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wasabi on 3/28/2017.
 */

public class ProductListDao {
    @SerializedName("idproductpos")
    @Expose
    private String idproductpos;
    @SerializedName("prodCode")
    @Expose
    private String prodCode;
    @SerializedName("prodTName")
    @Expose
    private String prodTName;
    @SerializedName("prodIsVat")
    @Expose
    private String prodIsVat;
    @SerializedName("prodGroupName")
    @Expose
    private String prodGroupName;
    @SerializedName("uomName")
    @Expose
    private String uomName;
    @SerializedName("prodQty")
    @Expose
    private String prodQty;
    @SerializedName("prodUnitPrice")
    @Expose
    private String prodUnitPrice;
    @SerializedName("prodUnitBarcode")
    @Expose
    private String prodUnitBarcode;

    public String getIdproductpos() {
        return idproductpos;
    }

    public void setIdproductpos(String idproductpos) {
        this.idproductpos = idproductpos;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdTName() {
        return prodTName;
    }

    public void setProdTName(String prodTName) {
        this.prodTName = prodTName;
    }

    public String getProdIsVat() {
        return prodIsVat;
    }

    public void setProdIsVat(String prodIsVat) {
        this.prodIsVat = prodIsVat;
    }

    public String getProdGroupName() {
        return prodGroupName;
    }

    public void setProdGroupName(String prodGroupName) {
        this.prodGroupName = prodGroupName;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public String getProdQty() {
        return prodQty;
    }

    public void setProdQty(String prodQty) {
        this.prodQty = prodQty;
    }

    public String getProdUnitPrice() {
        return prodUnitPrice;
    }

    public void setProdUnitPrice(String prodUnitPrice) {
        this.prodUnitPrice = prodUnitPrice;
    }

    public String getProdUnitBarcode() {
        return prodUnitBarcode;
    }

    public void setProdUnitBarcode(String prodUnitBarcode) {
        this.prodUnitBarcode = prodUnitBarcode;
    }


}
