package com.benishay.danny.whomiss.Data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Dan on 19/08/2017.
 */

public class DBUtils {
    public static FirebaseDatabase dbase = FirebaseDatabase.getInstance();
    public static DatabaseReference myStudentsRef = dbase.getReference(MyStudents.class.getSimpleName());
    public static DatabaseReference myGroupsRef = dbase.getReference(MyGroups.class.getSimpleName());
    public static DatabaseReference myTeachersRef = dbase.getReference(MyTeachers.class.getSimpleName());
    public static FirebaseAuth auth = FirebaseAuth.getInstance();
}
