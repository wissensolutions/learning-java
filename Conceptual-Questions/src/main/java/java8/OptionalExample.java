package java8;

import java.util.Optional;

/**
 * Optional
 * 1. Oracle has introduced an optional field to avoid ugly code of null checks
 * 2. When we are not sure about field value, Use optional.ofNullable
 * 3. To print value from this optional, use ifPresent, map or flatMap
 */
public class OptionalExample {

    public static void main(String[] args){
        String nonEmptyString = "Test";
        String emptyString = "";
        String nullableString = null;

        //With Optional.of
        Optional<String> optionalForNonEmptyString = Optional.of(nonEmptyString);
        Optional<String> optionalForEmptyString = Optional.of(emptyString);
        System.out.println("Value from Non Empty String = "+optionalForNonEmptyString.get());
        System.out.println("Value from  Empty String = "+optionalForEmptyString.get());
        //Optional.of cannot be used for null value field
        try {
            Optional<String> optionalForNullableString = Optional.of(nullableString);
        }catch (NullPointerException ex){}

        //With Optional.ofNullable
         optionalForNonEmptyString = Optional.ofNullable(nonEmptyString);
         optionalForEmptyString = Optional.ofNullable(emptyString);
        Optional<String> optionalForNullableString = Optional.ofNullable(nullableString);
        System.out.println("Value from Non Empty String = "+optionalForNonEmptyString.get());
        System.out.println("Value from  Empty String = "+optionalForEmptyString.get());

        //get operation on Nullable field can yield to null poiter. So use with if present
        optionalForNullableString.ifPresent(value->System.out.println("Value from  nullable String = "+value));

        //Map on optional
        optionalForNonEmptyString.map(value-> {
            System.out.println("Value from Non Empty String = "+value);
            return value;
                });
        optionalForEmptyString.map(value-> {
            System.out.println("Value from  Empty String = "+value);
            return value;
        });
        // This will not be printed
        optionalForNullableString.map(value-> {
            System.out.println("Value from nullable String = "+value);
            return value;
        });




    }
}
