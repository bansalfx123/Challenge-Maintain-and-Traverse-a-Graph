Challenge: Maintain and Traverse a Graph
Our app tracks usage events and associates those events with an email address, but sometimes more than one email address can belong to one person. We need to maintain a graph of nodes (where each node represents an email) that can be linked together, unlinked, and queried. This challenge has two parts: 

We hope the first gives you a chance to show off your code style, and the second a chance to show off system design.

Coding Challenge
The input is a text file where each line represents either a command or a question. The commands are:
add x y - add a bidirectional link between nodes x and y (if one does not yet exist)
remove x y - remove a bidirectional link (if one exists) between x and y
is linked x y - return whether there is any path between node x and node y

For example:
	add 1 2
	add 2 3
	add 3 4
	is linked 3 1
remove 3 4
	is linked 1 4

The output should be:
	true
	false
The “true” because there is a path between 1 and 3 (1 is linked to 2, and 2 is linked to 3)
The “false” because there is no path between 1 and 4. 
More example data can be found at the end of the document.
