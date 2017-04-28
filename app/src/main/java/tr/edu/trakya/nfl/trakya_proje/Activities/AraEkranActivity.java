package tr.edu.trakya.nfl.trakya_proje.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import tr.edu.trakya.nfl.trakya_proje.Fragments.AraEkranFragment;

/**
 * Created by NFL on 28.04.2017.
 */

public class AraEkranActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return AraEkranFragment.newInstance();
    }
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, AraEkranActivity.class);

        return i;
    }


}
