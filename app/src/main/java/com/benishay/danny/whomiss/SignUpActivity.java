package com.benishay.danny.whomiss;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.benishay.danny.whomiss.Data.DBUtils;
import com.benishay.danny.whomiss.Data.MyTeachers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText etmail, etpassw, etrepassw;
    private EditText etname, etphone;
    private Button btnsignup;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etmail = (EditText) findViewById(R.id.etEmail);
        etpassw = (EditText) findViewById(R.id.etPassw);
        etrepassw = (EditText) findViewById(R.id.etReEnterPassw);
        etname = (EditText) findViewById(R.id.etName);
        etphone = (EditText) findViewById(R.id.etPhone);
        btnsignup = (Button) findViewById(R.id.btnSignUp);
        auth = FirebaseAuth.getInstance();

        eventHandler();
    }

    private void eventHandler() {
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHanlder();
            }
        });
    }

    private void dataHanlder() {
        final String stEmail = etmail.getText().toString();
        String stPassw = etpassw.getText().toString();
        String stRePassw = etrepassw.getText().toString();
        final String stName = etname.getText().toString();
        final String stPhone = etphone.getText().toString();

        boolean isOK = true;
        int errorType = 0;
//        if (stEmail.length() < 6 || stEmail.indexOf('@') < 2 || !stPassw.equals(stRePassw) || stPassw.length() < 6 ||
//                stEmail.indexOf('.') < 3)
//        {
//            Toast.makeText(this, stEmail, Toast.LENGTH_LONG).show();
//            etmail.setError("WRONG email");
//            isOK = false;
//        }

        if (isOK) {
            final ProgressDialog progDialog = ProgressDialog.show(this, "Wait...", "Signing up...", true, true);
            progDialog.show();

            auth.createUserWithEmailAndPassword(stEmail, stPassw).addOnCompleteListener(this,
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progDialog.dismiss();
                            if (task.isSuccessful()) {
                                MyTeachers myTeachers = new MyTeachers();
                                myTeachers.setTeachKey_email(stEmail);
                                myTeachers.setName(stName);
                                myTeachers.setPhone(stPhone);
//below is the point that my prog CRASH
//                                Toast.makeText(SignUpActivity.this, "RIGHT B4 the bug", Toast.LENGTH_LONG).show();
                                DBUtils.myTeachersRef.child(myTeachers.getTeachKey_email().replace('.','*')).setValue(
                                        myTeachers).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
//                                        Toast.makeText(SignUpActivity.this, "RIGHT after the bug", Toast.LENGTH_SHORT).show();
                                        if (task.isSuccessful()) {
                                            finish();
                                        }
                                        else {
                                            Toast.makeText(SignUpActivity.this,
                                                    task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                            else {
                                Toast.makeText(SignUpActivity.this,
                                        task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                task.getException().printStackTrace();
                            }
                        }
                    });
        }
    }
}
