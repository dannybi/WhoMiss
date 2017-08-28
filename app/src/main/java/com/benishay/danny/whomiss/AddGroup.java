package com.benishay.danny.whomiss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.benishay.danny.whomiss.Data.DBUtils;
import com.benishay.danny.whomiss.Data.MyGroups;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class AddGroup extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText etNewGroupName, etSchoolName;
    private Button btnOk, btnCancel;
    private String stGrader, stNewGroupName, stSchoolName;
    private Spinner spnrGraders;
    private List<String> lstOfGraders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        etNewGroupName = (EditText) findViewById(R.id.etGroupName);
        etSchoolName = (EditText) findViewById(R.id.etSchoolName);
        spnrGraders = (Spinner) findViewById(R.id.spnrGraders);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        stGrader = "";

        lstOfGraders = new ArrayList<String>();
        lstOfGraders.add("Tet");
        lstOfGraders.add("Yud");
        lstOfGraders.add("Yud Alef");
        lstOfGraders.add("Yud Bet");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, lstOfGraders);
        spnrGraders.setAdapter(dataAdapter);
        spnrGraders.setOnItemSelectedListener(this);

        eventHandler();
    }

    private void eventHandler() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isOK = true;
                stNewGroupName = etNewGroupName.getText().toString();
                stSchoolName = etSchoolName.getText().toString();
                if (stGrader.equals("") || stNewGroupName.length() == 0 || stSchoolName.length() == 0) {
                    isOK = false;
                    Toast.makeText(AddGroup.this, "illegal data entered", Toast.LENGTH_LONG).show();
                }
                if (isOK) {
                    addNewGroup(stGrader, stNewGroupName, stSchoolName);
                }
            }
        });
    }

    private void addNewGroup(String stGrader, String stNewGroupName, String stSchoolName) {
        final ProgressDialog progDialog = ProgressDialog.show(this, "Wait...", "Adding new Group...", true, true);
        progDialog.show();
        MyGroups myGrp = new MyGroups();
        myGrp.setName(stNewGroupName);
        myGrp.setSchoolName(stSchoolName);
        myGrp.setGrader(stGrader);
        String myEmail = DBUtils.auth.getCurrentUser().getEmail();
        myGrp.setMngrStudKey(myEmail.replace('.','*'));
        String gKey = DBUtils.myGroupsRef.push().getKey();
        myGrp.setgKey(gKey);
        DBUtils.myGroupsRef.child(gKey).setValue(myGrp).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progDialog.dismiss();
                if (task.isSuccessful()) {
                    finish();
//                    Toast.makeText(AddGroup.this, "SUCCEED save in Firebase", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(AddGroup.this, "FAIL saving", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        stGrader = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
