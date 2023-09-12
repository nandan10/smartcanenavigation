package com.navigation.smartcane;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import khushboo.rohit.osmnavi.R;

public class ReportIssue extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // on below line we are creating variable for spinner.
    Spinner languageSpinner;
    // on below line we are creating a variable for our list of data to be displayed in spinner.
    String[] languages = {"SELECT", "Battery Issue", "Orientation Issue", "CaneTip Issue", "Buzzer Issue", "Connecting with App Issue", "Others"};
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_issue);
        Submit = findViewById(R.id.Submit);
        // on below line we are initializing spinner with ids.
        languageSpinner = (Spinner) findViewById(R.id.idLanguageSpinner);

        // on below line we are initializing adapter for our spinner
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);

        // on below line we are setting drop down view resource for our adapter.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // on below line we are setting adapter for spinner.
        languageSpinner.setAdapter(adapter);

        // on below line we are adding click listener for our spinner
        languageSpinner.setOnItemSelectedListener(this);

        // on below line we are creating a variable to which we have to set our spinner item selected.
        String selection = "SELECT";

        // on below line we are getting the position of the item by the item name in our adapter.
        int spinnerPosition = adapter.getPosition(selection);

        // on below line we are setting selection for our spinner to spinner position.
        languageSpinner.setSelection(spinnerPosition);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // on below line we are displaying toast message for selected item
        Toast.makeText(ReportIssue.this, "" + languages[position] + " Selected..", Toast.LENGTH_SHORT).show();
        String sel_spinner = languages[position];


   // @Override
    //public void onNothingSelected(AdapterView<?> adapterView) {

   // }
    Submit.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
      // Intent i=new Intent(getApplicationContext(),NavigationActivity.class);
      //  Log.d("SELECT", String.valueOf(i));
       // i.putExtra("key",sel_spinner);
       // startActivity(i);


           Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
          //  i.setData(Uri.parse("kumari.singh@gmail.com"));
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"kumari.singh@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "REPORT GRIEVANCE");

            i.putExtra(Intent.EXTRA_TEXT, sel_spinner);
            startActivity(Intent.createChooser(i, "Choose an Email client :"));


    }
    });}

     @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

     }
    public void goBackPressed(View view) {
        onBackPressed();
    }
}
