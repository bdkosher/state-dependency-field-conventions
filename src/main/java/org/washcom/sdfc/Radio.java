package org.washcom.sdfc;

import java.util.Set;

/**
 * Demonstrates a class containing state and dependency fields.
 *
 * @author Joe
 */
public interface Radio {
    
    static final float DEFAULT_STATION = 100.9f;
    
    /** 
     * The minimum volume level.
     */
    static final int VOLUME_MAX = 10;
    
    /** 
     * The maximum volume level.
     */
    static final int VOLUME_MIN = 0; 

    /** 
     * The maximum supported station frequency.
     */
    static final float STATION_MAX = 107.9f;
    
    /** 
     * The maximum supported station frequency.
     */
    static final float STATION_MIN = 88.1f;
    
    /** 
     * The increment that stations can be tuned up or down.
     */
    static final float STATION_INC = 0.2f;

    int getVolumeLevel();

    void setVolumeLevel(int volumeLevel);

    float getStation();

    void tuneStationUp();

    void tuneStationDown();

    Set<Float> getPresets();

    void addPreset(float station);

    void removePreset(float station);

}
