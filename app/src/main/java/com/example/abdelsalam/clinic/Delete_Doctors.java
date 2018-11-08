package com.example.abdelsalam.clinic;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Delete_Doctors extends AppCompatActivity {
    Clinic clinic ;
    EditText et_Delete;
    TextView operation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__doctors);
        et_Delete=(EditText)findViewById(R.id.et_delete);
        operation=(TextView) findViewById(R.id.tv_operation);
        clinic = new Clinic(this);
    }
    public void delete_All_Doctors(View view)
    {
        try
        {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Sure ?");
            alert.setMessage("Are U Sure Of This Opeartion");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String s = clinic.delete_table1();
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




    public void delete_ID(View view) {
   try{
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Sure ?");
        alert.setMessage("Are U Sure Of This Opeartion");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s = clinic.deleteByID_table1(Integer.parseInt(et_Delete.getText().toString()));
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
}
