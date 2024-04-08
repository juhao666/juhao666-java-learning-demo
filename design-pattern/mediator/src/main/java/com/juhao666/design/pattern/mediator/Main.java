package com.juhao666.design.pattern.mediator;

import com.juhao666.design.pattern.mediator.colleague.UK;
import com.juhao666.design.pattern.mediator.colleague.USA;
import com.juhao666.design.pattern.mediator.mediator.UnitedNationsSecurityCouncil;

public class Main {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unsc = new UnitedNationsSecurityCouncil();

        USA usa = new USA(unsc);
        UK uk = new UK(unsc);

        unsc.setUSA(usa);
        unsc.setUK(uk);

        usa.declare("I will launch war III, follow me!");
        uk.declare("Go away.");
    }
}
