package com.benishay.danny.whomiss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText etmail, etpassw;
    private Button btnsignup, btnsignin;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
            finish();
        }

        etmail = (EditText) findViewById(R.id.etEmail);
        etpassw = (EditText) findViewById(R.id.etPassw);
        btnsignin = (Button) findViewById(R.id.btnSignIn);
        btnsignup = (Button) findViewById(R.id.btnSignUp);

        eventHandler();
    }

    private void eventHandler() {
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    private void dataHandler() {
        String stEmail = etmail.getText().toString();
        String stPassw = etpassw.getText().toString();
        boolean isOK = true;
        if (stEmail.length() < 6 || stEmail.indexOf('@') < 1 || stPassw.length() < 6) {
            isOK = false;
            etmail.setError("wrong email or password");
        }
        if (isOK) {
            signIn(stEmail, stPassw);
        }
    }

    private void signIn(String stEmail, String stPassw) {
        final ProgressDialog progDialog = ProgressDialog.show(this, "wait...", "Log in...", true, true);
        progDialog.show();

        auth.signInWithEmailAndPassword(stEmail, stPassw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progDialog.dismiss();
                if (task.isSuccessful()) {
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "wrong email or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
