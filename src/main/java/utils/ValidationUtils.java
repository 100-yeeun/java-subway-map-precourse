package utils;

import java.util.List;

public class ValidationUtils {
    private ValidationUtils() { }

    public static int validateSelection(String selection, List<String> exitSigns, int start, int length) {
        try {
            int intSelection = Integer.parseInt(selection);
            if (start > intSelection || length < intSelection) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_BAD_SELECTION);
            }
            return intSelection;
        } catch (IllegalArgumentException e) {
            if (exitSigns.contains(selection)) {
                return StatusEnum.STOP.getStatus();
            }
            System.out.println(ScriptUtils.ERROR_BAD_SELECTION);
            return StatusEnum.TRY.getStatus();
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() < StaticUtils.MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ScriptUtils.ERROR_TOO_SHORT);
        }
    }
}
