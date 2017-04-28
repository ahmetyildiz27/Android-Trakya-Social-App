package tr.edu.trakya.nfl.trakya_proje.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tr.edu.trakya.nfl.trakya_proje.Activities.MesajListesiActivity;
import tr.edu.trakya.nfl.trakya_proje.Activities.OgrenciProfilActivity;
import tr.edu.trakya.nfl.trakya_proje.R;
import tr.edu.trakya.nfl.trakya_proje.Tools;


/**
 * Created by NFL on 28.04.2017
 */

public class AraEkranFragment extends Fragment {

    private Button mOgrenciProfilButton;
    private Button mMesajlarProfilButton;

    public static AraEkranFragment newInstance() {

        Bundle args = new Bundle();

        AraEkranFragment fragment = new AraEkranFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        init(view);
        mOgrenciProfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = OgrenciProfilActivity.newIntent(getActivity(), Tools.getID());
                startActivity(i);
            }
        });
        mMesajlarProfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = MesajListesiActivity.newIntent(getActivity());
                startActivity(i);
            }
        });

        return view;

    }

    private void init(View view) {
        mOgrenciProfilButton = (Button) view.findViewById(R.id.buttonOgrenciProfil);
        mMesajlarProfilButton = (Button) view.findViewById(R.id.buttonMesajlarListesi);
    }


}
