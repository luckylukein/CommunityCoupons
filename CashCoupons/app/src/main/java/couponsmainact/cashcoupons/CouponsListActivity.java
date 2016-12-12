package couponsmainact.cashcoupons;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;

import couponsmainact.cashcoupons.dummy.DummyContent;

public class CouponsListActivity extends Activity implements CouponsListActivityFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons_list);
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
