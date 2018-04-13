package pl.budyn.fetchingappforig.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import lombok.Getter;
import pl.budyn.fetchingappforig.R;

public class MarketListViewHolder extends RecyclerView.ViewHolder {
    @Getter
    private final TextView instrumentNameTextView;
    @Getter
    private final TextView displayOfferTextView;

    public MarketListViewHolder(View view) {
        super(view);
        instrumentNameTextView = view.findViewById(R.id.instrument_name);
        displayOfferTextView = view.findViewById(R.id.display_offer);
    }
}

