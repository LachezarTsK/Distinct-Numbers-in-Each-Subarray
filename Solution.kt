
class Solution {

    fun distinctNumbers(input: IntArray, targetSize: Int): IntArray {

        val maxInputValue = input.max()
        var countDistinctNumbers = 0
        val valueToFrequency = IntArray(maxInputValue + 1)
        for (i in 0..<targetSize) {
            ++valueToFrequency[input[i]]
            countDistinctNumbers += 1 / valueToFrequency[input[i]]
        }

        val distinctNumbersInTargetSizeSubarrays = IntArray(input.size - targetSize + 1)
        distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers

        for (i in targetSize..<input.size) {
            ++valueToFrequency[input[i]]
            countDistinctNumbers += (1 / valueToFrequency[input[i]]) - (1 / valueToFrequency[input[i - targetSize]])
            --valueToFrequency[input[i - targetSize]]
            distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers
        }

        return distinctNumbersInTargetSizeSubarrays
    }
}
