package com.example.abdelsalam.clinic;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Doctors extends AppCompatActivity {

    EditText e1 , e2 , e3 , e4 , e5 ;
    Clinic clinic ;
    TextView operation ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        e1 = (EditText)findViewById(R.id.etid);
        e2 = (EditText)findViewById(R.id.etname);
        e3 = (EditText)findViewById(R.id.etPhone);
        e4 = (EditText)findViewById(R.id.etAddress);
        e5 = (EditText)findViewById(R.id.etAge);
        clinic = new Clinic(this);
        operation = (TextView)findViewById(R.id.opearionID);
        listView = (ListView)findViewById(R.id.listviewID);
    }

    public void insert(View view)
    {
        try
        {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Sure ?");
            alert.setMessage("Are U Sure Of This Opeartion");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String s = clinic.insert1(Integer.parseInt(e1.getText().toString()), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(), Integer.parseInt(e5.getText().toString()));
                    clear();
                    operation.setText(s);
                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    operation.setText("Operation Cancled");
                }
            });
            alert.show();
        }
        catch (Exception e)
        {
            operation.setText("Exception "+e.getMessage().toString());
        }
    }
    public void onShow(View view)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor c = clinic.AllData_table1();
        ArrayAdapter<String> arrayAdapter ;
        while(c.moveToNext())
        {
            arrayList.add(c.getString(0)+"\t"+c.getString(1)+"\t"+c.getString(2)+"\t"+c.getString(3)+"\t"+c.getString(4));
        }
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
        listView.setAdapter(arrayAdapter);
        operation.setText("All Data Shown");
    }

    public void onUpdate(View view)
    {
        try {
            String s = clinic.updateNameT1(Integer.parseInt(e1.getText().toString()), e2.getText().toString());
            operation.setText(s);
        }catch (Exception e)
        {
            operation.setText(e.getMessage().toString());
        }
    }

    public void clear()
    {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
    }




    public void Open_Delete_doctors(View view) {
        startActivity(new Intent(this,Delete_Doctors.class));
    }
    public void openPatients(View view) {
        startActivity(new Intent(this,Patients.class));
    }
    public void openNurses(View view) {
        startActivity(new Intent(this,Nurses.class));
    }

}

