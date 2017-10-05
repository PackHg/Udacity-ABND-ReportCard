package com.oz_heng.apps.android.reportcard;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * {@link ReportCard} keeps track of the following grades:
 * - English grade: a {@link String};
 * - Math grade: a {@link String};
 * - History grade: a {@link double};
 * - Biology grade: a {@link double}.
 * <p>
 * The English grade and Math grade must be either "A", "A-", "A+", "B", "B-", "B+", "C", "C+",
 * "C-", "D", "D+", "D-", "E", "E+" or "E-". If these grades are set outside these values at the
 * constructor or at a setter, an IllegalArgumentException exception will be thrown.
 * <p>
 * The history and biology grades must be >= 0.0 and <= 100.0. If these grades are outside these
 * values at the constructor or at a setter, an IllegalArgumentException exception will be
 * thrown.
 */
public class ReportCard {

    private static final ArrayList<String> LETTER_GRADE = new ArrayList<>(Arrays.asList(
            "A", "A-", "A+", "B", "B-", "B+", "C", "C+", "C-", "D", "D+", "D-", "E", "E+", "E-"));

    private static final double MIN_DOUBLE_GRADE = 0.0;
    private static final double MAX_DOUBLE_GRADE = 100.0;

    private static final String ENGLISH_GRADE_PARAM = "The English grade parameter";
    private static final String MATH_GRADE_PARAM = "The math grade parameter";
    private static final String HISTORY_GRADE_PARAM = "The history grade parameter";
    private static final String BIOLOGY_GRADE_PARAM = "The biology grade parameter";
    private static final String IS_INCORRECT = " is incorrect";

    // Private variables
    private String mEnglishGrade;
    private String mMathGrade;
    private double mHistoryGrade;
    private double mBiologyGrade;

    /**
     * {@link ReportCard} constructor.
     * <p>
     * {@param englishGrade} and {@param mathGrade} must be either "A", "A-", "A+", "B", "B-", "B+",
     * "C", "C+", "C-", "D", "D+", "D-", "E", "E+" or "E-". If these parameters are set outside
     * these values, an IllegalArgumentException exception will be thrown.
     * <p>
     * {@param historyGrade} and {@param biologyGrade} must be >= 0.0 and <= 100.0. If these
     * parameters are outside these values, an IllegalArgumentException exception will be thrown.
     */
    public ReportCard(String englishGrade, String mathGrade, double historyGrade,
                      double biologyGrade) {

        if (isCorrect(englishGrade.trim(), ENGLISH_GRADE_PARAM)
                && isCorrect(mathGrade.trim(), MATH_GRADE_PARAM)
                && isCorrect(historyGrade, HISTORY_GRADE_PARAM)
                && isCorrect(biologyGrade, BIOLOGY_GRADE_PARAM)) {
            mEnglishGrade = englishGrade.trim();
            mMathGrade = mathGrade.trim();
            mHistoryGrade = historyGrade;
            mBiologyGrade = biologyGrade;
        }
    }

    /**
     * Check if the {@param grade} is correct.
     * if this parameter is not either "A", "A-", "A+", "B", "B-", "B+", "C", "C+", "C-", "D", "D+",
     * "D-", "E", "E+" or "E-", an IllegalArgumentException exception will be thrown.
     *
     * @param grade      Parameter to check.
     * @param whichGrade A prefix that will be included in the exception message.
     * @return true if the parameter is correct, else false.
     */
    private boolean isCorrect(String grade, String whichGrade) {
        if (LETTER_GRADE.contains(grade)) {
            return true;
        } else {
            throw new IllegalArgumentException(whichGrade + IS_INCORRECT);
        }
    }

    /**
     * Check if the {@param grade} is correct.
     * if this parameter is not >= 0.0 and <= 100.0, an IllegalArgumentException exception will be
     * thrown.
     *
     * @param grade      Parameter to check.
     * @param whichGrade A prefix that will be included in the exception message.
     * @return true if the parameter is correct, else false.
     */
    private boolean isCorrect(double grade, String whichGrade) {
        if (MIN_DOUBLE_GRADE <= grade && grade <= MAX_DOUBLE_GRADE) {
            return true;
        } else {
            throw new IllegalArgumentException(whichGrade + IS_INCORRECT);
        }
    }

    public String getEnglishGrade() {
        return mEnglishGrade;
    }

    public void setEnglishGrade(String grade) {
        if (isCorrect(grade.trim(), ENGLISH_GRADE_PARAM)) {
            mEnglishGrade = grade.trim();
        }
    }

    public String getMathGrade() {
        return mMathGrade;
    }

    public void setMathGrade(String grade) {
        if (isCorrect(grade.trim(), MATH_GRADE_PARAM)) {
            mMathGrade = grade.trim();
        }
    }

    public double getHistoryGrade() {
        return mHistoryGrade;
    }

    public void setHistoryGrade(double grade) {
        if (isCorrect(grade, HISTORY_GRADE_PARAM)) {
            mHistoryGrade = grade;
        }
    }

    public double getBiologyGrade() {
        return mBiologyGrade;
    }

    public void setBiologyGrade(double grade) {
        if (isCorrect(grade, BIOLOGY_GRADE_PARAM)) {
            mBiologyGrade = grade;
        }
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "mEnglishGrade='" + mEnglishGrade + '\'' +
                ", mMathGrade='" + mMathGrade + '\'' +
                ", mHistoryGrade=" + mHistoryGrade +
                ", mBiologyGrade=" + mBiologyGrade +
                '}';
    }
}
