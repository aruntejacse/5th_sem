# !bin/sh

#Factorial of a number.

read -p "Enter a number" num

a=1

while [ $num -gt 0 ]
do
	a=`expr $a \* $num`
	num=`expr $num - 1`
done

echo $a 
