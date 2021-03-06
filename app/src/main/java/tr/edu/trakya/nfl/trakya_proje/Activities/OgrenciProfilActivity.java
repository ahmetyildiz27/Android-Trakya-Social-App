package tr.edu.trakya.nfl.trakya_proje.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import tr.edu.trakya.nfl.trakya_proje.Fragments.OgrenciProfilFragment;


/**
 * Created by NFL on 3.4.2017.
 */

public class OgrenciProfilActivity extends SingleFragmentActivity {

    private static final String EXTRA_OGRENCI_ID = OgrenciProfilActivity.class.getName(); // TODO: 27.2.2017

    @Override
    protected Fragment createFragment() {
        //ikinci parametre null default value olması lazım
        Long ogrenciID = getIntent().getLongExtra(EXTRA_OGRENCI_ID, 01);
        return OgrenciProfilFragment.newInstance(ogrenciID);
    }



    public static Intent newIntent(Context context, Long ogrenciID) {
        Intent intent = new Intent(context, OgrenciProfilActivity.class);
        intent.putExtra(EXTRA_OGRENCI_ID, ogrenciID);
        return intent;
    }
}
