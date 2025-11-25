# 1018. Binary Prefix Divisible By 5

## Problem Link
https://leetcode.com/problems/binary-prefix-divisible-by-5/

## Description
You are given a binary array nums (0-indexed).

We define `xi` as the number whose binary representation is the subarray `nums[0..i]` (from most-significant-bit to least-significant-bit).

- For example, if `nums = [1,0,1]`, then `x0 = 1`, `x1 = 2`, and `x2 = 5`.
Return an array of booleans answer where `answer[i]` is `true` if `xi` is divisible by `5`.

## Topics
- Array
- Bit Manipulation

## Eg 1:
nums = [0, 1, 1]

0, 01, 011
0, 1, 3
`0 % 5`, `1 % 5`, `3 % 5`
true, false, false

## Eg 2:
nums = [1, 1, 1]

1, 11, 111
1, 3, 7
`1 % 5`, `3 % 5`, `7 % 5`
false, false, false

## Binary to decimal calculation

- `Base 2` --> `Base 10` converation
- Binary term represenation `[.... 16 8 4 2 1]` as `[.... b4 b3 b2 b1 b0]`. The formula is,
```
dec = Σ (bi × 2^i)
```
- In this case, we never want the entire conversation at each step. Instead, we are using the previous value to update the number step by step. And it can be given as follows,
```
Previous value * 2 + current value
```

## Solution Explanation with Example 1 `nums = [0, 1, 1]`

To hold the previous value, we declare a variable named `temp` and then iterate through the array.
```java
List<Boolean> ans = new ArrayList();
int temp = 0
for (int bits: nums) {
    temp = (temp * 2 + bit) % 5;
    ans.add(temp == 0);
}
return ans;
```

### Why and How `%5` works even for large numbers in the solution?

Let me get it clear with a simple math expression
If
```
new_number % 5 = (old_number * 2 + bit) % 5
```
And,
```
old_number % 5 = r
```
Then,
```
new_number = (r * 2 + bit) % 5
```
Even if the binary number become very long like `10011010101010101111....`, we never compute the entire number. We only keep the track of the reminder, which only be `0, 1, 2, 3, 4 [only five possiblities]` as values.

### nums iterations
#### 1st iteration
```
bit = 0
temp = 0

temp = (temp * 2 + bit ) % 5
temp = (0 * 2 + 0) % 5
temp = (0 + 0) % 5
temp = 0 % 5
temp = 0
```

#### 2nd iteration
```
bit = 1
temp = 0

temp = (temp * 2 + bit ) % 5
temp = (0 * 2 + 1) % 5
temp = (0 + 1) % 5
temp = 1 % 5
temp = 1
```

#### 3rd iteration
```
bit = 1
temp = 1

temp = (temp * 2 + bit ) % 5
temp = (1 * 2 + 1) % 5
temp = (2 + 1) % 5
temp = 3 % 5
temp = 3
```