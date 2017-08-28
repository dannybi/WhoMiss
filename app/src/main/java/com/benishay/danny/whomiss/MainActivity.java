package com.benishay.danny.whomiss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.benishay.danny.whomiss.Data.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button btnRemoveGroup, btnAddGroup, btnManageSecretary;
    private Spinner spnrManagedGroups;
    private List<String> lstOfGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRemoveGroup = (Button) findViewById(R.id.btnRemoveGrp);
        btnAddGroup = (Button) findViewById(R.id.btnAddGrp);
        btnManageSecretary = (Button) findViewById(R.id.btnSecretary);

        spnrManagedGroups = (Spinner) findViewById(R.id.spnrGrpManage);
        lstOfGroups = new ArrayList<String>();
        lstOfGroups.add("Class yud C#");
        lstOfGroups.add("Class Yud Alef modelim");
        lstOfGroups.add("Tet Class - Python");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, lstOfGroups);

        spnrManagedGroups.setAdapter(dataAdapter);

        spnrManagedGroups.setOnItemSelectedListener(this);

        eventHandler();
    }

    private void eventHandler() {
        btnAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AddGroup.class);
                startActivity(i);
            }
        });
        btnRemoveGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), RemoveGroup.class);
                startActivity(i);
            }
        });
        btnManageSecretary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ManageSecretaries.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings)
            return true;
        if (id == R.id.mnItmSignout) {
            DBUtils.auth.signOut();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Select" + item, Toast.LENGTH_LONG).show();
        //need to jump into "Manage Group" activity
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
