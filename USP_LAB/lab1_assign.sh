#! /bin/sh

#Adding, Subtracting, Multiplying, Dividing, Modulus without expr statements and using bc- basic calculator


read -p "Enter one number:" num1
read -p "Enter second number:" num2

add=`echo $num1+$num2|bc`
sub=`echo $num1-$num2|bc`
mul=`echo $num1*$num2|bc`
div=`echo $num1\/$num2|bc`
mod=`echo $num1%$num2|bc`

echo "The addition of 2 numbers is: $add"
echo "The subtraction of 2 numbers is: $sub"
echo "The multiplication of 2 numbers is: $mul"
echo "The division of 2 numbers is: $div"
echo "The modulus of 2 numbers is: $mod"



