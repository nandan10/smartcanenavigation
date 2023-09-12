package com.navigation.smartcane;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import khushboo.rohit.osmnavi.R;

public class RegisterActivity<Editor> extends AppCompatActivity {
    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";
    // key for storing Serialnumber.
    public static final String MESSAGE_KEY = "message_key";

    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    // creating variables for our edit text and button.
    private EditText messageEdt, messageEdt0,messageEdt1,messageEdt2;
    Button submitBtn;

    private Context ctx;
    // private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        // getting the data which is stored in shared preferences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        // initializing our variables.
        messageEdt = findViewById(R.id.idEdtMessage);
        messageEdt0 = findViewById(R.id.idEdtMessage0);
        messageEdt1 = findViewById(R.id.idEdtMessage1);
        messageEdt2 = findViewById(R.id.idEdtMessage2);
        submitBtn = findViewById(R.id.BtnSubmit);

        // adding on click listener for our button.
        submitBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             // inside on click we are checking if the entered data
                                             // by user is empty or not.

                                             String msg = messageEdt.getText().toString();
                                             if (TextUtils.isEmpty(msg)) {
                                                 // if the input is empty we are displaying a toast message.
                                                 Toast.makeText(RegisterActivity.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                                             }
                                             String msg0 = messageEdt0.getText().toString();
                                             if (TextUtils.isEmpty(msg0)) {
                                                 // if the input is empty we are displaying a toast message.
                                                 Toast.makeText(RegisterActivity.this, "Please enter your Serial Number", Toast.LENGTH_SHORT).show();
                                             }
                                             String msg1 = messageEdt1.getText().toString();
                                             if (TextUtils.isEmpty(msg1)) {
                                                 // if the input is empty we are displaying a toast message.
                                                 Toast.makeText(RegisterActivity.this, "Please enter your Email Id", Toast.LENGTH_SHORT).show();
                                             }
                                             String msg2 = messageEdt2.getText().toString();
                                             if (TextUtils.isEmpty(msg2)) {
                                                 // if the input is empty we are displaying a toast message.
                                                 Toast.makeText(RegisterActivity.this, "Please enter your Mobile Number", Toast.LENGTH_SHORT).show();}



                                             // String msg = "";

                                             Intent i = new Intent(Intent.ACTION_SEND);
                                             i.setType("message/rfc822");
                                             //  i.setData(Uri.parse("kumari.singh@gmail.com"));
                                             i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"kumari.singh@gmail.com"});
                                             i.putExtra(Intent.EXTRA_SUBJECT, "REGISTER");

                                             i.putExtra(Intent.EXTRA_TEXT,"Name : "+msg+"\n"+"Serial Number : "+msg0+"\n"+"Email-Id : "+msg1+"\n"+"Mobile Number : "+msg2);

                                             startActivity(Intent.createChooser(i, "Choose an Email client :"));


                                         }





             /*   else
                    {
                        // if the input is not empty we are calling a method to save
                        // data to shared prefs.
                        saveMessage(msg);
                       // new SaveSharedPreference();
                   // report();
                        //SaveSharedPreference1();


                }*/
                                     }
        );


    }

   /* private void saveMessage(String msg) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        // below lines will put values for
        // message in shared preferences.
        editor.putString(MESSAGE_KEY, msg);
        // to save our data with key and value.
        editor.apply();
        // on below line we are displaying a toast message after adding data to shared prefs.
        Toast.makeText(this, "Message saved to Shared Preferences", Toast.LENGTH_SHORT).show();
        // after that we are setting our edit text to empty
        //messageEdt0.setText("");
        Toast.makeText(RegisterActivity.this, "User Registered successfully", Toast.LENGTH_SHORT).show();

    }*/



    /*public static class SaveSharedPreference<Editor> {
        static final String PREF_USER_NAME = "name";
        private Context ctx;

        static SharedPreferences getSharedPreferences(Context ctx) {
            return PreferenceManager.getDefaultSharedPreferences(ctx);
        }

        public static <Editor> void setUserName(Context ctx, String userName) {
            Editor editor = (Editor) getSharedPreferences(ctx).edit();
            ((SharedPreferences.Editor) editor).putString(PREF_USER_NAME, userName);
            ((SharedPreferences.Editor) editor).commit();
        }

        public static String getUserName(Context ctx) {
            return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
        }
    }
*/

    public void goBackPressed(View view) {
        onBackPressed();
    }

}

