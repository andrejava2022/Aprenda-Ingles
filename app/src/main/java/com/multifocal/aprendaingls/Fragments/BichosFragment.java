package com.multifocal.aprendaingls.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.multifocal.aprendaingls.R;


public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageView imageCao, imageGato, imageLeao, imageMacaco, imageOvelha, imageVaca;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageCao = view.findViewById(R.id.imageCao);
        imageGato = view.findViewById(R.id.imageGato);
        imageLeao = view.findViewById(R.id.imageLeao);
        imageMacaco = view.findViewById(R.id.imageMacaco);
        imageOvelha = view.findViewById(R.id.imageOvelha);
        imageVaca = view.findViewById(R.id.imageVaca);

        //Aplica eventos de click
        imageCao.setOnClickListener(this);
        imageGato.setOnClickListener(this);
        imageLeao.setOnClickListener(this);
        imageMacaco.setOnClickListener(this);
        imageOvelha.setOnClickListener(this);
        imageVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;

            case R.id.imageGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;

            case R.id.imageLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;

            case R.id.imageMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;

            case R.id.imageOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;

            case R.id.imageVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if( mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}