package org.washcom.sdfc.privatedeps;

import java.util.HashSet;
import java.util.Set;
import org.washcom.sdfc.Antenna;
import org.washcom.sdfc.PowerSupply;

/**
 *
 * @author Joe
 */
public class Radio {

    private int volumeLevel;
    private float station;
    private final Set<Float> presets = new HashSet<>();
    private final Dependencies dependencies;

    public Radio(Antenna antenna, PowerSupply powerSupply) {
        dependencies = new Dependencies(antenna, powerSupply);
    }
    
    public void doSomething() {
        dependencies.antenna.receive(dependencies.powerSupply);
    }
}

class Dependencies {

    final Antenna antenna;
    final PowerSupply powerSupply;

    public Dependencies(Antenna antenna, PowerSupply powerSupply) {
        this.antenna = antenna;
        this.powerSupply = powerSupply;
    }
}
