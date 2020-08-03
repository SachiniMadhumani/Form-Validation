package com.example.formvaidation;
import android.content.Intent;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import android.os.Bundle;
import android.util.Patterns;
import android.view.InputDevice;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner2;
    EditText etNIC,etACNo,etUss,etFname,etLname,etDOB,etMob,etMail,etAdd;
    Button bsubmit,breset;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bsubmit=findViewById(R.id.buttonSubmit);
        breset=findViewById(R.id.buttonreset);
        addItemsOnSpinner2();

        //Assign variable

        etNIC=findViewById(R.id.editTextNIC);
        etACNo=findViewById(R.id.editTextAccountNO);
        etUss=findViewById(R.id.editothersaluation);
        etFname=findViewById(R.id.editTextfirstName);
        etLname=findViewById(R.id.editTextlastName);
        etDOB=findViewById(R.id.editTextDob);
        etMob=findViewById(R.id.editTextMobile);
        etMail=findViewById(R.id.editTextEmail);
        etAdd=findViewById(R.id.editTextAddress);


        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.editTextNIC,"[a-zA-Z0-9]{0,20}$",R.string.invalid_nic);
        awesomeValidation.addValidation(this,R.id.editTextAccountNO,"[1-9][0-9]{0,19}$",R.string.invalid_Accountno);
        awesomeValidation.addValidation(this,R.id.editTextfirstName, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.editTextMobile, "[0]{1}[0-9]{9}$",R.string.invalid_Mobile);
        awesomeValidation.addValidation(this,R.id.editTextEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_Email);
        awesomeValidation.addValidation(this,R.id.editTextAddress,"[a-zA-Z0-9]{0,250}$",R.string.invalid_address);

        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),"Form validation sucsess",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Validation Failed",Toast.LENGTH_SHORT).show();
                }
            }
            public void startService (View view){
                Intent intent= new Intent(getApplicationContext(), Postmaster.class);
                intent.putExtra("nic",etNIC.getText().toString());
                intent.putExtra("acc",etACNo.getText().toString());
                intent.putExtra("data",etUss.getText().toString());
                intent.putExtra("fname",etFname.getText().toString());
                intent.putExtra("lname",etLname.getText().toString());
                int mob = Integer.parseInt(etMob.getText().toString());
                intent.putExtra("mob",mob);
                intent.putExtra("mail",etMail.getText().toString());
                intent.putExtra("add",etAdd.getText().toString());
                startActivity(intent);
            }
        }


        );
//reset button
        breset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                etNIC.setText("");
                etACNo.setText("");
                etUss.setText("");
                etFname.setText("");
                etLname.setText("");
                etDOB.setText("");
                etMob.setText("");
                etMail.setText("");
                etAdd.setText("");


            }
        });


    }
//Add items to the spinner
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Mr");
        list.add("Mrs");
        list.add("Dr");
        list.add("Pro");
        list.add("Rev");
        list.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }





}