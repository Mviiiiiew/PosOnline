package com.example.posstrsoftware.posonline.manager.http;

import com.example.posstrsoftware.posonline.dao.DivisionDao;
import com.example.posstrsoftware.posonline.dao.EmployeeposDao;
import com.example.posstrsoftware.posonline.dao.ProductListDao;
import com.example.posstrsoftware.posonline.dao.RegisterDataDao;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Wasabi on 3/21/2017.
 */

public interface ApiService {
    @GET("divisionpos.php")
    Call<ArrayList< DivisionDao> > GetDivisionListDao();

    @GET("employeepos.php")
    Call<ArrayList<EmployeeposDao> > GetEmployeeListDao();

    @GET("productlist.php")
    Call<ArrayList<ProductListDao> > GetProductListDao();


    @FormUrlEncoded
    @POST("Register.php")
    Call<RegisterDataDao> RegisterData
            (@Field("name") String name,@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("addproduct.php")
    Call<ProductListDao> addproduct
            (@Field("prodCode") String prodCode,
             @Field("prodTName") String prodTName,
             @Field("prodIsVat") String prodIsVat,
             @Field("prodGroupName") String prodGroupName,
             @Field("uomName") String uomName,
             @Field("prodQty") String prodQty,
             @Field("prodUnitPrice") String prodUnitPrice,
             @Field("prodUnitBarcode") String prodUnitBarcode

            );


    @FormUrlEncoded
    @POST("Login.php")
    Call<RegisterDataDao> Login
            (@Field("username") String username,@Field("password") String password);



}
