package com.example.tarea3_fragmentbasico;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoTextView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoTextView extends Fragment {

    private TextView textView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoTextView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoTextView.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoTextView newInstance(String param1 , String param2) {
        FragmentoTextView fragment = new FragmentoTextView ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM1 , param1 );
        args.putString ( ARG_PARAM2 , param2 );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño del fragmento
        return inflater.inflate(R.layout.fragment_fragmento_text_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar el TextView
        textView = view.findViewById(R.id.textViewFragment);
    }

    public void actualizarTexto(String texto) {
        if (textView != null) {
            textView.setText(texto); // Actualiza el texto
        } else {
            // Log para debug si textView es null
            android.util.Log.e("FragmentoTextView", "TextView es null, no se puede actualizar el texto.");
        }
    }
}