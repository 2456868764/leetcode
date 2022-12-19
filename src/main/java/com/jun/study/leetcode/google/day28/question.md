Giving back to the community.

YOE: 2 years (backend development) in a failed start up.
LC: ~200 (110+ medium, 15 hard, 25+ easy) in 3 months.
Education: Tier - 3 university

A recruiter approached my via LinkedIn.

Phone Screen:
Questions:

3-sum.
Two sum in a BST.
Solved all the questions.

Things to be noted:
Importance is given to the naming conventions. Always discuss the approach first and then start coding it. While coding it, you should talk a lot about what you're coding so that the interviewer can have the sense of where you going with it.

Verdict: It was positive. I got the result in 48 hrs. And I was given a 3 weeks of time for my virtual onsite interview.

Onsite Interview(vitrual):

Round 1(45 mins):
Given a graph with 0s and 1s where 0 is water and 1 is land. Its guranteed that there's always 2 islands in the graph.

Link - https://leetcode.com/problems/shortest-bridge/
Find the minimum distance between 2 islands.

The interviewer was 15 mins late to join. So we jumped directly to the question without any further intro. And we discussed the approach for about 10 mins and I coded the entire solution in 20 mins.

Approach - Multi source BFS
TC and SC were asked.

No follow ups coz there was another interviewer who was waiting on call for the next round.

Round 2(45 mins):
In this round we had a proper intro and we had a formal conversation for about 10 mins and we jumped into the question.

Question:
Edit: Thanks for pointing out the problem.
Given an array integers, return the list of integers for which the function returns true.
variant of https://leetcode.com/problems/first-bad-version/

I codeed the solution in 5 mins and discussed about further developments of that piece of code, like how can we make it look like a production code and how to wrap it up like an STL for all types. This part went for another 5 mins.

Now the i\p is transformed into a stream of vectors of double.

Follow up:

[50, 40, 30, 20, 10]      // (each element) / 1
[25, 20, 15, 10, 5]       // (each element) / 2
[4.166, 6.6667, 5, 3.33333, 1.67777 ]  // (each element) / 3
[......................]  // (each element) / 4
[......................]   // divided by 5
[......................]   // divided by 6 and goes on
Now I've to return the maximum double for which the black blox function returns true from the stream and determine the point at which I have to stop computing the stream by returning the value.

Initially it was overwhelming to see something like this but I found the pattern in the data and gave him the brute force approach.
And discussed other possible approaches. TC and SC were discussed.
The interviewer was not looking for any optimized approaches. But he wanted to give different approaches to solve this problem.

This round ended well.

I got a decent feedback on both of the rounds.

Round 3(45 mins):
we had a formal introduction for 5 mins and jumped right into the question.
Given a graph:

6--------5
|        |
1--3--4--2
|        |
7---8----9
source is 1 and destination is 9.
Find the shortest route to reach the destination from source and return all the cities that exist in that shortest route. If there are multiple routes with the same shortest distance you can return anyone. And the paths can be in any order.

For example the o/p for the above graph will be minimum_dist = 3 and path is [1, 7, 8, 9]

I gave a brute force approach and the interviewer wanted me to go with BFS and I didn't even have clue about it.
I took all 20 mins to discuss it with multiple approaches and then I was given a hint and I gave him the right approach. And then it was almost 30 mins. So the interviewer asked me to code only a specific part of the solution.

The approach is to run BFS from src to all nodes and store all the shortest path from src to other nodes.
And do the same for destination node and store all the shortest path from dest to other nodes.

Also while computing the shortest distance from src when you reach the destination store the distance as min_dist
```
nodes(index)         0   , 1, 2, 3, 4, 5, 6, 7, 8, 9
dist_from_src =  [INT_MAX, 0, 3, 1, 2, 2, 1, 1, 2, 3]
dist_from_dest = [INT_MAX, 3, 1, 3, 2, 2, 3, 2, 1, 0]
```
min_dist = 3
dist_from_src[i] + dist_from_dest[i] == min_dist will tell if the ith node is part of the shortest path
```
min_dist = 0
dist_from_src =  BFS(src = 1) // from the i/p
dist_from_dest = BFS(src = 9) // from the i/p
```

```
def getMinPath(dist_from_src, dist_from_dest):
min_path = []
for i in range(1, n+1):
if dist_from_src[i] + dist_from_dest[i] == min_dist:
min_path.append(i)
return min_path
```
Looks like a DP + BFS on graph.
I bombed this round.

Round 4(45 mins):
given a 2d grid m x n of objects which represents a highway.
A frog has to cross to the other end.
Frog can jump 1 unit at a time and it can move in all 4 directions or it can stay at same position. To make a jump, the time taken by the frog is 1 unit.
The vehicles will move in the given directions with constant speed such that they'll move to adjacent position in 1 unit of time.
Its guranteed that vehicles will never collide.
when a vehicle's position is beyond the given limits, its guranteed that there wont be any new vehicles coming into the road.
Example: for every v, If rowIndx > n || rowIndx < 0 || columnIndx > m || columnIndx < 0, then we can ignore the vechicle from the grid and no new vehicles will be entering into the grid.
Find the minimum jumps(which is equal to minimum time) required to reach the other end of the road.
```
class Info {
public:
bool is_frog;
bool is_vehicle;
int vehicle_dir; // 0 is left and 1 is right.  
};
vector<vector<Info> > // i/p is the type
```
```
// visual representation of the i/p data
m -------------------------------
▲   v->          v->
|      v->
|      <-v    <-v
v->
0 -------f-----------------------n
----▶
```
I suggested two approaches. One is to do a weighted BFS and the other is to backtrack. The interviewer wanted me to pick the approach which is a quicker one to code. I tried coding the bactrack solution. And I answerd the TC and SC questions. And no time to dry run the code and we had a short discussion on weighted BFS. The interviewer said that he wanted me to analyze both approaches with him.

This is round is also kinda screwed up.

Round 5(45 mins):

Work ex.
Challenging task.
Startup vs MNC.
Hypothetical questions about leading an open ended product/services like google translate and google maps.
This round went well.

Verdict is obvious. Its negative.
Feedback was that I was too slow in round 3 and 4. But they liked my communication and my code quality.
The recruiter said that he'll get in touch with me after 10 months.

I hope I could solve everything next time.

I'm not a competitive programmer. I practice LC only during job hunting coz its hard to find time for this after work. Maybe its a cake walk for some of you guys.

Thanks.

Edit: I've updated round 4.