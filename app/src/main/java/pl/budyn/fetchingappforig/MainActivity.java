package pl.budyn.fetchingappforig;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pl.budyn.fetchingappforig.view.MarketLanguageChangeSpinner;
import pl.budyn.fetchingappforig.R;
import pl.budyn.fetchingappforig.model.Market;
import pl.budyn.fetchingappforig.view.MarketListAdapter;
import pl.budyn.fetchingappforig.services.market_list.MarketListGetTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<Market> markets = new ArrayList<>();
    private RecyclerView recyclerView;
    private MarketListAdapter marketListAdapter;
    private MarketListGetTask task;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        setupSpinner();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        marketListAdapter = new MarketListAdapter(markets);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(marketListAdapter);
    }


    private void setupSpinner() {
        spinner = (Spinner) findViewById(R.id.country_spinner);
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new MarketLanguageChangeSpinner(markets, marketListAdapter));
    }




}
