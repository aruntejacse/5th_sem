#! /bin/sh

#Write a shell program to perform the basic 
#Airthmetic Operations using expr command 
#Addition,Subtraction,Multiplication and Division

read -p 'Enter two numbers:' num1 num2

add=`expr $num1 + $num2`
sub=`expr $num1 - $num2`
mul=`expr $num1 \* $num2`
div=`expr $num1 \/ $num2`

echo "Addition is: $add\nSubtaction is: $sub\nMultiplication is: $mul\nDivision is: $div"
