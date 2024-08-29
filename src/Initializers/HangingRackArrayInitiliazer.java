package Initializers;

import Constants.AppConstants;

import java.util.ArrayList;

public class HangingRackArrayInitiliazer {

    private HangingRackArrayInitiliazer() {
    }

    public static ArrayList<String> initilizeHangingRackArray(ArrayList<String> arrayList) {
        arrayList.add(AppConstants.FIRST_STAGE);
        arrayList.add(AppConstants.SECOND_STAGE);
        arrayList.add(AppConstants.THIRD_STAGE);
        arrayList.add(AppConstants.FOURTH_STAGE);
        arrayList.add(AppConstants.FIFTH_STAGE);
        arrayList.add(AppConstants.SIXTH_STAGE);
        arrayList.add(AppConstants.SEVENTH_STAGE);
        arrayList.add(AppConstants.EIGHTH_STAGE);
        arrayList.add(AppConstants.NINTH_STAGE);
        return arrayList;
    }
}
