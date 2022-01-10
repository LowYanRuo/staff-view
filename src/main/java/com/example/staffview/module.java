package com.example.staffview;

public class module {

    String CourseID;
    String CourseCode1;
    String CourseCode2;
    String ModuleName;
    int Occurrence;
    String Activity;
    String Day;
    int Time1;
    int Time2;
    int Target;
    int Actual;
    int Credits;
    String Tutor;

    public module(String courseID, String courseCode1, String courseCode2, String moduleName, int occurrence, String activity, String day, int time1, int time2, int target, int actual, int credits, String tutor) {
        CourseID = courseID;
        CourseCode1 = courseCode1;
        CourseCode2 = courseCode2;
        ModuleName = moduleName;
        Occurrence = occurrence;
        Activity = activity;
        Day = day;
        Time1 = time1;
        Time2 = time2;
        Target = target;
        Actual = actual;
        Credits = credits;
        Tutor = tutor;
    }

    public String getCourseID() {
        return CourseID;
    }

    public String getCourseCode1() {
        return CourseCode1;
    }

    public String getCourseCode2() {
        return CourseCode2;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public int getOccurrence() {
        return Occurrence;
    }

    public String getActivity() {
        return Activity;
    }

    public String getDay() {
        return Day;
    }

    public int getTime1() {
        return Time1;
    }

    public int getTime2() {
        return Time2;
    }

    public int getTarget() {
        return Target;
    }

    public int getActual() {
        return Actual;
    }

    public int getCredits() {
        return Credits;
    }

    public String getTutor() {
        return Tutor;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public void setCourseCode1(String courseCode1) {
        CourseCode1 = courseCode1;
    }

    public void setCourseCode2(String courseCode2) {
        CourseCode2 = courseCode2;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public void setOccurrence(int occurrence) {
        Occurrence = occurrence;
    }

    public void setActivity(String activity) {
        Activity = activity;
    }

    public void setDay(String day) {
        Day = day;
    }

    public void setTime1(int time1) {
        Time1 = time1;
    }

    public void setTime2(int time2) {
        Time2 = time2;
    }

    public void setTarget(int target) {
        Target = target;
    }

    public void setActual(int actual) {
        Actual = actual;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public void setTutor(String tutor) {
        Tutor = tutor;
    }
}
