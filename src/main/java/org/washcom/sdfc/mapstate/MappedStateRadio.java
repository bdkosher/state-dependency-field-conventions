package org.washcom.sdfc.mapstate;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.washcom.sdfc.Antenna;
import org.washcom.sdfc.PowerSupply;
import org.washcom.sdfc.Radio;

/**
 *
 * @author Joe
 */
public class MappedStateRadio implements Radio {

    private enum StateProperty {

        VOLUME_LEVEL, STATION, PRESETS
    }
    private final Map<StateProperty, Object> state = new EnumMap<>(StateProperty.class);

    private final Antenna antenna;
    private final PowerSupply powerSupply;

    public MappedStateRadio(Antenna antenna, PowerSupply powerSupply) {
        this.antenna = antenna;
        this.powerSupply = powerSupply;
    }

    @Override
    public int getVolumeLevel() {
        return (int) state.getOrDefault(StateProperty.VOLUME_LEVEL, -1);
    }

    @Override
    public void setVolumeLevel(int volumeLevel) {
        state.put(StateProperty.VOLUME_LEVEL, volumeLevel);
    }

    @Override
    public float getStation() {
        return (float) state.getOrDefault(StateProperty.STATION, -1f);
    }

    @Override
    public void tuneStationUp() {
        state.computeIfPresent(StateProperty.STATION,
                (k, station) -> min((Float) station + STATION_INC, STATION_MAX));
    }

    @Override
    public void tuneStationDown() {
        state.computeIfPresent(StateProperty.STATION,
                (k, station) -> max((Float) station - STATION_INC, STATION_MIN));
    }

    private Set<Float> presets() {
        return (Set<Float>) state.getOrDefault(StateProperty.PRESETS, new HashSet());
    }

    @Override
    public Set<Float> getPresets() {
        return Collections.unmodifiableSet(presets());
    }

    @Override
    public void addPreset(float station) {
        presets().add(station);
    }

    @Override
    public void removePreset(float station) {
        presets().remove(station);
    }

}
