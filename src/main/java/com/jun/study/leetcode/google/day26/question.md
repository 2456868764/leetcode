# question
**Question **

Given two string, say A = "abca", B = "abbac". We can make another string S by concatening A multiple times. Then we can remove any number of charaters from string S.
Is it possible to make string S equal to B? Return true or false.

I completed it by only check if all unique characters from B exists in A or not and then return True or False.

Follow Up: What is the minimum number of times you need to concate if the given inputs are always True from the first question?
I approachedO(n*m) solution. The interviewer was happy with this and told to write code for this approach.
I messed up when coding but at the end I could implement my idea. I checked and tested my code. Everything was fine.

Then I proposed another solution when I had only 2/3 mins which take O(max(n, m)) time complexity. And it was the best solution. He was happy taking my interview.


# solution

Solution
Use two pointers in source and target respectively. Both pointers are initialized to 0.

Each time starting from the pointer of target, find the longest subsequence of source in target. A subsequence in target ends when either the pointer in source reaches the end or the pointer in target reaches the end. If a longest subsequence has length 0, then the character in target does not exist in source, so return -1. 
Otherwise, increase the number of subsequences by 1, and find the next subsequence in target starting from the updated pointer in target. Finally, return the number of subsequences.