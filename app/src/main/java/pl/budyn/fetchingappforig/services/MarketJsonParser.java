package pl.budyn.fetchingappforig.services;

import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import pl.budyn.fetchingappforig.model.Market;

public class MarketJsonParser {

    private static final String TAG = MarketJsonParser.class.getName();

    private JsonReader jsonReader;

    @Getter
    private List<Market> markets = new ArrayList<>();

    public MarketJsonParser(JsonReader jsonReader) throws IOException {
        this.jsonReader = jsonReader;
        parse();
    }

    private void parse() throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String key = jsonReader.nextName();
            if (key.equals("markets")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    readMarketObject();
                }
                break;
            }
        }
    }

    private void readMarketObject() throws IOException {
        Market market = new Market();
        jsonReader.beginObject();
        jsonReader.nextName();
        market.setInstrumentName(jsonReader.nextString());
        jsonReader.nextName();
        market.setVersion(Integer.valueOf(jsonReader.nextString()));
        jsonReader.nextName();
        market.setDisplayPeriod(jsonReader.nextString());
        jsonReader.nextName();
        market.setEpic(jsonReader.nextString());
        jsonReader.nextName();
        market.setExchangeId(jsonReader.nextString());
        jsonReader.nextName();
        market.setDisplayBid(Double.valueOf(jsonReader.nextString()));
        jsonReader.nextName();
        market.setDisplayOffer(Double.valueOf(jsonReader.nextString()));
        jsonReader.nextName();
        market.setUpdateTime(jsonReader.nextLong());
        jsonReader.nextName();
        market.setNetChange(Double.valueOf(jsonReader.nextString()));
        jsonReader.nextName();
        market.setScaled(jsonReader.nextBoolean());
        jsonReader.nextName();
        market.setTimezoneOffset(jsonReader.nextInt());
        jsonReader.endObject();
        Log.i(TAG, market.toString());
        markets.add(market);
    }

}
