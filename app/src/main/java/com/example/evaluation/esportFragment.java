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
        webView.loadUrl("https://developers.google.com/chart");
        String htmldata = "<html><body><div id='chard_div'</div></body></html>";
        webView.loadData(htmldata,"text/html","UTF-8");
        String codigoJs="<html>\n" +
                "  <head>\n" +
                "    <!--Load the AJAX API-->\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "\t\t\n" +
                "      // Load the Visualization API and the corechart package.\n" +
                "      google.charts.load('current', {'packages':['corechart']});\n" +
                "\n" +
                "      // Set a callback to run when the Google Visualization API is loaded.\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "      // Callback that creates and populates a data table,\n" +
                "      // instantiates the pie chart, passes in the data and\n" +
                "      // draws it.\n" +
                "      function drawChart() {\n" +
                "\n" +
                "        // Create the data table.\n" +
                "        var data = new google.visualization.DataTable();\n" +
                "        data.addColumn('string', 'Topping');\n" +
                "        data.addColumn('number', 'Slices');\n" +
                "        data.addRows([\n" +
                "          ['Mushrooms', 3],\n" +
                "          ['Onions', 1],\n" +
                "          ['Olives', 1],\n" +
                "          ['Zucchini', 1],\n" +
                "          ['Pepperoni', 2]\n" +
                "        ]);\n" +
                "\n" +
                "        // Set chart options\n" +
                "        var options = {'title':'How Much Pizza I Ate Last Night',\n" +
                "                       'width':400,\n" +
                "                       'height':300,\n" +
                "                      'backgroundColor': '#5271ff'\n" +
                "        };\n" +
                "\n" +
                "        // Instantiate and draw our chart, passing in some options.\n" +
                "        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n" +
                "        chart.draw(data, options);\n" +
                "      }\n" +
                "    </script>  \n" +
                "\n" +
                "\n" +
                "  <style>\n" +
                "  body{\n" +
                "    background-color:#5271ff;\n" +
                "  }\n" +
                "  </style>\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "  </head>\n" +
                "  \n" +
                "  <body>\n" +
                "    <!--Div that will hold the pie chart-->\n" +
                "    <div id=\"chart_div\"></div>\n" +
                "  </body>\n" +
                "</html>";
        webView.loadDataWithBaseURL(null,codigoJs,"text/html","UTF-8",null);




        view.findViewById(R.id.buttoSalvar).setOnClickListener(v->{
            Toast toast;
            String input1 = editText1.getText().toString();
            String input2 = editText2.getText().toString();
            String input3 = editText3.getText().toString();

            if(!input1.isEmpty() && !input2.isEmpty() && !input3.isEmpty()){
                toast = Toast.makeText(this.getContext(),"Informações salvar com sucesso!!",Toast.LENGTH_SHORT);
            }else{
                toast = Toast.makeText(this.getContext(),"Complete todos os campos por favor!!",Toast.LENGTH_SHORT);
            }
            toast.show();
        });





        return view;
    }
}