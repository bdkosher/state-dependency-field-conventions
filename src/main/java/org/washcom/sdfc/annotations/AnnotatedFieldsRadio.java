package org.washcom.sdfc.annotations;

import java.util.Collections;
import java.util.Set;
import org.washcom.sdfc.Antenna;
import org.washcom.sdfc.PowerSupply;
import org.washcom.sdfc.Radio;

/**
 *
 * @author Joe
 */
public class AnnotatedFieldsRadio implements Radio {

    @State
    private int volumeLevel;

    @State
    private float station;

    @State
    private Set<Float> presets;

    @Dependency
    private final Antenna antenna;

    @Dependency
    private final PowerSupply powerSupply;

    public AnnotatedFieldsRadio(Antenna antenna, PowerSupply powerSupply) {
        this.antenna = antenna;
        this.powerSupply = powerSupply;
    }

    @Override
    public int getVolumeLevel() {
        return volumeLevel;
    }

    @Override
    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    @Override
    public float getStation() {
        return station;
    }

    @Override
    public void tuneStationUp() {
        station = Math.min(station + STATION_INC, STATION_MAX);
    }

    @Override
    public void tuneStationDown() {
        station = Math.max(station - STATION_INC, STATION_MIN);
    }

    @Override
    public Set<Float> getPresets() {
        return Collections.unmodifiableSet(presets);
    }

    @Override
    public void addPreset(float station) {
        presets.add(station);
    }

    @Override
    public void removePreset(float station) {
        presets.remove(station);
    }

}
