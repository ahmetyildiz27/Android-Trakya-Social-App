package tr.edu.trakya.nfl.trakya_proje.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.edu.trakya.nfl.trakya_proje.Models.OgrenciProfil;
import tr.edu.trakya.nfl.trakya_proje.R;
import tr.edu.trakya.nfl.trakya_proje.Service.RetrofitInterface;
import tr.edu.trakya.nfl.trakya_proje.Service.WS;


/**
 * Created by NFL on 3.4.2017.
 */

public class OgrenciProfilFragment extends Fragment implements View.OnClickListener {

    public static final String mTag= OgrenciProfilFragment.class.getName();

    private static final String ARG_OGRENCI_ID = "ogrenci_id";

    private Long mOgrenciID;

    private RetrofitInterface service = WS.getService();

    private Button mButtonClick;
    private TextView mTextViewOgrenciAdi;
    private TextView mTextViewFakulte;
    private TextView mTextViewBolum;


    public static OgrenciProfilFragment newInstance(Long ogrenciID) {

        Bundle args = new Bundle();
        args.putLong(ARG_OGRENCI_ID, ogrenciID);
        OgrenciProfilFragment fragment = new OgrenciProfilFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ogrenci_profil2, container, false); // fark ederseniz 2.profil sayfasını inflate ediyoruz deneme amaçlı
        init(view); // wire up kısımı daha kolay yapabilmek için böyle yapıyoruz
        mOgrenciID = getArguments().getLong(ARG_OGRENCI_ID); // ogrenciId'si, ogrenciNo'su değil (farklışeyler)
        Call<OgrenciProfil> serviceCall;
        serviceCall = service.getOgrenciProfil(mOgrenciID);
        serviceCall.enqueue(new Callback<OgrenciProfil>() {
            @Override
            public void onResponse(Call<OgrenciProfil> call, Response<OgrenciProfil> response) {
                mTextViewOgrenciAdi.setText(response.body().getOgrenci_ad());
                mTextViewBolum.setText(response.body().getBolum().getBolum_adi());
                mTextViewFakulte.setText(response.body().getBolum().getFakulte_adi());
            }

            @Override
            public void onFailure(Call<OgrenciProfil> call, Throwable t) {

            }
        });


        return view;
    }

    private void init(View view) {

        mButtonClick = (Button) view.findViewById(R.id.btnClick);
        mButtonClick.setOnClickListener(this);

        mTextViewOgrenciAdi = (TextView) view.findViewById(R.id.textOgrenciAdi);
        mTextViewFakulte = (TextView) view.findViewById(R.id.textFakultesi);
        mTextViewBolum = (TextView) view.findViewById(R.id.textBolumAdi);
    }

    public boolean NoEth() {
        return true;
    }

    @Override
    public void onClick(View view) {

        if (NoEth()) {

            if (view.getId() == R.id.btnClick) {

                Toast.makeText(getActivity(), "Merhaba Tombili", Toast.LENGTH_LONG).show();
            }
        }

    }
}