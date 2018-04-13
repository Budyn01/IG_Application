package pl.budyn.fetchingappforig.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lombok.Setter;
import pl.budyn.fetchingappforig.model.Market;
import pl.budyn.fetchingappforig.R;

public class MarketListAdapter extends RecyclerView.Adapter<MarketListViewHolder> {
    public static final String TAG = "MarketListAdapter";

    @Setter
    private List<Market> marketList;

    public MarketListAdapter(List<Market> marketList) {
        this.marketList = marketList;
    }

    @NonNull
    @Override
    public MarketListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_list_row, parent, false);
        return new MarketListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketListViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position + "set.");
        holder.getInstrumentNameTextView().setText(marketList.get(position).getInstrumentName());
        holder.getDisplayOfferTextView().setText(String.valueOf(marketList.get(position).getDisplayOffer()));
    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

}
