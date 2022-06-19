### Tests

1. Add a test which verifies that user can submit a question to BBC: 
    - Find a form (several text boxes and possibly check boxes, with some sort of Send/Submit button) that allows you to send a question to BBC. Note that this form sometimes moves around the BBC site - ask in chat if you cannot find it.
   Below steps work as of 16.09.2020:
      - From BBC Home page go to News;
      - Click on "Coronavirus" tab, and then on "Your Coronavirus Stories" tab;
      - Go to “Coronavirus: Send us your questions”;
      - Scroll down to find the form.
    - Fill the form with information, but one of the required fields empty or with invalid data;
    - Click Send/Submit;
    - Verify that the submission did not work, either by checking for correct error message, or, failing that, that the form still contains entered data.
3. Add at least 2 more tests (use copy-paste). They should do the same as the one we just wrote, except they will cover different *negative* test cases.
Add one case for each required field/checkbox that leaves it empty. If Email is required - add a case where it is invalid.
	
### Important

Do not enter fully correct data into the form. If you spam BBC with garbage "stories" and get banned, that's on you. :)

