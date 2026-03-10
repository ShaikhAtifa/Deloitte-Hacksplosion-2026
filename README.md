# Deloitte-Hacksplosion-2026
In this repo, I'm adding the question I got in the Deloitte Hacksplosion 2026 with the answer.
There  were 3 coding questions followed by GenWAI MCQ questions (17- 18 maybe).

**Question1: Sentence Sorting-**
You are provided with a string in which each word has exactly one digit.
The digit is in the correct position in the word in the final sentence.

Your job is to:
1. Extract the digit from each word.
2. Sort the words in ascending order of the digit.
3. Remove the digit from each word.
4. Return the sentence in correct order.

 **Sample Input
"Givi3ng I1 a2m 5Test Deloi4tte"
** Sample Output
"I am Giving Deloitte Test"

🔎 Explanation
Original Word	Digit Found	Clean Word	Final Position
Givi3ng	3	Giving	3rd
I1	1	I	1st
a2m	2	am	2nd
5Test	5	Test	5th
Deloi4tte	4	Deloitte	4th

Now, put them in the correct positions:

I am Giving Deloitte Test
🛠 Approach to Solve
Step 1: Split the Input String

Split the sentence into separate words using a space as a delimiter.

String[] words = input.split(" ");
Step 2: Create a Result Array

Create a new array of the same length to store words in the correct positions.
String[] result = new String[words.length];
Step 3: Process Each Word

For each word:
Traverse character by character.
If the character is a digit:
Convert it to an integer using:
position = ch - '0';

If the character is not a digit:
Append it to a StringBuilder to form the cleaned word.

Step 4: Place Word at Correct Index
result[position - 1] = cleanedWord;
We subtract 1 because array indexing starts from 0.

Step 5: Convert the array back to a sentence
Join all words with a space


**Question2:Minimum Bottle using(Knapsack)-**
Problem
Water bottles of certain capacities are available: 2L, 3L, 5L, 7L, and 11L. 
For a given target volume in litres, the problem is to find the least number of bottles required to exactly reach the target volume. 
If the target volume cannot be exactly reached with the given bottles, return -1. 
This is the classic "Coin Change Problem," with the coins being the available water bottles and the target being the target volume. 


Example:

Target: 10 L 
Possible combinations: 
5+5 = 10 L, requiring 2 bottles 
Another combination: 
3+7 = 10 L, requiring 2 bottles 
Another combination: 
2+3+5 = 10 L, requiring 3 bottles 
This is not the least number of bottles required. 
The program correctly gives the result: 2. 



Method: Dynamic Programming (Bottom-Up Approach)
The solution is based on the "Bottom-Up Approach" of Dynamic Programming. 
Key Idea:
dp[i] is defined as the least number of bottles required exactly to reach the target volume of i litres. 


dp[0] is initialized with 0, as zero bottles are required for zero litres. 
For all other dp[i], the value is initialized with Integer.MAX_VALUE, signifying "not yet reachable." 
For all i from 1 to target, the program goes through all the available bottles.


**Question no.3: Supper Tunnel**

I don't clearly remember this problem, but it's a clear graph one.

I tried the solution based on what I remember taking help with AI assistants.

Below is the details of the PS:

Gemini said
Since this is for a GitHub post, you’ll want a clean, professional README.md that explains the logic clearly to other developers. I’ve structured this to focus on the Algorithm and the Implementation, which are the most important parts for a repository.

Super Tunnel Discovery: Finding Critical Infrastructure
📌 Overview
In a network of connected tunnels, some junctions are more critical than others. A Super Tunnel is a single point of failure: if this tunnel collapses, it disconnects parts of the network that were previously reachable.

This project implements an efficient solution using Graph Theory to identify these critical nodes (Articulation Points) in O(V 
2
 ) time for an adjacency matrix.

🚀 The Problem
Given an N×N adjacency matrix where:

1 represents a connection between two tunnels.

0 represents no connection.

Find all indices of "Super Tunnels" that, if removed, increase the number of connected components in the graph.

Why not just remove each node and check?
A naive approach would be to remove each tunnel one by one and run a BFS/DFS to see if the graph is still connected. This would take O(V⋅(V+E)), which is too slow for large networks. Instead, we use Tarjan’s Algorithm, which finds all Super Tunnels in a single DFS pass.

🛠️ Implementation Details (Java)
The core logic uses two auxiliary arrays:

Discovery Time (disc[]): The order in which a node was reached.

Low Link Value (low[]): The lowest discovery time reachable from the node (including its descendants) using a back-edge.

Logic Criteria
A node u is a Super Tunnel if:

Root Case: It is the starting node of the DFS and has more than one child.

Intermediate Case: It has a child v such that no back-edge exists from v or its descendants to u or any ancestor of u (low[v]≥disc[u]).

📋 Example
Input Matrix:

Plaintext
0 1 1 0 0
1 0 1 0 0
1 1 0 1 0
0 0 1 0 1
0 0 0 1 0
Visual Representation:

Tunnels 0, 1, and 2 form a triangle.

Tunnel 2 connects to Tunnel 3.

Tunnel 3 connects to Tunnel 4.

Output:
[2, 3]
(If 2 is removed, {0,1} are cut off. If 3 is removed, {4} is cut off.)


