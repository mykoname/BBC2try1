1.	Add a test that verifies that team scores display correctly: 
    - From BBC Home page go to Sport;
    - Go to Football
    - Go to Scores and Fixtures
	- Search for a championship (e.g. Scottish Championship). This value should be in your test, so that another test can search for a different value.
    - Select results for a month. Again, the month should be in your test.
    - Verify that 2 specific teams (specified in your test) played with a specific score (again, specified in your test);
    - Click on one of the team’s names;
    - Verify that the score at the center of the screen is also the one from your test (same value). Both the numbers and the team names should be verified.
    Note: you need text from :after element. Selenium doesn’t work with them properly – google how to get around that.

 
2.	Add 4 more tests (use copy-paste). They should all do the same thing with different data (championship, month, teams, score).


