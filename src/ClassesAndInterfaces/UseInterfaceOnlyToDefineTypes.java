package ClassesAndInterfaces;

/*
In summary, interfaces should be used only to define types. They should not
be used merely to export constants.
 */
public class UseInterfaceOnlyToDefineTypes {
}

// Constant interface anti-pattern - DO NOT USE!!!
interface PhysicalConstantsDoNotUse {
    // Avogadro's number (1/mol)
    static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    // Boltzmann constant (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    // Mass of the electron (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}

class PhysicalConstants {
    private PhysicalConstants() {
    } // Prevents instantiation

    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONST = 1.380_648_52e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}