package com.juhao666.design.pattern.mediator.mediator;

import com.juhao666.design.pattern.mediator.colleague.Country;
import com.juhao666.design.pattern.mediator.colleague.UK;
import com.juhao666.design.pattern.mediator.colleague.USA;

public class UnitedNationsSecurityCouncil extends UnitedNations {
    private USA usa;
    private UK uk;

    public void setUSA(USA usa) {
        this.usa = usa;
    }

    public void setUK(UK uk) {
        this.uk = uk;
    }

    @Override
    public void declare(String message, Country country) {
        if (country == this.usa) {
            this.uk.outputMessage(message);
        } else if (country == this.uk) {
            this.usa.outputMessage(message);
        }
    }
}
