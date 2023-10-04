package khushboo.rohit.osmnavi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//import com.navigation.smartcane.R;
import khushboo.rohit.osmnavi.R;

public class SettingsActivity extends AppCompatActivity {
    Button settings1,settings2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        initButtons();

    }
    private void initButtons() {
        this.settings1 = findViewById(R.id.settings1);
        this.settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(getBaseContext(), ProfilesActivity.class);
               // intentProfileCustomize.putExtra("CustomProfileNumber", 1);
                startActivity(intentProfile);
            }
        });

        this.settings2 = findViewById(R.id.settings2);
        this.settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIntensity = new Intent(getBaseContext(), IntensityActivity.class);
              //  intentProfileCustomize.putExtra("CustomProfileNumber", 2);
                startActivity(intentIntensity);
            }
        });
    }

  /* @Override
   public void onBackPressed() {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }*/
  public void goBackPressed(View view) {
      onBackPressed();
  }
}