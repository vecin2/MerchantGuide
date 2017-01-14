DESIGN

The entry point to the application is "src.Main", which is in charge of running "Merchant's Guide".

Merchant's guide reads all input data lines and it creates an "Expression Set" to solve all of them. 
"Expression Set" implements the composite pattern and it contains a list of "intergalactic expressions", which is an abstract type and 
has a child type to solve each different type of line input expressions. 
A factory method is used to create "intergalactic expressions" based on each line of input data, then polymorphism is used to solve the expressions. 

Finally each expression uses an "intergalactic unit converter", which contains all the conversions needed to revolved the expressions.


ASSUMPTIONS

Only the scenarios covered by the exercise test input data have been considered, which means to handle further invalid scenarios or larger 
valid numbers the application might have to be enhanced. 


 
 