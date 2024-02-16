package LogicSimulator;

import java.util.Arrays;


abstract class Gate {
    abstract int Logic(int[] inputPins);
}

class AND extends Gate {

    int Logic(int[] inputPins) {
        for (int pin : inputPins) {
            if (pin == 0)
                return 0;
        }
        return 1;
    }
}

class OR extends Gate {

    int Logic(int[] inputPins) {
        for (int pin : inputPins) {
            if (pin == 1)
                return 1;
        }
        return 0;
    }
}

class XOR extends Gate {

    int Logic(int[] inputPins) {
        int sum = Arrays.stream(inputPins).sum();
        return sum % 2 == 1 ? 1 : 0;
    }
}

class NAND extends Gate {

    int Logic(int[] inputPins) {
        for (int pin : inputPins) {
            if (pin == 0)
                return 1;
        }
        return 0;
    }
}

class NOR extends Gate {
    int Logic(int[] inputPins) {
        for (int pin : inputPins) {
            if (pin == 1)
                return 0;
        }
        return 1;
    }
}

class NOT extends Gate {
    int Logic(int[] inputPins) {
        return inputPins[0] == 0 ? 1 : 0;
    }
}

class Mux extends Gate {
    int Logic(int[] inputPins) {
        int dataInput0 = inputPins[0];
        int dataInput1 = inputPins[1];
        int controlInput = inputPins[2];
        if (controlInput == 0) {
            return dataInput0;
        } else {
            return dataInput1;
        }
    }
}