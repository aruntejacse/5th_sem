#! /bin/sh

#Write an Interactive Shell program to
#check whether a  number is zero,positive or Negative

read -p "Enter a number:" num

if [ $num -gt 0 ] 
then 
	echo "Positive number"
elif [ $num -lt 0 ] 
then
	echo "Negative number"
else
	echo "Zero"
fi
