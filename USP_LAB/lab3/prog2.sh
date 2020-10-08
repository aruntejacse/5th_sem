#! /bin/sh

#Write a Shell program to accept 
#two parameters perform File Test and display 
#their attributes with suitable message if not display a suitable 
#message to pass right number of arguments.

if [ $# -lt 2 ]
then
	echo "Enter two arguments"
	exit 1
elif [ $# -eq 2 ]
then
	if [ -f $1 ]
	then
		echo "File 1 arguments are:"
		ls -l $1
	else
		echo "1st argument is not a file"
	fi
	if [ -f $2 ]
	then
		echo "File 2 arguments are:"
		ls -l $2
	else
		echo "2nd argument is not a file"
	fi
else
	echo "Something went wrong"
fi 
