package org.washcom.sdfc;

import java.io.InputStream;

/**
 *
 * @author Joe
 */
public interface Antenna {
    
    InputStream receive(PowerSupply supply);
    
}
