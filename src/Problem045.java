import support.Problem;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Mark on 10/10/17.
 *
 * https://projecteuler.net/problem=45
 */
public class Problem045 extends Problem {

    // Indices for the given example 40_755
    private long mTriangleNumberIndex = 286;
    private long mPentagonalNumberIndex = 166;
    private long mHexagonalNumberIndex = 144;

    private Set<Long> mPentagonalNumbers = new LinkedHashSet<>();
    private Set<Long> mHexagonalNumbers = new LinkedHashSet<>();

    private long mMaxPentagonalNumber = -1;
    private long mMaxHexagonalNumber = -1;

    // Generate pentagonal and hexagonal numbers just back the given triangleNumber
    private void generateNumbersForTriangleNumber(long triangleNumber) {
        while (triangleNumber > mMaxPentagonalNumber) {
            mMaxPentagonalNumber = mPentagonalNumberIndex * (3L * mPentagonalNumberIndex - 1L)/ 2L;

            mPentagonalNumberIndex++;
            mPentagonalNumbers.add(mMaxPentagonalNumber);
        }

        while (triangleNumber > mMaxHexagonalNumber) {
            mMaxHexagonalNumber = BigInteger.valueOf(mHexagonalNumberIndex)
                    .multiply(BigInteger.valueOf(2))
                    .subtract(BigInteger.ONE)
                    .multiply(BigInteger.valueOf(mHexagonalNumberIndex))
                    .longValue();

            mHexagonalNumberIndex++;
            mHexagonalNumbers.add(mMaxHexagonalNumber);
        }
    }

    @Override
    public long solveProblem() {
        while (true) {
            long triangleNumber = mTriangleNumberIndex * (mTriangleNumberIndex + 1L) / 2L;

            generateNumbersForTriangleNumber(triangleNumber);

            if (mPentagonalNumbers.contains(triangleNumber) && mHexagonalNumbers.contains(triangleNumber)) {
                return triangleNumber;
            }

            mTriangleNumberIndex++;
        }
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTUzMzc3NjgwNQ==";
    }
}
