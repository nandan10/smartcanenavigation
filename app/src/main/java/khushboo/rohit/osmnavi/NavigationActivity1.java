package khushboo.rohit.osmnavi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import com.navigation.smartcane.R;
//import khushboo.rohit.osmnavi.R;
import khushboo.rohit.osmnavi.R;

public class NavigationActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi1_activity);
    }

//    @Override
//    public void onBackPressed() {
//        Intent intentMain = new Intent(this, MainActivity.class);
//        startActivity(intentMain);
//        finish();
//    }


    public void navi1(View view) {
        Toast.makeText(getApplicationContext(), "You Clicked Navigation", Toast.LENGTH_LONG).show();
        Intent intentBattery = new Intent(getBaseContext(), MainActivity.class);
//                intentNA.putExtra("Type", NAV_TYPE_LOAD_ROUTE);
        startActivity(intentBattery);
    }
}
