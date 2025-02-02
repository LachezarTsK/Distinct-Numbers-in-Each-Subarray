
#include <ranges>
#include <vector>
using namespace std;

class Solution {

public:
    vector<int> distinctNumbers(const vector<int>& input, int targetSize) const {

        // Prior to C++20: max_element(vectorName.begin(), vectorName.end())
        const int maxInputValue = *ranges::max_element(input);
        int countDistinctNumbers = 0;
        vector<int> valueToFrequency(maxInputValue + 1);
        for (int i = 0; i < targetSize; ++i) {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += 1 / valueToFrequency[input[i]];
        }

        vector<int> distinctNumbersInTargetSizeSubarrays(input.size() - targetSize + 1);
        distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers;

        for (int i = targetSize; i < input.size(); ++i) {
            ++valueToFrequency[input[i]];
            countDistinctNumbers += (1 / valueToFrequency[input[i]]) - (1 / valueToFrequency[input[i - targetSize]]);
            --valueToFrequency[input[i - targetSize]];
            distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers;
        }

        return distinctNumbersInTargetSizeSubarrays;
    }
};
