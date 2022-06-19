# Task 4

### Requirements

- TA Approaches;
- TA Test Case design.

### Where we are

We have a framework with tests in code. Let’s switch that to BDT.
Please watch the Test Automation Approaches video for some context.

### Task

1. Install SpecFlow (check [Install_SpecFlow.md](./../HowTo/Install_SpecFlow.md));
2. A Feature File will be auto-generated as an example. You can always add more, and, of course, google SpecFlow examples. :) See below for a very short summary.
3. You need to turn your test cases to BDT format. Remember to keep them short, work to remove any duplicate sequences, and stick to logical actions rather than implementation details (such as clicking buttons).


### Short summary of how SpecFlow works

Let's say we have a method marked with \[Given] attribute in a class with \[Bindings] attribute
```csharp
[Given("I tezt")]
public void GivenITezt()
{
	...
}
```         
If you write "Given I tezt" in your feature file, this method will get called. We can also add string and Table arguments to the step:   
```
Given I tezt stuff
| header 1 | header 2 |
| data1    | data2    |
```  
As you can see, table data has a special format, but string variables don't (although SpecFlow will suggest putting string data in single quotes).
To access this data from our method, we need to modify it:
```csharp
[Given("I tezt (.*)")]
public void GivenITezt(string stuff, Table tableStuff)
{
	...
}
```  
If you launch the Feature File now, the method will have access to "stuff", as well as the table in the Feature File.

String variables are captured through Regex groups. You need to read up on what regular expressions are and the basics of their use (Regexp capture groups are important). 
After that, use a site like https://regex101.com/ to determine what the groups will be in your case. Group 1 will be the first variable of the method, Group 2 will be the second, and so on. Table, if present, is always the last argument.

 

