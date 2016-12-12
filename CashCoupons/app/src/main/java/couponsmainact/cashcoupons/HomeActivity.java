package couponsmainact.cashcoupons;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HomeActivity extends Activity {

    private ViewFlipper mFlipper;
    private final int TIME_DELAY_PER_PAGE = 5000;
    private Spinner countySpinner, communitySpinner, typeBusinessSpinner, categorySpinner;
    private LinearLayout receiveDeals, countySpinnerLayout,
            communitySpinnerLayout, typeOfBusinessSpinnerLayout, categorySpinnerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main_act);
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        // County
        ((TextView)findViewById(R.id.county_spinner_layout).findViewById(R.id.search_spinner_text)).setText(R.string.county);
        countySpinner = (Spinner)findViewById(R.id.county_spinner_layout).findViewById(R.id.search_spinner);
        ArrayAdapter<CharSequence> countySpinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.county_array, android.R.layout.simple_spinner_item);
        countySpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(countySpinnerArrayAdapter);

        // Community
        ((TextView)findViewById(R.id.community_spinner_layout).findViewById(R.id.search_spinner_text)).setText(R.string.community);
        communitySpinner = (Spinner)findViewById(R.id.community_spinner_layout).findViewById(R.id.search_spinner);
        ArrayAdapter<CharSequence> communitySpinnerArrayAdapter = ArrayAdapter.createFromResource(this, R.array.community_array, android.R.layout.simple_spinner_item);
        communitySpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        communitySpinner.setAdapter(communitySpinnerArrayAdapter);

        // Type of Business
        ((TextView)findViewById(R.id.type_of_business_spinner_layout).findViewById(R.id.search_spinner_text)).setText(R.string.type_of_business);
        typeBusinessSpinner = (Spinner)findViewById(R.id.type_of_business_spinner_layout).findViewById(R.id.search_spinner);
        ArrayAdapter<String> businessSpinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.business_array));
        businessSpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeBusinessSpinner.setAdapter(businessSpinnerArrayAdapter);

        // Category
        ((TextView)findViewById(R.id.category_spinner_layout).findViewById(R.id.search_spinner_text)).setText(R.string.category);
        categorySpinner = (Spinner)findViewById(R.id.category_spinner_layout).findViewById(R.id.search_spinner);
        ArrayAdapter<String> categorySpinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.category_array));
        categorySpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categorySpinnerArrayAdapter);

        Button searchButton = (Button)findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CouponsListActivity.class);
                startActivity(intent);
            }
        });
        receiveDeals = (LinearLayout)findViewById(R.id.deals_text_layout);
        receiveDeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setProperties() {
        mFlipper.setInAnimation(this, R.anim.in_from_right);
        mFlipper.setOutAnimation(this, R.anim.out_to_left);
        mFlipper.setFlipInterval(TIME_DELAY_PER_PAGE);// setting the interval
        // for 5s
        mFlipper.startFlipping(); // views flipping starts.

    }
}
