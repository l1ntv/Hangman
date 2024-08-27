package Graphics;

public class HangingRackStringGenerator {
    private static final String FIRST_HANGING_RACK_STAGE = "__________\n";
    private static final String SECOND_HANGING_RACK_STAGE = "|        |\n";
    private static final String THIRD_HANGING_RACK_STAGE = "|        0\n";
    private static final String FOURTH_HANGING_RACK_STAGE = "|       /|\\\n";
    private static final String FIFTH_HANGING_RACK_STAGE = "|       / \\\n";
    private static final String SIXTH_SEVENTH_EIGHTH_HANGING_RACK_STAGE = "|\n";
    private static final String NINTH_HANGING_RACK_STAGE = "==========\n";


    public static String createHangingRack(int stage) {
        StringBuilder stringBuilder = new StringBuilder();
        if (stage >= 1) {
            stringBuilder.append(HangingRackStringGenerator.FIRST_HANGING_RACK_STAGE);
        }
        if (stage >= 2) {
            stringBuilder.append(HangingRackStringGenerator.SECOND_HANGING_RACK_STAGE);
        }
        if (stage >= 3) {
            stringBuilder.append(HangingRackStringGenerator.THIRD_HANGING_RACK_STAGE);
        }
        if (stage >= 4) {
            stringBuilder.append(HangingRackStringGenerator.FOURTH_HANGING_RACK_STAGE);
        }
        if (stage >= 5) {
            stringBuilder.append(HangingRackStringGenerator.FIFTH_HANGING_RACK_STAGE);
        }
        if (stage >= 6) {
            stringBuilder.append(HangingRackStringGenerator.SIXTH_SEVENTH_EIGHTH_HANGING_RACK_STAGE);
        }
        if (stage >= 7) {
            stringBuilder.append(HangingRackStringGenerator.SIXTH_SEVENTH_EIGHTH_HANGING_RACK_STAGE);
        }
        if (stage >= 8) {
            stringBuilder.append(HangingRackStringGenerator.SIXTH_SEVENTH_EIGHTH_HANGING_RACK_STAGE);
        }
        if (stage >= 9) {
            stringBuilder.append(HangingRackStringGenerator.NINTH_HANGING_RACK_STAGE);
        }
        return stringBuilder.toString();
    }
}
