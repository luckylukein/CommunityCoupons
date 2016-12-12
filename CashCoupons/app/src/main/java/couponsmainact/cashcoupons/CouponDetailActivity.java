package couponsmainact.cashcoupons;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by rajeshnair on 11/3/16.
 */

public class CouponDetailActivity extends Activity {

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_detail_act);
        showPopUp(this);
    }


    public void showPopUp(Activity couponDetailActivity) {
        try {
            if (dialog != null) {
                dialog.dismiss();
                dialog = null;
            }
            dialog = new Dialog(couponDetailActivity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.advertisement_pop_up);

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (dialog != null) {
                        dialog.dismiss();
                        dialog = null;
                    }
                }
            }, 6000);
        }catch (Exception ex){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dialog!= null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
