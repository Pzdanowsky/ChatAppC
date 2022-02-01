package Services.Factors;

import Objects.MessageHbox;
import Services.HBOX;

public class MessageBoxFactor extends HboxFactory{
    @Override
    public HBOX createHbox() {
        return new MessageHbox();
    }
}
