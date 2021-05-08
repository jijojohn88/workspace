#Question 1:
#You will be supplied with two data files in CSV format .
#The first file contains statistics about various dinosaurs. The second file contains additional data.
#Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g)
#Where g = 9.8 m/s^2 (gravitational constant)

cat dataset1.csv dataset2.csv | sort | grep -v NAME | cut -d "," -f1 | uniq > names.dat
names=`cat names.dat`
rm output.dat
for n in $names
do
	stride=`cat dataset2.csv | grep -i $n | cut -d "," -f2`
	length=`cat dataset1.csv | grep -i $n | cut -d "," -f2`
	if [[ ! -z "$length" && ! -z "$stride" ]]
	then
		speed=$(echo "scale=2; $stride/$length" | bc)
		speed=$(echo $speed-1|bc)
		speed=$(echo "$speed * sqrt ($length * 9.8) "|bc)
		echo $n $speed >> output.dat 2>&1
	else
		echo "parse error for name " $n
	fi
done
	echo "---------------------"
	cat output.dat | sort -nk2
