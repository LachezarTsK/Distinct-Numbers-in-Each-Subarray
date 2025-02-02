
using System;

public class Solution
{
    public int[] DistinctNumbers(int[] input, int targetSize)
    {
        int maxInputValue = input.Max();
        int countDistinctNumbers = 0;
        int[] valueToFrequency = new int[maxInputValue + 1];
        for (int i = 0; i < targetSize; ++i)
        {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += 1 / valueToFrequency[input[i]];
        }

        int[] distinctNumbersInTargetSizeSubarrays = new int[input.Length - targetSize + 1];
        distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers;

        for (int i = targetSize; i < input.Length; ++i)
        {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += (1 / valueToFrequency[input[i]]) - (1 / valueToFrequency[input[i - targetSize]]);
            --valueToFrequency[input[i - targetSize]];
            distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers;
        }

        return distinctNumbersInTargetSizeSubarrays;
    }
}
