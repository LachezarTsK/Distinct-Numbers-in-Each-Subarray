
package main

import "slices"

func distinctNumbers(input []int, targetSize int) []int {

    maxInputValue := slices.Max(input)
    countDistinctNumbers := 0
    valueToFrequency := make([]int, maxInputValue+1)
    for i := range targetSize {
        valueToFrequency[input[i]]++
        countDistinctNumbers += 1 / valueToFrequency[input[i]]
    }

    distinctNumbersInTargetSizeSubarrays := make([]int, (len(input) - targetSize + 1))
    distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers

    for i := targetSize; i < len(input); i++ {
        valueToFrequency[input[i]]++
        countDistinctNumbers += (1 / valueToFrequency[input[i]]) - (1 / valueToFrequency[input[i - targetSize]])
        valueToFrequency[input[i - targetSize]]--
        distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers
    }

    return distinctNumbersInTargetSizeSubarrays
}
