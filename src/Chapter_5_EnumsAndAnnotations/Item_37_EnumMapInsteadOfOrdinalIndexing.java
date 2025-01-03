package Chapter_5_EnumsAndAnnotations;

import java.util.EnumMap;

/*
Avoid Ordinal Indexing:

It is brittle, error-prone, and difficult to maintain.
Use EnumMap for Enum-Indexed Data:

It is type-safe, efficient, and readable.
Leverage EnumMap for Complex Data:

Nested EnumMaps and storing objects as values are powerful use cases.
By using EnumMap, you can write cleaner, safer, and more maintainable code when working with enums.
 */
public class Item_37_EnumMapInsteadOfOrdinalIndexing {
    public enum Phase {SOLID, LIQUID, GAS}

    public enum Transition {MELT, FREEZE, BOIL, CONDENSE}

    public static void main(String[] args) {
        EnumMap<Phase, EnumMap<Transition, Phase>> phaseTransitions = new EnumMap<>(Phase.class);

        for (Phase phase : Phase.values()) {
            phaseTransitions.put(phase, new EnumMap<>(Transition.class));
        }

        phaseTransitions.get(Phase.SOLID).put(Transition.MELT, Phase.LIQUID);
        phaseTransitions.get(Phase.LIQUID).put(Transition.BOIL, Phase.GAS);

        System.out.println(STR."Solid to Liquid: \{phaseTransitions.get(Phase.SOLID).get(Transition.MELT)}");
    }
}
