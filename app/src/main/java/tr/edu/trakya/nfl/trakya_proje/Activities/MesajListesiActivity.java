
package tr.edu.trakya.nfl.trakya_proje.Activities;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import tr.edu.trakya.nfl.trakya_proje.Fragments.MesajListesiFragment;
import tr.edu.trakya.nfl.trakya_proje.Tools;

/**
 * Created by NFL on 18.04.2017.
 */

public class MesajListesiActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        //şimdilik 5 numaralı ve hoca olan kişiye...

        return MesajListesiFragment.newInstance();
    }
    // parametre vermiyoruz zaten Tools'tan kendisi çekiyor.
    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, MesajListesiActivity.class);
        return i;
    }


}
