package yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Models.Mesaj;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.R;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Service.RetrofitInterface;
import yildiz.pakistanbullusevcet.trakya.com.trakyauniproje.Service.WS;


/**
 * Created by NFL on 10.4.2017.
 */

public class MesajlarFragment extends Fragment {
    private RetrofitInterface service = WS.getService();
    private RecyclerView mMesajlarRecylerView;
    private MesajlarAdapter mMesajlarAdapter;
    private List<Mesaj> mMesajList;

    private int alici_id = 27, gonderen_id = 25;
    private boolean alici_hoca_mi = false, gonderen_hoca_mi = false;

    private EditText mMesajIcerikEditText;
    private Button mMesajGonderButton;


    public static MesajlarFragment newInstance() {

        Bundle args = new Bundle();

        MesajlarFragment fragment = new MesajlarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mesajlasma, container, false);
        init(view);

        refreshMesajlar();

        // mesaj gonderme yeri
        mMesajGonderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesajIcerik = mMesajIcerikEditText.getText().toString();
                Call<Boolean> mesajGonderCall = service.mesajGonder(alici_id,alici_hoca_mi,gonderen_id,gonderen_hoca_mi,mesajIcerik);
                mesajGonderCall.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        //Toast.makeText(getActivity(), "mesaj gonderildi", Toast.LENGTH_SHORT).show();
                        refreshMesajlar();
                        mMesajIcerikEditText.setText("");
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

    private void updateUI() {
        mMesajlarAdapter = new MesajlarAdapter();
        mMesajlarRecylerView.setAdapter(mMesajlarAdapter);
    }

    private void refreshMesajlar() {
        Call<List<Mesaj>> mesajlarCall = service.getMesajlar(alici_id, alici_hoca_mi, gonderen_id, gonderen_hoca_mi);
        mesajlarCall.enqueue(new Callback<List<Mesaj>>() {
            @Override
            public void onResponse(Call<List<Mesaj>> call, Response<List<Mesaj>> response) {
                Toast.makeText(getActivity(), "onResponse", Toast.LENGTH_SHORT).show();
                mMesajList = response.body();
                updateUI();
            }

            @Override
            public void onFailure(Call<List<Mesaj>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
                Log.d("Hata:", t.toString());

            }
        });
    }


    private class MesajlarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final int EXTRA_SAG_LAYOUT = 0;
        private final int EXTRA_SOL_LAYOUT = 1;

        class MesajSagLayout extends RecyclerView.ViewHolder {
            TextView mSagMesajIcerikTextView;
            TextView mSagMesajTarihTextView;

            public MesajSagLayout(View itemView) {
                super(itemView);
                mSagMesajIcerikTextView = (TextView) itemView.findViewById(R.id.activity_mesajlasma_sag_mesaj_metin_icerik);
                mSagMesajTarihTextView = (TextView) itemView.findViewById(R.id.activity_mesajlasma_sag_mesaj_mesaj_tarih);
            }

            private void bind(Mesaj mesaj) {
                mSagMesajIcerikTextView.setText(mesaj.getIcerik());

                mSagMesajTarihTextView.setText(getDateStringFormat(mesaj.getTarih()));
            }
        }

        class MesajSolLayout extends RecyclerView.ViewHolder {
            TextView mSolMesajIcerikTextView;
            TextView mSolMesajTarihTextView;

            public MesajSolLayout(View itemView) {
                super(itemView);
                mSolMesajIcerikTextView = (TextView) itemView.findViewById(R.id.activity_mesajlasma_sol_mesaj_mesaj_icerik);
                mSolMesajTarihTextView = (TextView) itemView.findViewById(R.id.activity_mesajlasma_sol_mesaj_mesaj_tarih);
            }

            private void bind(Mesaj mesaj) {
                mSolMesajIcerikTextView.setText(mesaj.getIcerik());
                mSolMesajTarihTextView.setText(getDateStringFormat(mesaj.getTarih()));
            }
        }

        @Override
        public int getItemViewType(int position) {
            Mesaj m = mMesajList.get(position);
            if (m.getAlici_id() == alici_id && m.isAlici_hoca_mi() == alici_hoca_mi) {
                return EXTRA_SAG_LAYOUT;
            } else {
                return EXTRA_SOL_LAYOUT;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case EXTRA_SAG_LAYOUT:
                    return new MesajSagLayout(LayoutInflater.from(getActivity())
                            .inflate(R.layout.activity_mesajlasma_sag_mesaj, parent, false));

                default:
                    return new MesajSolLayout(LayoutInflater.from(getActivity())
                            .inflate(R.layout.activity_mesajlasma_sol_mesaj, parent, false));


            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            switch (holder.getItemViewType()) {
                case EXTRA_SAG_LAYOUT:
                    Mesaj m = mMesajList.get(position);
                    MesajSagLayout mesajSagLayout = (MesajSagLayout) holder;
                    mesajSagLayout.bind(m);
                    break;
                case EXTRA_SOL_LAYOUT:
                    Mesaj m1 = mMesajList.get(position);
                    MesajSolLayout mesajSolLayout = (MesajSolLayout) holder;
                    mesajSolLayout.bind(m1);
                    break;

            }
        }

        @Override
        public int getItemCount() {
            return mMesajList.size();
        }
    }

    // tek basamaklı dakika saat ay gün gibi değerlerin başına 0 koyarak bir string değeri döndürüyor
    private String getDateStringFormat(Long secondsSince1970) {
        Date d = new Date(secondsSince1970 * 1000);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        // gün ve ay değerlerinin indexleri 0 olarak başlıyor yani ocak ayı için dönderilen değer 0 o yüzden +1 yapıyoruz
        return ((((cal.get(Calendar.DAY_OF_MONTH) + 1) > 9) ?
                (cal.get(Calendar.DAY_OF_MONTH) + 1) : "0" + (cal.get(Calendar.DAY_OF_MONTH) + 1))
                + "/" +
                (((cal.get(Calendar.MONTH) + 1) > 9) ? (cal.get(Calendar.MONTH) + 1) : "0" + (cal.get(Calendar.MONTH) + 1))
                + "/" +
                cal.get(Calendar.YEAR)
                + " - " +
                ((cal.get(Calendar.HOUR_OF_DAY) > 9) ? cal.get(Calendar.HOUR_OF_DAY) : "0" + cal.get(Calendar.HOUR_OF_DAY))
                + ":" +
                ((cal.get(Calendar.MINUTE) > 9) ? cal.get(Calendar.MINUTE) : "0" + cal.get(Calendar.MINUTE)));
    }


    private void init(View view) {
        mMesajlarRecylerView = (RecyclerView) view.findViewById(R.id.activity_mesajlasma_recycler_view);
        mMesajlarRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMesajIcerikEditText = (EditText) view.findViewById(R.id.activity_mesajlasma_mesaj_icerik_edit_text);
        mMesajGonderButton = (Button) view.findViewById(R.id.activity_mesajlasma_mesaj_gonder_button);
    }
}
