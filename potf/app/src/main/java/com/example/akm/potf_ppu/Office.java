package com.example.akm.potf_ppu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import android.content.Intent;
import android.widget.TextView;

public class Office extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        String [] list_floor={"1","2","3","4"};
        String [] list_unit={"10","20","30","40"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list_floor);
        MaterialBetterSpinner spinner=(MaterialBetterSpinner)findViewById(R.id.spinner_floor);
        spinner.setAdapter(arrayAdapter);

        ArrayAdapter<String>array_unit=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list_unit);
        MaterialBetterSpinner spin=(MaterialBetterSpinner)findViewById(R.id.spinner_unit);
        spin.setAdapter(array_unit);

        Button p=(Button)findViewById(R.id.pass);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),register.class);
                startActivity(i);
            }
        });

        TextView info=(TextView)findViewById(R.id.tvMoreInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),office_info.class);
                startActivity(intent);
            }
        });
    }
}
