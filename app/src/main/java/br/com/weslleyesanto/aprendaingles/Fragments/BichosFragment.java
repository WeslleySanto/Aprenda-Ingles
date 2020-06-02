package br.com.weslleyesanto.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.com.weslleyesanto.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton imageButtonCao, imageButtonGato,
                        imageButtonLeao, imageButtonMacaco,
                        imageButtonOvelha, imageButtonVaca;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageButtonCao      = view.findViewById(R.id.imageButtonCao);
        imageButtonGato     = view.findViewById(R.id.imageButtonGato);
        imageButtonLeao     = view.findViewById(R.id.imageButtonLeao);
        imageButtonMacaco   = view.findViewById(R.id.imageButtonMacaco);
        imageButtonOvelha   = view.findViewById(R.id.imageButtonOvelha);
        imageButtonVaca     = view.findViewById(R.id.imageButtonVaca);

        imageButtonCao.setOnClickListener(this);
        imageButtonGato.setOnClickListener(this);
        imageButtonLeao.setOnClickListener(this);
        imageButtonMacaco.setOnClickListener(this);
        imageButtonOvelha.setOnClickListener(this);
        imageButtonVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButtonCao:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.imageButtonGato:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.imageButtonLeao:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.imageButtonMacaco:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.imageButtonOvelha:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.imageButtonVaca:
                //Passaremos o context do Activity
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            //add evento quando a musica finalizar
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
