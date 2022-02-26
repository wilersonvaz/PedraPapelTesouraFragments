package com.example.pedrapapeltesourafragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FragmentJogarContraUm extends Fragment {
    private ImageButton pedra, tesoura, papel;
    public static ImageView imagem, chiquinhoImg, resultadoImg;
    private TextView textoResultado;
    private Drawable drawable;
    int rodadas;
    int cave;
    int chiquinho;
    int empate;
    int nRodadas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jogar_contra_um, container, false);

        pedra = (ImageButton) view.findViewById(R.id.pedra);
        tesoura = (ImageButton) view.findViewById(R.id.tesoura);
        papel = (ImageButton) view.findViewById(R.id.papel);
        imagem = (ImageView) view.findViewById(R.id.imagem);
        chiquinhoImg = (ImageView) view.findViewById(R.id.chiquinho);
        resultadoImg = (ImageView) view.findViewById(R.id.resultadoImg);
        textoResultado = (TextView) view.findViewById(R.id.textoResultado);

        textoResultado.setText("Rodada: 0\nVocê: 0\nChiquinho: 0\nEmpates: 0");

        rodadas = 0;
        cave = 0;
        chiquinho = 0;
        empate = 0;

        //Trecho alterado para atender sà especificações de mudança de tela
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle != null){
            nRodadas = bundle.getInt("nRodadas");
        }else{
            nRodadas = 0;
        }

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar(0);
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar(1);
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogar(2);
            }
        });

        return view;

    }



    private void jogar(int jogUsuario) {
        try {

            rodadas++;
            Random jogo = new Random();
            int valor = jogo.nextInt(3);

            switch (jogUsuario){
                case 0:
                    switch (valor){
                        case 0:
                            mudaImagem(chiquinhoImg, 7);
                            mudaImagem(imagem, 7);
                            mudaImagem(resultadoImg, 4);
                            empate++;
                            break;
                        case 1:
                            mudaImagem(chiquinhoImg, 9);
                            mudaImagem(imagem, 7);
                            mudaImagem(resultadoImg, 1);
                            cave++;
                            break;
                        case 2:
                            mudaImagem(chiquinhoImg, 8);
                            mudaImagem(imagem, 7);
                            mudaImagem(resultadoImg, 2);
                            chiquinho++;
                            break;
                    }
                    break;

                case 1:

                    switch (valor){
                        case 0:
                            mudaImagem(chiquinhoImg, 7);
                            mudaImagem(imagem, 9);
                            mudaImagem(resultadoImg, 2);
                            chiquinho++;
                            break;

                        case 1:
                            mudaImagem(chiquinhoImg, 9);
                            mudaImagem(imagem, 9);
                            mudaImagem(resultadoImg, 4);
                            empate++;
                            break;
                        case 2:
                            mudaImagem(chiquinhoImg, 8);
                            mudaImagem(imagem, 9);
                            mudaImagem(resultadoImg, 1);
                            cave++;
                            break;
                    }
                    break;

                case 2:
                    switch (valor){
                        case 0:
                            mudaImagem(chiquinhoImg, 7);
                            mudaImagem(imagem, 8);
                            mudaImagem(resultadoImg, 1);
                            cave++;
                            break;
                        case 1:
                            mudaImagem(chiquinhoImg, 9);
                            mudaImagem(imagem, 8);
                            mudaImagem(resultadoImg, 2);
                            chiquinho++;
                            break;
                        case 2:
                            mudaImagem(chiquinhoImg, 8);
                            mudaImagem(imagem, 8);
                            mudaImagem(resultadoImg, 4);
                            empate++;
                            break;
                    }
                    break;

            }

            String resultado = "";
            resultado = "Rodada: "+String.valueOf(rodadas)+"\nVocê: "+String.valueOf(cave)+"\nChiquinho: "+String.valueOf(chiquinho)+"\nEmpates: "+empate;
            textoResultado.setText(resultado);
            if(rodadas == nRodadas){
                Thread.currentThread().sleep(2000);
                Bundle bundle = new Bundle();
                bundle.putInt("rodadas", rodadas);
                bundle.putInt("cave", cave);
                bundle.putInt("chiquinho", chiquinho);
                bundle.putInt("mariazinha", -1);
                bundle.putInt("empate", empate);

                // Intent main =new Intent(getApplicationContext(), MainActivity.class);
                // main.putExtras(bundle);
                // startActivity(main);
            }
        }catch (Exception e){
            System.out.println("Erro: "+e);
        }
    }


    public void mudaImagem(ImageView image, int img){
        try{

            int[] imagensIds = {

                    R.drawable.cave_man, //0
                    R.drawable.cave_man_feliz, //1
                    R.drawable.cave_man_bravo, //2
                    R.drawable.cave_man_in_love, //3
                    R.drawable.cave_man_empate, //4
                    R.drawable.chico, //5
                    R.drawable.maria, //6
                    R.drawable.pedra_big, //7
                    R.drawable.papel_big, //8
                    R.drawable.tesoura_big, //9
                    R.drawable.exclamation //10
            };

            image.setImageResource(imagensIds[img]);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    

}