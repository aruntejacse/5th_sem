#!/bin/sh
#Program to convert temperature from fahrenheit to celsius
echo "Enter the Temperature in fahrenheit: "
read t
a=`echo "$t - 32" | bc`
c=`echo "$a * 5 / 9" | bc` 
echo "$t\"F = $c\"C"
