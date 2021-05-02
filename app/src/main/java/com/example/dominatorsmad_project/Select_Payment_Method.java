package com.example.dominatorsmad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Select_Payment_Method extends AppCompatActivity {

    private Button btnCash;
    private Button btncard;
    private String CakeName;
    private String cakeprice;
    private String cakequantity;
    private String cakedescription;
    private int resize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__payment__method);

        btnCash=findViewById(R.id.btnCash);
        btncard=findViewById(R.id.btnCard);

        //Get_product_details_from_cake_page
        CakeName = getIntent().getStringExtra("cakename");
        cakeprice = getIntent().getStringExtra("cakeprice");
        cakequantity = getIntent().getStringExtra("cakequantity");
        cakedescription = getIntent().getStringExtra("cakedescription");

        Bundle bundle=getIntent().getExtras();
        resize = bundle.getInt("img");

        //Card_payment_navi
        btncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Product_info
                Intent intent=new Intent(getApplicationContext(),Payment.class);
                intent.putExtra("CakeName",CakeName);
                intent.putExtra("cakeprice",cakeprice);
                intent.putExtra("cakequantity",cakequantity);
                intent.putExtra("cakedescription",cakedescription);
                intent.putExtra("img",resize);
                startActivity(intent);
            }
        });

        //Cash_payment_Navi
        btnCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Product_info
                Intent i = new Intent(getApplicationContext(), Address.class);
                i.putExtra("CakeName",CakeName);
                i.putExtra("cakeprice",cakeprice);
                i.putExtra("cakequantity",cakequantity);
                i.putExtra("cakedescription",cakedescription);
                i.putExtra("img",resize);
                startActivity(i);
            }
        });

    }
}