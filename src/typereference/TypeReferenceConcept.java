package typereference;

import java.util.ArrayList;
import java.util.List;

public class TypeReferenceConcept {

    public static void main(String[] args) {

        // Without using TYPE REFERENCE is necessary specify the type again.
        List<String> arr2 = new ArrayList<String>();

        // Using TYPE REFERENCE you don't need to repeat the type
        List<String> arr = new ArrayList<>();

    }

}