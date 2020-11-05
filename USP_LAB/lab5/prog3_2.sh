 #!/bin/sh
#shell script to check whether an alphabet is Vowel or Consonant
echo "Enter an Alphabet:"
read ch
yes="$ch is a Vowel."
case $ch in
	a) echo "$yes";;
	A) echo "$yes";;
	e) echo "$yes";;
	E) echo "$yes";;
	i) echo "$yes";;
	I) echo "$yes";;
	o) echo "$yes";;
	O) echo "$yes";;
	u) echo "$yes";;
	U) echo "$yes";;
	*) echo "$ch is a Consonant.";;
esac
