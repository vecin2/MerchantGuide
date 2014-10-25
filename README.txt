Test input:
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

Test Output:
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about



I learn
Implement the simple next step that takes to the solution
Keep growing until you get to the solution. 
Checks which tests are duplicated and can be removed
InputStreamReader differencies with FileReader

-------Notes-------------
Test plan has the following tests:

1. One test which covers all the above end to end test cases

2. Smaller unit tests
	2.1Convert galactic to Roman
		This test is an middle step to convert galactic to arabic, it could maybe be deleted since the funcionality is tested within the next test, 
		plus it could be testin implementation details (the fact we convert to roman, previous that we convert to arabic is just the way we implemented).
		For example we could change the implementation to use a conversion table galactic/arabics and use the roman algorithm directly (exercise pendent*).
	
	2.2 Convert galactic to arabic
	    Check "glob pish" is 9
	
	2.3 Add Galactic Note
		Test adding a simple galactic note sets the correct value: "glob is I", returns I.
		
	2.4 Add Equation Note (agenda.addNote("glob glob Silver is 34 Credits"))
			This test checks the Silver is added to the conversion table with value 17
		
		2.4.1 Test build equation ("glob glob Silver is 34 Credits" --> equation.coefficient="glob glob", equation.variable="Silver", equation.constant=34")
			Its again an middle step to get the previous test passing. 
			
			2.4.1.1 Test build galactic currency (glob glob Silver --> galacticCurrency.galactic= "glob glob", galacticCurrency.currency="Silver")
				This test it could maybe be removed as well, since it is testing quite low, it is testing implementation details and it is cover by the previous 
				one and the "add Equation note" test.
			
		2.4.2 Test solve equation (equation.coefficient="glob glob", equation.variable="Silver", equation.constant=34" --> return constant.divide(coefficient))
				Given an equation it return the variable value by dividing the constant between the coefficient.
			
	2.5 Test ask galactic number ("how much is prok glob ?"
		Given the galactic numbers are already saved, it tests the retrieving part of the agenda and displays the right message
	
	2.6 Test ask equation ("how many Credits is glob prok Silver ?")
		Given galactic numbers and currencies (silver) are already saved retrieved them and displays them correctly.
		
	2.7 Test invalid entry ("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
		Test the agenda handles an invalid question.
		
		Handle the following invalid entries
		agenda.ask("glob is I") --> is not a valid question
		agenda.addNote("how much is glob ?")--> is not a valid note
					
		