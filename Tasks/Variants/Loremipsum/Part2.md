Let's verify that Lorem Ipsum is generated with correct size:
1. Go to https://www.lipsum.com/
2. Click on "words"
2. Input 10 into the number field
3. Press “Generate Lorem Ipsum”
4. Verify the result has 10 words
5. Verify correct generation for -1, 0, 5, 20 words
6. Create the same test for characters (bytes). Verify 3-4 values.


Let's verify the checkbox:
1. Go to https://www.lipsum.com/
2. Uncheck "start with Lorem Ipsum" checkbox
3. Press “Generate Lorem Ipsum”
4. Verify that result no longer starts with Lorem ipsum


Let's also check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:

1. Go to https://www.lipsum.com/
2. Press “Generate Lorem Ipsum”
3. Get text from each paragraph and determine the number of paragraphs containing the word “lorem”. 
4. Run the generation 10 times and get the average number of paragraphs containing the word “lorem”.
5. Fail the test if the value is less than 2 (the actual value seems to be between 2 and 3, so use 3 to check that your test can actually fail).