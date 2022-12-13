# question

Lyrics and Keyword

Write a function canMatch that takes a string lyrics, and a string keyword. Return true if if the keyword is hidden in the lyrics.

Example 1

lyrics = "every breath you take every move you make"
keyword = boom
This should return true because
b is in "breath"
o is in "you"
o is in "move"
m is in "make".

Example 2

lyrics = "i'm a cowboy on a steel horse i ride, i'm wanted"
keyword = boom
This should return true because
b is in "cowboy"
o is in "on"
o is in "horse"
m is in "i'm".

Each word in lyics can only be used for one letter in the keyword. If lyrics = "boom" and keyword = "boom" , then canMatch should return false because there would only be a match for "b".

Next you have to write another function canMatchAll that takes a list of lyrics and a list of keywords and returns a hashmap/dictionary where each key is a keyword and each value is a list of lyrics where canMatch returns true. This function must have a running time less than O(length of lyrics * length of keywords).

How would you code this solution in Java or Python?