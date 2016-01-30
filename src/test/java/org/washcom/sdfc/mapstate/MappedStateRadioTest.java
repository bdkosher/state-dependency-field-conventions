package org.washcom.sdfc.mapstate;

import org.washcom.sdfc.Radio;
import org.washcom.sdfc.RadioTest;

/**
 *
 * @author Joe
 */
public class MappedStateRadioTest extends RadioTest {

    @Override
    public Radio radio() {
        return new MappedStateRadio(null, null);
    }
    
}
