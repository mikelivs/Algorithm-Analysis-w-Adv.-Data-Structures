# Algorithm-Analysis-w-Adv.-Data-Structures

Compile instructions: 
program takes one command line argument, input file name (cpIn.txt).
Program outputs file (cpOut) 

Program report: The running time of my algorithm is O(n) 

My alg:
-Read in graph/file
-calc degrees of each vertex
-sort degrees highest-> lowest
-select first k vertices from sorted degree list (largest degree vertices)
-remove those nodes and connected edges
-return count number of edges in new graph Gs (Minimum pairwise connectivity)  
-return k number of vertices which have highest degrees 

I had trouble implementing removing vertices from a 2d array so I just changed the values at which i wanted to remove to -1 .  
  
Pt1 Test runs:

Given sample file (7,11,5)

Output: 
4
3,4

Random graph input (50, 51,5)

Output: 
20
10,13,29,40,8
. 

Random graph input (100, 111,5)

Output: 
52
75,16,33,55,81

Random graph input (500, 505,5)

Output: 
187
332,107,10,236,78


Part2:

Random graph input (100, 111,5)

Output: 
52
75,16,33,55,81


Same graph input change k(100, 111,10)

Output: 
18
75,16,33,55,81,12,66,58,9,2

Same graph input change k(100, 111,50)

Output: 
2

75,16,33,55,81,12,66,58,9,2
8,17,70,80,91,79,3,47,87,14
89,15,65,30,1,42,98,78,85,46
59,25,5,69,52,88,28,34,12,4

