package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Activities;

import android.support.v4.app.Fragment;

import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Fragments.LoginFragment;

/**
 * Created by NFL on 3.4.2017.
 */

public class LoginActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return LoginFragment.newInstance();
    }


}
