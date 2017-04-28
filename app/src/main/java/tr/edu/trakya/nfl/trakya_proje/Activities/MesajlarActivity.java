package tr.edu.trakya.nfl.trakya_proje.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import tr.edu.trakya.nfl.trakya_proje.Fragments.MesajlarFragment;
import tr.edu.trakya.nfl.trakya_proje.Models.SonKonusmaMesaji;

/**
 * Created by NFL on 10.4.2017.
 */

public class MesajlarActivity extends SingleFragmentActivity {
    private static final String EXTRA_DIGER_ID = "extra_diger_id";
    private static final String EXTRA_DIGER_HOCA_MI = "extra_diger_hoca_mi";

    @Override
    protected Fragment createFragment() {

        Long diger_id = getIntent().getLongExtra(EXTRA_DIGER_ID, 0);
        boolean diger_hoca_mi = getIntent().getBooleanExtra(EXTRA_DIGER_HOCA_MI, false);

        return MesajlarFragment.newInstance(diger_id, diger_hoca_mi);


    }
    public static Intent newIntent(Context packageContext, Long diger_id,boolean diger_hoca_mi) {
        Intent i = new Intent(packageContext, MesajlarActivity.class);
        i.putExtra(EXTRA_DIGER_ID,diger_id);
        i.putExtra(EXTRA_DIGER_HOCA_MI,diger_hoca_mi);

        return i;
    }


}
