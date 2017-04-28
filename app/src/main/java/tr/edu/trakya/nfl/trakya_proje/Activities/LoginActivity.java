package tr.edu.trakya.nfl.trakya_proje.Activities;

import android.support.v4.app.Fragment;

import tr.edu.trakya.nfl.trakya_proje.Fragments.LoginFragment;

/**
 * Created by NFL on 3.4.2017.
 */

public class LoginActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return LoginFragment.newInstance();
    }


}
