package pl.budyn.fetchingappforig.services.market_list;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import pl.budyn.fetchingappforig.model.Market;
import pl.budyn.fetchingappforig.services.MarketJsonParser;

public abstract class MarketListGetTask extends AsyncTask<Void, Void, List<Market>> {

    private static final String TAG = "MarketListGetTask";

    private List<Market> marketList;
    private String url;

    @Override
    protected List<Market> doInBackground(Void... voids) {
        try {
            URL address = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) address.openConnection();
            if(connection.getResponseCode() != 200) throw new Exception();
            InputStream responseBody = connection.getInputStream();
            InputStreamReader response = new InputStreamReader(responseBody);
            JsonReader jsonReader = new JsonReader(response);
            marketList = new MarketJsonParser(jsonReader).getMarkets();
            jsonReader.close();
            connection.disconnect();
            Log.d(TAG, "doInBackground: task executed correctly!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marketList;
    }

    void setUrl(String url) {
        this.url = url;
    }

}
