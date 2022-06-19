# Task 1

### Requirements

- TA of Web applications with Selenium;
- Basic understanding of Xpath: you can at least copy an Xpath from Chrome.


### Useful bits of code

	Use the code bits below as building blocks for your tests:
```csharp
	IWebElement element = driver.FindElement(By.XPath("xpath")); // Replace “xpath” with correct xpath. This returns an IWebElement interface of the element found by Xpath. This interface can then be used to click the element or perform other actions (such as getting its text, checking visibility).
	element.Click() // Clicks the element
	string elementText = element.Text; // Assigns the text in the element (which is usually what you see on this element in your browser) to variable elementText
	Assert.AreEqual("text", elementText);  // Checks that string “text” is equal to variable elementText, and throws exception if not. Use for checks that must succeed for the test to pass (i.e. the checks that are the purpose of the test).
```

### Task

Implement tests described in Part1 file of that variant.
