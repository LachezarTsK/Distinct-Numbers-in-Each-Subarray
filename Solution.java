
public class Solution {

    public int[] distinctNumbers(int[] input, int targetSize) {

        // Alternatively: maxInputValue = Arrays.stream(input).max().getAsInt();
        int maxInputValue = 0;
        for (int value : input) {
            maxInputValue = Math.max(maxInputValue, value);
        }

        int countDistinctNumbers = 0;
        int[] valueToFrequency = new int[maxInputValue + 1];
        for (int i = 0; i < targetSize; ++i) {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += 1 / valueToFrequency[input[i]];
        }

        int[] distinctNumbersInTargetSizeSubarrays = new int[input.length - targetSize + 1];
        distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers;

        for (int i = targetSize; i < input.length; ++i) {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += (1 / valueToFrequency[input[i]]) - (1 / valueToFrequency[input[i - targetSize]]);
            --valueToFrequency[input[i - targetSize]];
            distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers;
        }

        return distinctNumbersInTargetSizeSubarrays;
    }
}
