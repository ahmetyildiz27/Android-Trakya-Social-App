package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Activities;

import android.support.v4.app.Fragment;

import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Fragments.MesajlarFragment;

/**
 * Created by NFL on 10.4.2017.
 */

public class MesajlarActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return MesajlarFragment.newInstance();
    }
}
