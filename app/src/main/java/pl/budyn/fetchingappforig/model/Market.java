package pl.budyn.fetchingappforig.model;


import android.support.annotation.NonNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Market implements Comparable<Market> {
    private String instrumentName;
    private int version;
    private String displayPeriod;
    private String epic;
    private String exchangeId;
    private double displayBid;
    private double displayOffer;
    private Long updateTime;
    private double netChange;
    private boolean scaled;
    private int timezoneOffset;

    @Override
    public int compareTo(@NonNull Market o) {
        return instrumentName.compareTo(o.instrumentName);
    }
}
