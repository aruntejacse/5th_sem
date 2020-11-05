#!/bin/sh
#shell script to print fibonnaci series upto N

echo "Enter the value of N:"
read n
a=0
b=1
c=0
count=1
if [ $n -eq 1 ]
then
	echo "$a"
elif [ $n -eq 2 ] 
then 
	echo "$a $b"
else
	echo "$a"
	echo "$b"
	n=`expr $n - 2`
	while [ $count -le $n ]
	do
		c=`expr $a + $b`
		echo "$c"
		a=$b
		b=$c
		count=`expr $count + 1`
	done
	echo " "
fi
