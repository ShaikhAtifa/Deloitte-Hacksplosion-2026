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

Join all words with a space:

