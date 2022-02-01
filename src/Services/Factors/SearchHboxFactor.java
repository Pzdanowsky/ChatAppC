package Services.Factors;

import Objects.SearchHbox;
import Services.Factors.HboxFactory;
import Services.HBOX;

public class SearchHboxFactor extends HboxFactory {


    @Override
    public HBOX createHbox() {
        return new SearchHbox();
    }
}
