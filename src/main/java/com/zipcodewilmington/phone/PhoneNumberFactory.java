package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] arr = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < phoneNumberCount ; i++) {
            arr[i] = createRandomPhoneNumber();
        }
        return arr;
    }
    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        //String area, office, line;
        Integer area = RandomNumberFactory.createInteger(100,999);
        Integer office = RandomNumberFactory.createInteger(100,999);
        Integer line = RandomNumberFactory.createInteger(1000,9999);

        return createPhoneNumberSafely(area, office, line);
    }

    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        //(###)-###-####`
            String phoneNumberString = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumberString);
        }
        catch ( InvalidPhoneNumberFormatException e) {
            logger.info( phoneNumberString + " is not a valid phone number");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        //logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);

        return phoneNumber;
    }
}
