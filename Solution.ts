
function distinctNumbers(input: number[], targetSize: number): number[] {

    let maxInputValue = Math.max(...input);
    let countDistinctNumbers = 0;
    const valueToFrequency: number[] = new Array(maxInputValue + 1).fill(0);
    for (let i = 0; i < targetSize; ++i) {
        ++valueToFrequency[input[i]];
        countDistinctNumbers += Math.floor(1 / valueToFrequency[input[i]]);
    }

    const distinctNumbersInTargetSizeSubarrays: number[] = new Array(input.length - targetSize + 1);
    distinctNumbersInTargetSizeSubarrays[0] = countDistinctNumbers;

    for (let i = targetSize; i < input.length; ++i) {
        ++valueToFrequency[input[i]];
        countDistinctNumbers += Math.floor((1 / valueToFrequency[input[i]])) - Math.floor((1 / valueToFrequency[input[i - targetSize]]));
        --valueToFrequency[input[i - targetSize]];
        distinctNumbersInTargetSizeSubarrays[i - targetSize + 1] = countDistinctNumbers;
    }

    return distinctNumbersInTargetSizeSubarrays;
};
