package pl.budyn.fetchingappforig.view;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import pl.budyn.fetchingappforig.model.Market;
import pl.budyn.fetchingappforig.view.MarketListAdapter;
import pl.budyn.fetchingappforig.services.market_list.MarketListGetTask;
import pl.budyn.fetchingappforig.services.market_list.MarketListGetTaskDE;
import pl.budyn.fetchingappforig.services.market_list.MarketListGetTaskFR;
import pl.budyn.fetchingappforig.services.market_list.MarketListGetTaskUK;

public class MarketLanguageChangeSpinner implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MarketLanguageChange";
    private List<Market> marketList;
    private MarketListAdapter adapter;


    public MarketLanguageChangeSpinner(List<Market> marketList, MarketListAdapter adapter) {
        this.marketList = marketList;
        this.adapter = adapter;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemSelected: " + parent.getItemAtPosition(position) + position);
        MarketListGetTask task;
        switch (position) {
            case 1:
                task = new MarketListGetTaskDE();
                break;
            case 2:
                task = new MarketListGetTaskFR();
                break;
            default:
                task = new MarketListGetTaskUK();
                break;
        }
        getData(task);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void getData(MarketListGetTask task) {
        try {
            marketList.clear();
            marketList.addAll(task.execute().get());
            Collections.sort(marketList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }
}
