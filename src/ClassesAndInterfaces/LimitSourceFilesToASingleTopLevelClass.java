package ClassesAndInterfaces;

/*
What Happens When You Have Multiple Top-Level Classes in a Single File?

Only one top-level class can be public, and it must have the same name as the file.
Other top-level classes will have package-private (default) visibility.
This can lead to:
Unintended Accessibility: Classes might be accessed inappropriately from other parts of the package.
Ambiguity: It becomes unclear which class is the main focus of the file.
Compilation Issues: Different compilers or tools may handle multiple classes in a single file inconsistently.
Advantages of a Single Top-Level Class per File

Clarity: Each file represents a single, cohesive unit of functionality.
Ease of Maintenance: Finding and editing a specific class is straightforward.
Avoids Naming Conflicts: Each file has a unique name tied to its public class.
Tool Compatibility: IDEs and build tools often assume one class per file.
Exceptions to the Rule

Helper Classes: If a class is tightly coupled to another class and is not intended to be reused, consider making it a static member class within the primary class.
Enums or Interfaces: Small enums or interfaces used only by the top-level class can be nested within it.

 */
public class LimitSourceFilesToASingleTopLevelClass {
}

// Two classes defined in one file. Don't ever do this!
class Utensil {
    static final String NAME = "pot";
}

class Dessert {
    static final String NAME = "pie";
}

// Static member classes instead of multiple top-level classes
class Test {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

    private static class Utensil {
        static final String NAME = "pan";
    }

    private static class Dessert {
        static final String NAME = "cake";
    }
}