package Utils;

import implementation.normal.Dictionary;
import implementation.normal.MultipleDictionary;
import implementation.normal.Set;
import model.IDictionary;
import model.IMultipleDictionary;
import model.ISet;

public class MultipleDictionaryUtils {

    /**
     * IN = Pertenece
     * @param boolean
     * @return
     */
    private static boolean in(ISet a, int element) {
        ISet aux = new Set();
        boolean exists = false;
        while (!a.isEmpty()) {
            int value = a.choose();
            if (element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }

    public static boolean symmetry(IDictionary dictionary) {
        ISet keys = dictionary.getKeys();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            int value = dictionary.getValue(key);
            if(!in(dictionary.getKeys(), value)) {
                return false;
            }
            if(dictionary.getValue(value) != key) {
                return false;
            }
            keys.remove(key);
        }
        return true;
    }


    public static boolean isDependent(MultipleDictionary dictionary) {
        MultipleDictionary copy = dictionary.copy();
        MultipleDictionary aux = dictionary.copy();

        ISet keys = dictionary.getKeys();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            ISet keyValues = dictionary.getValues(key);

            while(!keyValues.isEmpty()) {
                int value = keyValues.choose();
                int nextKeys = keys.choose();
                ISet nextKeyValues = dictionary.getValues(nextKeys);

                if(!in(nextKeyValues, value)) {
                    return false;
                }
                keyValues.remove(value);
            }

            keys.remove(key);
        }
        return true;
    }

}
