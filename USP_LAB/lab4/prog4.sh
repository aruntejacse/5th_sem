#! /bin/sh

#Power of a number

read -p "Enter number and power" num pow

num2=num
if [ $pow -eq 0 ]
then
	echo $num
	exit 1
else
	for((i=1;i<pow;i++))
	do
		num2=$(($num2*$num))
	done
fi
echo $num2
