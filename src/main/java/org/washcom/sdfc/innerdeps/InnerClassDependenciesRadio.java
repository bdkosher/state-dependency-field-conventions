package org.washcom.sdfc.innerdeps;

import java.util.HashSet;
import java.util.Set;
import org.washcom.sdfc.Antenna;
import org.washcom.sdfc.PowerSupply;

/**
 *
 * @author Joe
 */
public class InnerClassDependenciesRadio {

    private int volumeLevel;
    private float station;
    private final Set<Float> presets = new HashSet<>();
    
    private final Dependencies dependencies = new Dependencies();
    private class Dependencies {
        Antenna antenna;
        PowerSupply powerSupply;
    }

    public InnerClassDependenciesRadio(Antenna antenna, PowerSupply powerSupply) {
        dependencies.antenna = antenna;
        dependencies.powerSupply = powerSupply;
    }
    
    
}
