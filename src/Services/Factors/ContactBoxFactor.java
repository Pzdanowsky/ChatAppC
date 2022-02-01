package Services.Factors;

import Objects.ContactHbox;
import Services.HBOX;

public class ContactBoxFactor extends HboxFactory{
    @Override
    public HBOX createHbox() {
        return new ContactHbox();
    }
}
