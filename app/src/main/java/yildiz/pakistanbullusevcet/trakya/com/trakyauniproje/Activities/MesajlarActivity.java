package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Fragments.MesajlarFragment;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Models.SonKonusmaMesaji;

/**
 * Created by NFL on 10.4.2017.
 */

public class MesajlarActivity extends SingleFragmentActivity {
    private static final String EXTRA_DIGER_ID = "extra_diger_id";
    private static final String EXTRA_DIGER_HOCA_MI = "extra_diger_hoca_mi";

    private static final String EXTRA_GONDEREN_ID = "extra_gonderen_id";
    private static final String EXTRA_GONDEREN_HOCA_MI = "extra_gonderen_hoca_mi";

    private static final String EXTRA_ALICI_ID = "extra_alici_id";
    private static final String EXTRA_ALICI_HOCA_MI = "extra_alici_hoca_mi";

    @Override
    protected Fragment createFragment() {
        Long alici_id = getIntent().getLongExtra(EXTRA_ALICI_ID, 0);
        boolean alici_hoca_mi = getIntent().getBooleanExtra(EXTRA_ALICI_HOCA_MI, false);
        Long gonderen_id = getIntent().getLongExtra(EXTRA_GONDEREN_ID, 0);
        boolean gonderen_hoca_mi = getIntent().getBooleanExtra(EXTRA_GONDEREN_HOCA_MI, false);
        Long diger_id = getIntent().getLongExtra(EXTRA_DIGER_ID, 0);
        boolean diger_hoca_mi = getIntent().getBooleanExtra(EXTRA_DIGER_HOCA_MI, false);

        return MesajlarFragment.newInstance(alici_id, alici_hoca_mi, gonderen_id, gonderen_hoca_mi, diger_id, diger_hoca_mi);
    }

    public static Intent newIntent(Context packageContext, SonKonusmaMesaji mesaj) {
        Intent i = new Intent(packageContext, MesajlarActivity.class);
        i.putExtra(EXTRA_DIGER_ID, mesaj.getDiger_kisi_id());
        i.putExtra(EXTRA_DIGER_HOCA_MI, mesaj.isDiger_kisi_hoca_mi());
        i.putExtra(EXTRA_ALICI_ID, mesaj.getAlici_id());
        i.putExtra(EXTRA_ALICI_HOCA_MI, mesaj.isAlici_hoca_mi());
        i.putExtra(EXTRA_GONDEREN_ID, mesaj.getGonderen_id());
        i.putExtra(EXTRA_GONDEREN_HOCA_MI, mesaj.isGonderen_hoca_mi());


        return i;
    }


}
