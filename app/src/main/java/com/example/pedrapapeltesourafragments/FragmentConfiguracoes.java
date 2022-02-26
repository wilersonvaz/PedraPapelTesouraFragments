package com.example.pedrapapeltesourafragments;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentConfiguracoes extends Fragment{
    private Button btnJogar;
    private RadioButton idJogador, idJogador2, nRodada1,nRodada3,nRodada5;
    private int nRodadas = 1;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        btnJogar = (Button) view.findViewById(R.id.btnJogar);
        idJogador = (RadioButton) view.findViewById(R.id.idJogador);
        idJogador2 = (RadioButton) view.findViewById(R.id.idJogador2);

        nRodada1 = (RadioButton) view.findViewById(R.id.nRodada1);
        nRodada3 = (RadioButton) view.findViewById(R.id.nRodada3);
        nRodada5 = (RadioButton) view.findViewById(R.id.nRodada5);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qtdJogadores = 1;

                if(!idJogador.isChecked()) qtdJogadores = 2;
                if(nRodada1.isChecked()) nRodadas = 1;
                if(nRodada3.isChecked()) nRodadas = 3;
                if(nRodada5.isChecked()) nRodadas = 5;

                Log.i("Log#","Você escolheu "+nRodadas+"! ");

                Toast.makeText(view.getContext(), "Você escolheu "+nRodadas+"! ", Toast.LENGTH_SHORT);

                Bundle bundle = new Bundle();
                bundle.putInt("qtdJogadores", qtdJogadores);
                bundle.putInt("nRodadas", nRodadas);

                

                if(qtdJogadores == 1){
//                    Intent telaContra1 =new Intent(getApplicationContext(), JogarContraUm.class);
//                    telaContra1.putExtras(bundle);
//                    startActivity(telaContra1);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new FragmentJogarContraUm());
                    fragmentTransaction.commit();
    
                }else{
//                    Intent telaContra2 =new Intent(getApplicationContext(), JogarContraDois.class);
//                    telaContra2.putExtras(bundle);
//                    startActivity(telaContra2);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new FragmentJogarContraDois());
                    fragmentTransaction.commit();

                }

            }
        });

        
        return view;
    
    }




}