1. Add a test that: 
   - Goes to BBC
   - Clicks on News
   - Checks the name of the headline article (the one with the biggest picture and text) against a value specified in your test (hard-coded)

2. Add another test:
   - Goes to BBC
   - Clicks on News   
   - Checks secondary article titles (the ones to the right and below the headline article) against a List<String> specified in your test (hard-coded).
Imagine that you are testing the BBC site on a test environment, and you know what the titles will be. Your test, then, checks that these titles are in fact present on the page. 
The test should pass if all the titles are found, and fail if they are not found. It's normal that your test will fail the next day - this would not happen if we had a Test environment for BBC, with a static database.

3. Write a test that: 
   - Goes to BBC
   - Clicks on News 
   - Stores the text of the Category link of the headline article (e.g. World, Europe...)
   - Enter this text in the Search bar
   - Check the name of the first article against a specified value (hard-coded)


 
 


