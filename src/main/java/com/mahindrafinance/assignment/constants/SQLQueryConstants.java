package com.mahindrafinance.assignment.constants;

public class SQLQueryConstants {

    public static final String ADD_ADVISOR = "INSERT INTO ADVISOR_DETAILS (ID,NAME,Profile_Pic) " +
            "VALUES (:ID,:NAME,:URL)";

    public static final String ADD_USER = "INSERT INTO USER_DETAILS (ID,NAME,EMAIL,PASSWORD) " +
            "VALUES (:ID,:NAME,:EMAIL,:PASSWORD)";

    public static final String LOGIN_USER = "SELECT * FROM USER_DETAILS WHERE EMAIL = :EMAIL AND PASSWORD = :PASSWORD";
    public static final String GET_USER = "SELECT * FROM USER_DETAILS WHERE ID = :USERID ";

    public static final String GET_ADVISOR = "SELECT * FROM ADVISOR_DETAILS WHERE ID = :ADVISOR_ID ";
    public static final String GET_ALL_ADVISOR = "SELECT * FROM ADVISOR_DETAILS";

    public static final String BOOK_SLOT = "INSERT INTO BOOKING_DETAILS (BOOKING_ID,ADVISOR_ID,USER_ID,BOOKING_TIME) " +
            "VALUES (:BOOKING_ID,:ADVISOR_ID,:USER_ID,:BOOKING_TIME)";


    public static final String GET_ALL_BOOKINGS = "SELECT ADVISOR.ID ADVISOR_ID,ADVISOR.NAME ADVISOR_NAME,ADVISOR.Profile_Pic," +
            "BOOKING.BOOKING_ID,BOOKING.BOOKING_TIME FROM ADVISOR_DETAILS ADVISOR,BOOKING_DETAILS BOOKING WHERE " +
            "ADVISOR.ID = BOOKING.ADVISOR_ID";



}
