package org.washcom.sdfc;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Joe
 */
public abstract class RadioTest {
    
    public abstract Radio radio();
    
    @Test
    public void testVolumeLevel() {
        System.out.println("testing volume level");
        Radio radio = radio();
        for (int i = 0; i < 100; ++i) {
            radio.setVolumeLevel(i);
            assertEquals(i, radio.getVolumeLevel());
        }
    }
}
