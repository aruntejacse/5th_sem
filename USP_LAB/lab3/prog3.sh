#! /bin/sh

#Write a shell program to find 
#biggest of three Numbers using  read 
#statement or positional parameter technique.

if [ $# -lt 3 ]
then
	echo "Provide data is the given format: $0 n1 n2 n3"
	exit 1
fi

echo "The greatest of the three positional parameters passed are:"
if [ $1 -gt $2 ] && [ $1 -gt $3 ]
then
    echo $1
elif [ $2 -gt $1 ] && [ $2 -gt $3 ]
then
    echo $2
else
    echo $3
fi

