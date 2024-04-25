# Two Pointer

## Pre-requisites

## Exams

<!-- create markdown table with following columns -->

<!-- 1. Exam Solution Class
1. Exam Name
2. Exam Link
3. Exam Difficulty
4. Comments -->

<!-- Note to add prefix _I_ or _II_ or _III_ for exam solution class name III means hard, II means medium, I means easy-->
<!-- like _II_Pow is Medium level -->
<!-- Comments default is empty -->

| Exam Solution Class| Exam Name | Exam Link | Exam Difficulty | Comments |
| --- | --- | --- | --- |
<!-- 50 -->
| _II_Pow | Pow(x, n) | [LeetCode](https://leetcode.com/problems/powx-n/) | Medium |

Fast power is an efficient algorithm for calculating power operations. It has the following main features:

1. Low time complexity:
   - The traditional method of power operation requires n multiplication operations, with a time complexity of O(n).
   - The fast power algorithm uses the divide-and-conquer approach, repeatedly halving the exponent n, thereby reducing the time complexity to O(log n).

2. Applicable to large exponents:
   - When the exponent n is very large, the traditional method has low efficiency.
   - The fast power algorithm can efficiently calculate power operations with large exponents.

3. Principle:
   - Represent the exponent n in binary form.
   - By repeatedly squaring the base and selectively multiplying by the base based on the binary bits of the exponent, the final result is obtained.

4. Application scenarios:
   - RSA algorithm in cryptography
   - Calculation of Fibonacci sequence
   - Matrix power operations
   - Large integer arithmetic

In summary, fast power is an efficient power operation algorithm that is very useful in scenarios requiring power operations with large exponents. It greatly improves the computation efficiency through the divide-and-conquer approach. |
<!-- 54 -->
| _II_SpiralMatrix | Spiral Matrix | [LeetCode](https://leetcode.com/problems/spiral-matrix/) | Medium |
<!-- 7 -->
| _I_ReverseInteger | Reverse Integer | [LeetCode](https://leetcode.com/problems/reverse-integer/) | Easy |
<!-- 252 https://leetcode.cn/problems/meeting-rooms/description/ -->
| _I_MeetingRooms | Meeting Rooms | [LeetCode](https://leetcode.com/problems/meeting-rooms/) | Easy |
