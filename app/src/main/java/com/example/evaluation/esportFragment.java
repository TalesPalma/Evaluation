package com.example.evaluation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class esportFragment extends Fragment {



    private String mParam1;
    private String mParam2;

    public esportFragment() {



    }

    public static esportFragment newInstance(String param1, String param2) {
        esportFragment fragment = new esportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_esport, container, false);
        EditText editText1 = view.findViewById(R.id.inputEDT1);
        EditText editText2 = view.findViewById(R.id.inputEDT2);
        EditText editText3 = view.findViewById(R.id.inputEDT3);
        WebView webView = view.findViewById(R.id.grafico);

        webView.getSettings().setJavaScriptEnabled(true);

        String codigoJs = "\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "        google.charts.load('current', {'packages':['corechart']});\n" +
                "        google.charts.setOnLoadCallback(drawChart);\n" +
                "        var data;\n" +
                "        var options = {\n" +
                "            width: 415,\n" +
                "            height:184,\n" +
                "            backgroundColor: '#82a2ff', // Cor de fundo mais clara\n" +
                "            titleTextStyle: {\n" +
                "                color: '#FFFFFF'\n" +
                "            },\n" +
                "            hAxis: {\n" +
                "                textStyle: {\n" +
                "                    color: '#FFFFFF'\n" +
                "                }\n" +
                "            },\n" +
                "            vAxis: {\n" +
                "                textStyle: {\n" +
                "                    color: '#FFFFFF'\n" +
                "                },\n" +
                "                gridlines: {\n" +
                "                    color: 'transparent'\n" +
                "                }\n" +
                "            },\n" +
                "            annotations: {\n" +
                "                textStyle: {\n" +
                "                    color: '#FFFFFF'\n" +
                "                }\n" +
                "            },\n" +
                "            series: {\n" +
                "                0: { color: '#FF5656' },        // Supino - Vermelho\n" +
                "                1: { color: '#fff90c' },      // Terra - Verde\n" +
                "                2: { color: '#00ff58' }        // Agachamento - Azul\n" +
                "            }\n" +
                "        };\n" +
                "        function drawChart() {\n" +
                "            data = new google.visualization.DataTable();\n" +
                "            data.addColumn('string', 'Category');\n" +
                "            data.addColumn('number', 'Supino');\n" +
                "            data.addColumn('number', 'Terra');\n" +
                "            data.addColumn('number', 'Agachamento');\n" +
                "            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n" +
                "            chart.draw(data, options);\n" +
                "        }\n" +
                "        function addDataToChart(supino, terra, agachamento) {\n" +
                "            data.addRow(['', supino, terra, agachamento]);\n" +
                "            var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));\n" +
                "            chart.draw(data, options);\n" +
                "        }\n" +
                "    </script>\n" +
                "<style>"+
                "body{ background-color:#5271ff;}"+
                "</style>"+
                "</head>\n" +
                "<body>\n" +
                "    <div id=\"chart_div\"></div>\n" +
                "</body>\n" +
                "</html>";

        webView.loadDataWithBaseURL(null, codigoJs, "text/html", "UTF-8", null);

        view.findViewById(R.id.buttoSalvar).setOnClickListener(v -> {
            Toast toast;
            String input1 = editText1.getText().toString();
            String input2 = editText2.getText().toString();
            String input3 = editText3.getText().toString();

            if (!input1.isEmpty() && !input2.isEmpty() && !input3.isEmpty()) {
                webView.loadUrl("javascript:document.getElementById('dataDisplay').innerHTML = " +
                        "'Dados: " + input1 + ", " + input2 + ", " + input3 + "';");


                webView.loadUrl("javascript:addDataToChart(" + input1 + ", " + input2 + ", " + input3 + ");");

                toast = Toast.makeText(requireContext(), "Gráfico atualizado com sucesso!!", Toast.LENGTH_SHORT);
            } else {
                toast = Toast.makeText(requireContext(), "Complete todos os campos por favor!!", Toast.LENGTH_SHORT);
            }
            toast.show();
        });







        return view;
    }
}