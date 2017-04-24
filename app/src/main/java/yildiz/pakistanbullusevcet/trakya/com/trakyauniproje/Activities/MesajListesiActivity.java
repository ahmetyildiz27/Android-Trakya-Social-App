package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Activities;

import android.support.v4.app.Fragment;

import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Fragments.MesajListesiFragment;

/**
 * Created by NFL on 18.04.2017.
 */

public class MesajListesiActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        //şimdilik 5 numaralı ve hoca olan kişiye...
        return MesajListesiFragment.newInstance(6l, false);
    }
}
